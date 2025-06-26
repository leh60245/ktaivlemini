package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PublicationFailed extends AbstractEvent {

    private Long publicationRequestId;
    private String failureReason;
    private PublicationRequestStatus status;
    private Date updatedDate;

    public PublicationFailed(PublicationRequest aggregate) {
        super(aggregate);
    }

    public PublicationFailed() {
        super();
    }
}
//>>> DDD / Domain Event
