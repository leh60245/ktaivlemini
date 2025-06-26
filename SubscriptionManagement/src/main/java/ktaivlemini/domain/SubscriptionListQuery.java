package ktaivlemini.domain;

import java.util.Date;
import lombok.Data;

@Data
public class SubscriptionListQuery {

    private SubscriberId subscriberId;
    private SubscriptionStatus status;
    private SubscriptionPlanType planType;
    private Date startDateFrom;
    private Date startDateTo;
    private Integer page;
    private Integer size;
}
