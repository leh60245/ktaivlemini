package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AiCoverJobCreated extends AbstractEvent {

    private Long jobId;
    private PublicationRequestId publicationRequestId;
    private AICoverJobStatus status;
    private Date createdAt;

    public AiCoverJobCreated(AiCoverJob aggregate) {
        super(aggregate);
    }

    public AiCoverJobCreated() {
        super();
    }
}
//>>> DDD / Domain Event
