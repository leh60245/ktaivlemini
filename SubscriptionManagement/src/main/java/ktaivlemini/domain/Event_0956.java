package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Event_0956 extends AbstractEvent {

    private Long id;

    public Event_0956(Subscriber aggregate) {
        super(aggregate);
    }

    public Event_0956() {
        super();
    }
}
//>>> DDD / Domain Event
