package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AiCoverGenerationStarted extends AbstractEvent {

    private Long jobId;
    private AICoverJobStatus status;
    private Date updatedAt;

    public AiCoverGenerationStarted(AiCoverJob aggregate) {
        super(aggregate);
    }

    public AiCoverGenerationStarted() {
        super();
    }
}
//>>> DDD / Domain Event
