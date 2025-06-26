package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscriptionActivated extends AbstractEvent {

    private Long subscriberId;
    private SubscriptionPlanType planType;
    private Date activatedAt;
    private SubscriptionStatus status;

    public SubscriptionActivated(Subscriber aggregate) {
        super(aggregate);
    }

    public SubscriptionActivated() {
        super();
    }
}
//>>> DDD / Domain Event
