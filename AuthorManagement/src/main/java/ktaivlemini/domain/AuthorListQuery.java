package ktaivlemini.domain;

import java.util.Date;
import lombok.Data;

@Data
public class AuthorListQuery {

    private AuthorStatus status;
    private String name;
}
