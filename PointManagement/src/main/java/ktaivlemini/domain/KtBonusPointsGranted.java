package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class KtBonusPointsGranted extends AbstractEvent {

    private Long walletId;
    private Long subscriberId;
    private Integer amount;
    private String transactionType;
    private Date createdAt;

    public KtBonusPointsGranted(PointWallet aggregate) {
        super(aggregate);
    }

    public KtBonusPointsGranted() {
        super();
    }
}
//>>> DDD / Domain Event
