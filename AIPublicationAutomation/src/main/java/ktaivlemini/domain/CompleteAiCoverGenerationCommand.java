package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CompleteAiCoverGenerationCommand {

    private Long jobId;
    private AICoverImageInfo imageInfo;
}
