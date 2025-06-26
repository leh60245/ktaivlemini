package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookDesignatedAsBestseller extends AbstractEvent {

    private Long bookId;
    private Boolean bestsellerBadge;
    private BookStatus status;

    public BookDesignatedAsBestseller(Book aggregate) {
        super(aggregate);
    }

    public BookDesignatedAsBestseller() {
        super();
    }
}
//>>> DDD / Domain Event
