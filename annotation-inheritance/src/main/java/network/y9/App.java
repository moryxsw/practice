package network.y9;

import network.y9.annotation.inheritance.Parent;
import network.y9.annotation.inheritance.Son;
import network.y9.annotation.inheritance.TestAnnotation;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.util.Objects;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws NoSuchMethodException {

        Parent parent = new Parent();
        System.out.println( "parent class annotation is " + getAnnotation(parent.getClass().getAnnotation(TestAnnotation.class)));
        System.out.println("parent method annotation is " + getAnnotation(parent.getClass().getMethod("method").getAnnotation(TestAnnotation.class)));

        Son son = new Son();
        System.out.println("son class annotation is " + getAnnotation(son.getClass().getAnnotation(TestAnnotation.class)));
        System.out.println("son method annotation is " + getAnnotation(son.getClass().getMethod("method").getAnnotation(TestAnnotation.class)));
        // 这个spring 工具类可以获取到子类方法上的父类注解
        TestAnnotation annotation = AnnotatedElementUtils.findMergedAnnotation(son.getClass().getMethod("method"), TestAnnotation.class);
        assert annotation != null;
        System.out.println("annotation is " + annotation.value());

    }

    private static String getAnnotation(TestAnnotation request){
        if(Objects.isNull(request)){
            return "没有注解";
        }
        return request.value();
    }
}
