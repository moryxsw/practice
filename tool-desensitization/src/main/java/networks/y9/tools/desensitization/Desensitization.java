package networks.y9.tools.desensitization;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@JsonSerialize(using = DesensitizationSerialize.class)
public @interface Desensitization {

    // 类型默认手机号
    DesensitizationTypeEnum type() default DesensitizationTypeEnum.PHONE;

    // 开始位置
    int startInclude() default 0;

    // 结束位置
    int endExclude() default 0;



}
