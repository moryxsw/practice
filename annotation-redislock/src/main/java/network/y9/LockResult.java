package network.y9;

import lombok.Data;
import org.redisson.api.RLock;

@Data
public class LockResult {

    private LockResultStatus lockResultStatus;

    private RLock rLock;

}
