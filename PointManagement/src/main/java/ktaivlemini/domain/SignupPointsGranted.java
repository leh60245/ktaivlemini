package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class SignupPointsGranted extends AbstractEvent {

    private Long walletId;
    private Long subscriberId;
    private Integer amount;
    private String transactionType;
    private Date createdAt;

    public SignupPointsGranted(PointWallet aggregate) {
        super(aggregate);
    }

    public SignupPointsGranted() {
        super();
    }
}
//>>> DDD / Domain Event
