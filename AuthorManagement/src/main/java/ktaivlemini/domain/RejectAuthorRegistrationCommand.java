package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RejectAuthorRegistrationCommand {

    private Long authorId;
    private String rejectionReason;
}
