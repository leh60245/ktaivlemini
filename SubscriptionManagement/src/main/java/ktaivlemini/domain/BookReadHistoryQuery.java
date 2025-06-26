package ktaivlemini.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BookReadHistoryQuery {

    private Long subscriberId;
    private Long bookId;
    private Date readAtFrom;
    private Date readAtTo;
    private Integer page;
    private Integer size;
}
