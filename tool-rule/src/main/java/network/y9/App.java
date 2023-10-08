package network.y9;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        //1. 定义规则  init rule
        NationalityRule nationalityRule = new NationalityRule();
        NameRule nameRule = new NameRule();

        //2. 构造需要的数据 create dto
        RuleDTO dto = new RuleDTO();
        dto.setAge(5);
        dto.setName("haha");
        dto.setAddress("南京");

        //3. 通过以链式调用构建和执行 rule execute
        boolean ruleResult = RuleService
                .create()
                .and(Arrays.asList(nationalityRule))
                .or(Arrays.asList(nameRule))
                .execute(dto);
        System.out.println("this rule execute result :" + ruleResult);
    }

}

