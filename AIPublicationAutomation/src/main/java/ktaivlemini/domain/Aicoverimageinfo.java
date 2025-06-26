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
public class Aicoverimageinfo {

    private String imageUrl;

    private String thumbnailUrl;

    private Integer width;

    private Integer height;
}
//>>> DDD / Value Object
