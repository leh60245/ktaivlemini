package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AiCoverGenerationCompleted extends AbstractEvent {

    private Long jobId;
    private AICoverImageInfo imageInfo;
    private AICoverJobStatus status;
    private Date updatedAt;

    public AiCoverGenerationCompleted(AiCoverJob aggregate) {
        super(aggregate);
    }

    public AiCoverGenerationCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
