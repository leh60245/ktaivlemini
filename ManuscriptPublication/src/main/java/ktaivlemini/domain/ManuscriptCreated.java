package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ManuscriptCreated extends AbstractEvent {

    private Long manuscriptId;
    private AuthorId authorId;
    private String title;
    private String content;
    private ManuscriptType type;
    private ManuscriptStatus status;
    private Date createdDate;

    public ManuscriptCreated(Manuscript aggregate) {
        super(aggregate);
    }

    public ManuscriptCreated() {
        super();
    }
}
//>>> DDD / Domain Event
