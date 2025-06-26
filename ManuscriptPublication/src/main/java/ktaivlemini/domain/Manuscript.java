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
@Table(name = "Manuscript_table")
@Data
//<<< DDD / Aggregate Root
public class Manuscript {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long manuscriptId;

    private AuthorId authorId;

    private String title;

    private String content;

    private ManuscriptType type;

    private ManuscriptStatus status;

    private Date createdDate;

    private Date updatedDate;

    public static ManuscriptRepository repository() {
        ManuscriptRepository manuscriptRepository = ManuscriptPublicationApplication.applicationContext.getBean(
            ManuscriptRepository.class
        );
        return manuscriptRepository;
    }

    //<<< Clean Arch / Port Method
    public void createManuscript(
        CreateManuscriptCommand createManuscriptCommand
    ) {
        //implement business logic here:

        ManuscriptCreated manuscriptCreated = new ManuscriptCreated(this);
        manuscriptCreated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void saveManuscript(SaveManuscriptCommand saveManuscriptCommand) {
        //implement business logic here:

        ManuscriptSaved manuscriptSaved = new ManuscriptSaved(this);
        manuscriptSaved.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
