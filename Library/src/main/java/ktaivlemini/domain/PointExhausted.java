package ktaivlemini.domain;

import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class PointExhausted extends AbstractEvent {

    private Long walletId;
    private Long subscriberId;
    private Integer pointBalance;
    private Date exhaustedAt;
}
