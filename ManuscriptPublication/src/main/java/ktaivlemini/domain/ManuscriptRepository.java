package ktaivlemini.domain;

import java.util.Date;
import java.util.List;
import ktaivlemini.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "manuscripts",
    path = "manuscripts"
)
public interface ManuscriptRepository
    extends PagingAndSortingRepository<Manuscript, Long> {
    @Query(
        value = "select manuscript " +
        "from Manuscript manuscript " +
        "where(:manuscriptId is null or manuscript.manuscriptId = :manuscriptId)"
    )
    Manuscript manuscriptDetails(Long manuscriptId);

    @Query(
        value = "select manuscript " +
        "from Manuscript manuscript " +
        "where(:authorId is null or manuscript.authorId = :authorId) and (:status is null or manuscript.status = :status) and (:requestedDateFrom is null or manuscript.requestedDateFrom = :requestedDateFrom) and (:requestedDateTo is null or manuscript.requestedDateTo = :requestedDateTo) and (:page is null or manuscript.page = :page) and (:size is null or manuscript.size = :size)"
    )
    List<Manuscript> publicationRequestStatus(
        AuthorId authorId,
        ManuscriptStatus status,
        Date requestedDateFrom,
        Date requestedDateTo,
        Integer page,
        Integer size,
        Pageable pageable
    );

    @Query(
        value = "select manuscript " +
        "from Manuscript manuscript " +
        "where(:authorId is null or manuscript.authorId = :authorId) and (:status is null or manuscript.status = :status) and (:type is null or manuscript.type = :type) and (:createdDateFrom is null or manuscript.createdDateFrom = :createdDateFrom) and (:createdDateTo is null or manuscript.createdDateTo = :createdDateTo) and (:page is null or manuscript.page = :page) and (:size is null or manuscript.size = :size)"
    )
    List<Manuscript> manuscriptList(
        AuthorId authorId,
        ManuscriptStatus status,
        ManuscriptType type,
        Date createdDateFrom,
        Date createdDateTo,
        Integer page,
        Integer size,
        Pageable pageable
    );
}
