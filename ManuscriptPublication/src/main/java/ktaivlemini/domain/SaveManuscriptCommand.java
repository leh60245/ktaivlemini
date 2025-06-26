package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SaveManuscriptCommand {

    private Long manuscriptId;
    private String title;
    private String content;
    private ManuscriptType type;
    private SaveType saveType;
}
