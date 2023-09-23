package network.y9.optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Student
 *
 * @author wanghongyu10924
 * @since 2023/9/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private String name;

    private Integer age;

    private String id;

    private Address address;
}
