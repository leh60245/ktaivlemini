package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AuthorRegistrationRejected extends AbstractEvent {

    private Long authorId;
    private AuthorStatus status;
    private String rejectionReason;
    private Date rejectedAt;

    public AuthorRegistrationRejected(Author aggregate) {
        super(aggregate);
    }

    public AuthorRegistrationRejected() {
        super();
    }
}
//>>> DDD / Domain Event
