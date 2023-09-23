package network.y9.optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Address
 *
 * @author wanghongyu10924
 * @since 2023/9/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    private String name;
    private Double latitude;
    private Double longitude;
}
