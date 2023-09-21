package network.y9.annotation.inheritance;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
// 添加元注解后子类可以获取到父类注解的value
@Inherited
public @interface TestAnnotation {

    String value();
}
