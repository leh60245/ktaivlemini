package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class FailPublicationCommand {

    private Long publicationRequestId;
    private String failureReason;
}
