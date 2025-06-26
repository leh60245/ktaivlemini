package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegisterBookAutoCommand {

    private String title;
    private String summary;
    private String keywords;
    private String coverImageUrl;
    private String category;
    private Integer subscriptionFee;
}
