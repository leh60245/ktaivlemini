package ktaivlemini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktaivlemini.LibraryApplication;
import lombok.Data;

@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String title;

    private String summary;

    private String keywords;

    private String coverImageUrl;

    private String category;

    private Integer subscriptionFee;

    private BookStatus status;

    private Integer readCount;

    private Boolean bestsellerBadge;

    public static BookRepository repository() {
        BookRepository bookRepository = LibraryApplication.applicationContext.getBean(
            BookRepository.class
        );
        return bookRepository;
    }

    //<<< Clean Arch / Port Method
    public void registerBookAuto(
        RegisterBookAutoCommand registerBookAutoCommand
    ) {
        //implement business logic here:

        BookAutoRegistered bookAutoRegistered = new BookAutoRegistered(this);
        bookAutoRegistered.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void readBook(ReadBookCommand readBookCommand) {
        //implement business logic here:

        BookRead bookRead = new BookRead(this);
        bookRead.publishAfterCommit();
        BookReadCountIncreased bookReadCountIncreased = new BookReadCountIncreased(
            this
        );
        bookReadCountIncreased.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void designateBookAsBestseller(
        DesignateBookAsBestsellerCommand designateBookAsBestsellerCommand
    ) {
        //implement business logic here:

        BookDesignatedAsBestseller bookDesignatedAsBestseller = new BookDesignatedAsBestseller(
            this
        );
        bookDesignatedAsBestseller.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void createBookPublishingRequest(
        CreateBookPublishingRequestCommand createBookPublishingRequestCommand
    ) {
        //implement business logic here:

        BookPublishingRequested bookPublishingRequested = new BookPublishingRequested(
            this
        );
        bookPublishingRequested.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void publishBook(PublishBookCommand publishBookCommand) {
        //implement business logic here:

        BookPublished bookPublished = new BookPublished(this);
        bookPublished.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
