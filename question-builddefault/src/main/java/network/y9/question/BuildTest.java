package network.y9.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
// 生成set方法返回this对象，代替默认返回void
//@Accessors(chain = true)
// 同上，只是没有get set前缀
//@Accessors(fluent = true)
// set方法忽略指定前缀
//@Accessors(prefix = "f")
public class BuildTest {

    private String type;

    /**
     * 使用build后new初始化有默认值，build 初始化默认值会丢失
     * 用此注解指定默认值后，build和new 初始化都会有默认值
     */
//    @Builder.Default
    private Integer value = 0;
}
