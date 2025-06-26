package ktaivlemini.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PointUsageHistoryQuery {

    private Long subscriberId;
    private Date createdAtFrom;
    private Date createdAtTo;
    private Integer page;
    private Integer size;
}
