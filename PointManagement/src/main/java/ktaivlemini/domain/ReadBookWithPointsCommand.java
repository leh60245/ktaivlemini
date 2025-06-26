package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReadBookWithPointsCommand {

    private Long walletId;
    private Long bookId;
    private Integer pointCost;
}
