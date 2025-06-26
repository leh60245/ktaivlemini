package ktaivlemini.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ManuscriptListQuery {

    private AuthorId authorId;
    private ManuscriptStatus status;
    private ManuscriptType type;
    private Date createdDateFrom;
    private Date createdDateTo;
    private Integer page;
    private Integer size;
}
