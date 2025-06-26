package ktaivlemini.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BestsellerBookListQuery {

    private Boolean bestsellerBadge;
    private Integer page;
    private Integer size;
}
