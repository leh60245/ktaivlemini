package ktaivlemini.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BookListQuery {

    private BookStatus status;
    private Boolean bestsellerBadge;
    private String title;
    private String author;
    private Integer page;
    private Integer size;
}
