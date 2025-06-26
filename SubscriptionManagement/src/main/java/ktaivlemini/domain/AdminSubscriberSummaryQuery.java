package ktaivlemini.domain;

import java.util.Date;
import lombok.Data;

@Data
public class AdminSubscriberSummaryQuery {

    private Long subscriberId;
    private SubscriptionStatus subscriptionStatus;
    private Integer points;
    private Long bookId;
    private Integer readCount;
    private Boolean isBestSeller;
    private Integer usedPoints;
    private Date usageDate;
    private Integer page;
    private Integer size;
}
