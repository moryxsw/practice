package network.y9;


import jakarta.annotation.Resource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;


@Aspect
@Component
public class LockAnnotationParser {

    @Resource
    private LockManager lockManager;


    @Pointcut(value = "@annotation(network.y9.Lock)")
    private void cutMethod(){

    }


    @Around(value = "cutMethod() && @annotation(lock)")
    public Object parser(ProceedingJoinPoint point, Lock lock) throws Throwable{
        String value = lock.value();
        if (isEl(value)) {
            value = getByEl(value, point);
        }
        LockResult lockResult = lockManager.lock(getRealLockKey(value), lock.expireTime(), lock.waitTime());
        try {
            return point.proceed();
        } finally {
            lockManager.unlock(lockResult.getRLock());
        }


    }

    /**
     * 解析 SpEL 表达式并返回其值
     */
    private String getByEl(String el, ProceedingJoinPoint point) {
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        String[] paramNames = getParameterNames(method);
        Object[] arguments = point.getArgs();

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(el);
        EvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < arguments.length; i++) {
            context.setVariable(paramNames[i], arguments[i]);
        }

        return expression.getValue(context, String.class);
    }


    /**
     * 获取方法参数名列表
     */
    private String[] getParameterNames(Method method) {
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        return u.getParameterNames(method);
    }

    private boolean isEl(String str) {
        return str.contains("#");
    }

    /**
     * 锁键值
     */
    private String getRealLockKey(String value) {
        return String.format("lock:%s", value);
    }


}
