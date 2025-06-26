package ktaivlemini.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PublicationRequestStatusQuery {

    private AuthorId authorId;
    private ManuscriptStatus status;
    private Date requestedDateFrom;
    private Date requestedDateTo;
    private Integer page;
    private Integer size;
}
