package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PublicationProcessingStarted extends AbstractEvent {

    private Long publicationRequestId;
    private PublicationRequestStatus status;
    private Date updatedDate;

    public PublicationProcessingStarted(PublicationRequest aggregate) {
        super(aggregate);
    }

    public PublicationProcessingStarted() {
        super();
    }
}
//>>> DDD / Domain Event
