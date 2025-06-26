package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import ktaivlemini.domain.*;
import ktaivlemini.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ManuscriptSaved extends AbstractEvent {

    private Long manuscriptId;
    private String title;
    private String content;
    private ManuscriptType type;
    private ManuscriptStatus status;
    private Date updatedDate;
    private SaveType saveType;

    public ManuscriptSaved(Manuscript aggregate) {
        super(aggregate);
    }

    public ManuscriptSaved() {
        super();
    }
}
//>>> DDD / Domain Event
