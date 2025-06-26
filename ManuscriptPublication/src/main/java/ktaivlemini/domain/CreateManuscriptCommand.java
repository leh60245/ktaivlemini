package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateManuscriptCommand {

    private AuthorId authorId;
    private String title;
    private String content;
    private ManuscriptType type;
}
