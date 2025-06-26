package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReadBookWithSubscriptionCommand {

    private Long subscriberId;
    private Long bookId;
}
