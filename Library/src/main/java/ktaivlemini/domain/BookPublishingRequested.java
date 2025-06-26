package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookPublishingRequested extends AbstractEvent {

    private String title;
    private String summary;
    private String keywords;
    private String originalFile;

    public BookPublishingRequested(Book aggregate) {
        super(aggregate);
    }

    public BookPublishingRequested() {
        super();
    }
}
//>>> DDD / Domain Event
