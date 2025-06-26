package ktaivlemini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegisterSubscriberCommand {

    private Long subscriberId;
    private String name;
    private Boolean ktCustomer;
}
