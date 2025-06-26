package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookAutoRegistered extends AbstractEvent {

    private Long bookId;
    private String title;
    private String summary;
    private String keywords;
    private String coverImageUrl;
    private String category;
    private Integer subscriptionFee;
    private BookStatus status;

    public BookAutoRegistered(Book aggregate) {
        super(aggregate);
    }

    public BookAutoRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
