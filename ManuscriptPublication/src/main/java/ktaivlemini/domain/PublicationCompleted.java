package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PublicationCompleted extends AbstractEvent {

    private Long publicationRequestId;
    private String coverImageUrl;
    private PublicationRequestStatus status;
    private Date publishedDate;
    private Date updatedDate;

    public PublicationCompleted(PublicationRequest aggregate) {
        super(aggregate);
    }

    public PublicationCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
