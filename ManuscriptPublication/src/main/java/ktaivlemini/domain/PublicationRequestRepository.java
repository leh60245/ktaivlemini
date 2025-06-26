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
    collectionResourceRel = "publicationRequests",
    path = "publicationRequests"
)
public interface PublicationRequestRepository
    extends PagingAndSortingRepository<PublicationRequest, Long> {
    @Query(
        value = "select publicationRequest " +
        "from PublicationRequest publicationRequest " +
        "where(:authorId is null or publicationRequest.authorId = :authorId) and (:status is null or publicationRequest.status = :status) and (:createdDateFrom is null or publicationRequest.createdDateFrom = :createdDateFrom) and (:createdDateTo is null or publicationRequest.createdDateTo = :createdDateTo) and (:page is null or publicationRequest.page = :page) and (:size is null or publicationRequest.size = :size)"
    )
    List<PublicationRequest> publicationRequestList(
        Long authorId,
        PublicationRequestStatus status,
        Date createdDateFrom,
        Date createdDateTo,
        Integer page,
        Integer size,
        Pageable pageable
    );

    @Query(
        value = "select publicationRequest " +
        "from PublicationRequest publicationRequest " +
        "where(:publicationRequestId is null or publicationRequest.publicationRequestId = :publicationRequestId)"
    )
    PublicationRequest publicationRequestDetails(Long publicationRequestId);
}
