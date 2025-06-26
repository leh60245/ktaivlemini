package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class StartPublicationProcessingCommand {

    private Long publicationRequestId;
}
