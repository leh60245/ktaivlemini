package ktaivlemini.domain;

import java.util.Date;
import lombok.Data;

@Data
public class AiCoverJobListQuery {

    private AICoverJobStatus status;
    private PublicationRequestId publicationRequestId;
    private Date createdAtFrom;
    private Date createdAtTo;
    private Integer page;
    private Integer size;
}
