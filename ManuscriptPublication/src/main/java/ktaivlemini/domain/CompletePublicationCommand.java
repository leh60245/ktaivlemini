package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CompletePublicationCommand {

    private Long publicationRequestId;
    private String coverImageUrl;
    private Date publishedDate;
}
