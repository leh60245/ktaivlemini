package ktaivlemini.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import ktaivlemini.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/books")
@Transactional
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(
        value = "/booksregisterbookauto",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Book registerBookAuto(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RegisterBookAutoCommand registerBookAutoCommand
    ) throws Exception {
        System.out.println("##### /book/registerBookAuto  called #####");
        Book book = new Book();
        book.registerBookAuto(registerBookAutoCommand);
        bookRepository.save(book);
        return book;
    }

    @RequestMapping(
        value = "/booksreadbook",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Book readBook(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ReadBookCommand readBookCommand
    ) throws Exception {
        System.out.println("##### /book/readBook  called #####");
        Book book = new Book();
        book.readBook(readBookCommand);
        bookRepository.save(book);
        return book;
    }

    @RequestMapping(
        value = "/booksdesignatebookasbestseller",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Book designateBookAsBestseller(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody DesignateBookAsBestsellerCommand designateBookAsBestsellerCommand
    ) throws Exception {
        System.out.println(
            "##### /book/designateBookAsBestseller  called #####"
        );
        Book book = new Book();
        book.designateBookAsBestseller(designateBookAsBestsellerCommand);
        bookRepository.save(book);
        return book;
    }

    @RequestMapping(
        value = "/bookscreatebookpublishingrequest",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Book createBookPublishingRequest(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateBookPublishingRequestCommand createBookPublishingRequestCommand
    ) throws Exception {
        System.out.println(
            "##### /book/createBookPublishingRequest  called #####"
        );
        Book book = new Book();
        book.createBookPublishingRequest(createBookPublishingRequestCommand);
        bookRepository.save(book);
        return book;
    }

    @RequestMapping(
        value = "/bookspublishbook",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Book publishBook(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody PublishBookCommand publishBookCommand
    ) throws Exception {
        System.out.println("##### /book/publishBook  called #####");
        Book book = new Book();
        book.publishBook(publishBookCommand);
        bookRepository.save(book);
        return book;
    }
}
//>>> Clean Arch / Inbound Adaptor
