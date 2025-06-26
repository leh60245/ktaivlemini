package ktaivlemini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktaivlemini.AiPublicationAutomationApplication;
import lombok.Data;

@Entity
@Table(name = "AiCoverJob_table")
@Data
//<<< DDD / Aggregate Root
public class AiCoverJob {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;

    private AICoverJobStatus status;

    private AICoverImageInfo imageInfo;

    private Date createdAt;

    private Date updatedAt;

    private PublicationRequestId publicationRequestId;

    public static AiCoverJobRepository repository() {
        AiCoverJobRepository aiCoverJobRepository = AiPublicationAutomationApplication.applicationContext.getBean(
            AiCoverJobRepository.class
        );
        return aiCoverJobRepository;
    }

    //<<< Clean Arch / Port Method
    public void startAiCoverGeneration(
        StartAiCoverGenerationCommand startAiCoverGenerationCommand
    ) {
        //implement business logic here:

        AiCoverGenerationStarted aiCoverGenerationStarted = new AiCoverGenerationStarted(
            this
        );
        aiCoverGenerationStarted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void failAiCoverGeneration(
        FailAiCoverGenerationCommand failAiCoverGenerationCommand
    ) {
        //implement business logic here:

        AiCoverGenerationFailed aiCoverGenerationFailed = new AiCoverGenerationFailed(
            this
        );
        aiCoverGenerationFailed.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void createAiCoverJob(
        CreateAiCoverJobCommand createAiCoverJobCommand
    ) {
        //implement business logic here:

        AiCoverJobCreated aiCoverJobCreated = new AiCoverJobCreated(this);
        aiCoverJobCreated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void completeAiCoverGeneration(
        CompleteAiCoverGenerationCommand completeAiCoverGenerationCommand
    ) {
        //implement business logic here:

        AiCoverGenerationCompleted aiCoverGenerationCompleted = new AiCoverGenerationCompleted(
            this
        );
        aiCoverGenerationCompleted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
