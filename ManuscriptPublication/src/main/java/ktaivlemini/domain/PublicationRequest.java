package ktaivlemini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktaivlemini.ManuscriptPublicationApplication;
import lombok.Data;

@Entity
@Table(name = "PublicationRequest_table")
@Data
//<<< DDD / Aggregate Root
public class PublicationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long publicationRequestId;

    private ManuscriptId manuscriptId;

    private String summary;

    private String coverImageUrl;

    private PublicationFormat format;

    private PublicationRequestStatus status;

    private Date publishedDate;

    private Date createdDate;

    private Date updatedDate;

    public static PublicationRequestRepository repository() {
        PublicationRequestRepository publicationRequestRepository = ManuscriptPublicationApplication.applicationContext.getBean(
            PublicationRequestRepository.class
        );
        return publicationRequestRepository;
    }

    //<<< Clean Arch / Port Method
    public void failPublication(FailPublicationCommand failPublicationCommand) {
        //implement business logic here:

        PublicationFailed publicationFailed = new PublicationFailed(this);
        publicationFailed.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void completePublication(
        CompletePublicationCommand completePublicationCommand
    ) {
        //implement business logic here:

        PublicationCompleted publicationCompleted = new PublicationCompleted(
            this
        );
        publicationCompleted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void startPublicationProcessing(
        StartPublicationProcessingCommand startPublicationProcessingCommand
    ) {
        //implement business logic here:

        PublicationProcessingStarted publicationProcessingStarted = new PublicationProcessingStarted(
            this
        );
        publicationProcessingStarted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
