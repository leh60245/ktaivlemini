package ktaivlemini.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PublicationRequestListQuery {

    private Long authorId;
    private PublicationRequestStatus status;
    private Date createdDateFrom;
    private Date createdDateTo;
    private Integer page;
    private Integer size;
}
