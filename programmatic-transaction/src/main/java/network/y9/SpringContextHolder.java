package network.y9;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * SpringContextHolder
 *
 * @author wanghongyu10924
 * @since 2023/10/9
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {


    private static ApplicationContext applicationContext;

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    @Override public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext=applicationContext;
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     * @param name beanName
     * @param <T> bean
     * @return bean
     */
    public static <T> T getBean(String name) {
        checkApplicationContext();
        T bean = (T) applicationContext.getBean(name);
        if(bean==null){
            throw new IllegalArgumentException("bean name参数异常");
        }
        return bean;
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     * @param <T> bean
     * @param clazz beanClass
     * @return bean
     */
    @SuppressWarnings("unchecked")
    public static <T> Map<String, T> getBeanMap(Class<T> clazz)  {
        checkApplicationContext();
        Map<String, T> beansOfType =  applicationContext.getBeansOfType(clazz);
        if(beansOfType.isEmpty()){
            throw new IllegalArgumentException("bean clazz参数异常");
        }
        return beansOfType;
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     * @param clazz beanClass
     * @param <T> bean
     * @return bean
     */
    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        T bean = applicationContext.getBean(clazz);
        if(bean == null){
            throw new IllegalArgumentException("bean clazz参数异常");
        }
        return bean;
    }

    /**
     * 清除applicationContext静态变量.
     */
    public static void cleanApplicationContext() {
        applicationContext = null;
    }

    /**
     * 检查applicationContext
     */
    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException(
                    "applicationContext未注入,请检查配置");
        }
    }


}
