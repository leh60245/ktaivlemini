package ktaivlemini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktaivlemini.PointManagementApplication;
import lombok.Data;

@Entity
@Table(name = "PointWallet_table")
@Data
//<<< DDD / Aggregate Root
public class PointWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long walletId;

    private SubscriberId subscriberId;

    private String name;

    private Boolean ktCustomer;

    private Integer pointBalance;

    private WalletStatus status;

    private Date createdAt;

    private Date updatedAt;

    public static PointWalletRepository repository() {
        PointWalletRepository pointWalletRepository = PointManagementApplication.applicationContext.getBean(
            PointWalletRepository.class
        );
        return pointWalletRepository;
    }

    //<<< Clean Arch / Port Method
    public void registerSubscriber(
        RegisterSubscriberCommand registerSubscriberCommand
    ) {
        //implement business logic here:

        SignupPointsGranted signupPointsGranted = new SignupPointsGranted(this);
        signupPointsGranted.publishAfterCommit();
        SubscriberRegistered subscriberRegistered = new SubscriberRegistered(
            this
        );
        subscriberRegistered.publishAfterCommit();
        KtBonusPointsGranted ktBonusPointsGranted = new KtBonusPointsGranted(
            this
        );
        ktBonusPointsGranted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void readBookWithPoints(
        ReadBookWithPointsCommand readBookWithPointsCommand
    ) {
        //implement business logic here:

        PointDeducted pointDeducted = new PointDeducted(this);
        pointDeducted.publishAfterCommit();
        PointExhausted pointExhausted = new PointExhausted(this);
        pointExhausted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
