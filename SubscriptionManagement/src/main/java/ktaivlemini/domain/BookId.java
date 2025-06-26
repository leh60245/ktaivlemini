package ktaivlemini.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

//<<< DDD / Value Object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookId {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
}
//>>> DDD / Value Object
