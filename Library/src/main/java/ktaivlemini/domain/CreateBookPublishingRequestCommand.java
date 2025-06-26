package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateBookPublishingRequestCommand {

    private String title;
    private String summary;
    private String keywords;
    private String originalFile;
}
