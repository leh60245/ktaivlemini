package ktaivlemini.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PointTransactionHistoryQuery {

    private Long walletId;
    private String transactionType;
    private Date createdAtFrom;
    private Date createdAtTo;
    private Integer page;
    private Integer size;
}
