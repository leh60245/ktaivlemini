package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AiCoverGenerationFailed extends AbstractEvent {

    private Long jobId;
    private String failureReason;
    private AICoverJobStatus status;
    private Date updatedAt;

    public AiCoverGenerationFailed(AiCoverJob aggregate) {
        super(aggregate);
    }

    public AiCoverGenerationFailed() {
        super();
    }
}
//>>> DDD / Domain Event
