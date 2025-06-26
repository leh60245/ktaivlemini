package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscriptionExpired extends AbstractEvent {

    private Long subscriptionId;
    private SubscriberId subscriberId;
    private SubscriptionPlanType planType;
    private Date expiredAt;
    private SubscriptionStatus status;

    public SubscriptionExpired(Subscription aggregate) {
        super(aggregate);
    }

    public SubscriptionExpired() {
        super();
    }
}
//>>> DDD / Domain Event
