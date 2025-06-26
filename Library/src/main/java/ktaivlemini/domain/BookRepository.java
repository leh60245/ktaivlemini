package ktaivlemini.domain;

import java.util.Date;
import java.util.List;
import ktaivlemini.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    @Query(
        value = "select book " +
        "from Book book " +
        "where(:bookId is null or book.bookId = :bookId)"
    )
    Book bookDetails(Long bookId);

    @Query(
        value = "select book " +
        "from Book book " +
        "where(book.bestsellerBadge = :bestsellerBadge) and (:page is null or book.page = :page) and (:size is null or book.size = :size)"
    )
    List<Book> bestsellerBookList(
        Boolean bestsellerBadge,
        Integer page,
        Integer size,
        Pageable pageable
    );

    @Query(
        value = "select book " +
        "from Book book " +
        "where(:status is null or book.status = :status) and (book.bestsellerBadge = :bestsellerBadge) and (:title is null or book.title like %:title%) and (:author is null or book.author like %:author%) and (:page is null or book.page = :page) and (:size is null or book.size = :size)"
    )
    List<Book> bookList(
        BookStatus status,
        Boolean bestsellerBadge,
        String title,
        String author,
        Integer page,
        Integer size,
        Pageable pageable
    );
}
