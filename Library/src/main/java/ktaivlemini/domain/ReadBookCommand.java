package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReadBookCommand {

    private Long bookId;
    private Long subscriberId;
}
