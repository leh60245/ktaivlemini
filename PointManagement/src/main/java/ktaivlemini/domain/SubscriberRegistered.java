package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscriberRegistered extends AbstractEvent {

    private Long walletId;
    private Long subscriberId;
    private String name;
    private Boolean ktCustomer;
    private Integer pointBalance;
    private Date createdAt;

    public SubscriberRegistered(PointWallet aggregate) {
        super(aggregate);
    }

    public SubscriberRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
