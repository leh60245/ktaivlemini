package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AuthorAccessGranted extends AbstractEvent {

    private Long authorId;
    private AuthorStatus status;
    private Date grantedAt;

    public AuthorAccessGranted(Author aggregate) {
        super(aggregate);
    }

    public AuthorAccessGranted() {
        super();
    }
}
//>>> DDD / Domain Event
