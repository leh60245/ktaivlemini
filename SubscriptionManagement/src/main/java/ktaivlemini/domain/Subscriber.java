package ktaivlemini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktaivlemini.SubscriptionManagementApplication;
import lombok.Data;

@Entity
@Table(name = "Subscriber_table")
@Data
//<<< DDD / Aggregate Root
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subscriberId;

    private String name;

    private String email;

    private Boolean isKTUser;

    private Integer points;

    private SubscriptionStatus subscriptionStatus;

    private BookId bookId;

    public static SubscriberRepository repository() {
        SubscriberRepository subscriberRepository = SubscriptionManagementApplication.applicationContext.getBean(
            SubscriberRepository.class
        );
        return subscriberRepository;
    }

    //<<< Clean Arch / Port Method
    public void activateSubscription(
        ActivateSubscriptionCommand activateSubscriptionCommand
    ) {
        //implement business logic here:

        SubscriptionActivated subscriptionActivated = new SubscriptionActivated(
            this
        );
        subscriptionActivated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void readBookWithSubscription(
        ReadBookWithSubscriptionCommand readBookWithSubscriptionCommand
    ) {
        //implement business logic here:

        Event_0956 event_0956 = new Event_0956(this);
        event_0956.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void requestSubscription(
        RequestSubscriptionCommand requestSubscriptionCommand
    ) {
        //implement business logic here:

        SubscriptionRequested subscriptionRequested = new SubscriptionRequested(
            this
        );
        subscriptionRequested.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
