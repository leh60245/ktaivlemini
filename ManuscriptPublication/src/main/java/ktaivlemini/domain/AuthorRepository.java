package ktaivlemini.domain;

import java.util.Date;
import java.util.List;
import ktaivlemini.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "authors", path = "authors")
public interface AuthorRepository
    extends PagingAndSortingRepository<Author, Long> {
    @Query(
        value = "select author " +
        "from Author author " +
        "where(:status is null or author.status = :status) and (:name is null or author.name like %:name%)"
    )
    List<Author> authorList(
        AuthorStatus status,
        String name,
        Pageable pageable
    );

    @Query(
        value = "select author " +
        "from Author author " +
        "where(:authorId is null or author.authorId = :authorId)"
    )
    Author authorDetails(Long authorId);

    @Query(
        value = "select author " +
        "from Author author " +
        "where(:authorId is null or author.authorId = :authorId)"
    )
    Author authorStatistics(Long authorId);
}
