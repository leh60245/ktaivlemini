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
    collectionResourceRel = "aiCoverJobs",
    path = "aiCoverJobs"
)
public interface AiCoverJobRepository
    extends PagingAndSortingRepository<AiCoverJob, Long> {
    @Query(
        value = "select aiCoverJob " +
        "from AiCoverJob aiCoverJob " +
        "where(:jobId is null or aiCoverJob.jobId = :jobId)"
    )
    AiCoverJob aiCoverJobDetails(Long jobId);

    @Query(
        value = "select aiCoverJob " +
        "from AiCoverJob aiCoverJob " +
        "where(:status is null or aiCoverJob.status = :status) and (:publicationRequestId is null or aiCoverJob.publicationRequestId = :publicationRequestId) and (:createdAtFrom is null or aiCoverJob.createdAtFrom = :createdAtFrom) and (:createdAtTo is null or aiCoverJob.createdAtTo = :createdAtTo) and (:page is null or aiCoverJob.page = :page) and (:size is null or aiCoverJob.size = :size)"
    )
    List<AiCoverJob> aiCoverJobList(
        AICoverJobStatus status,
        PublicationRequestId publicationRequestId,
        Date createdAtFrom,
        Date createdAtTo,
        Integer page,
        Integer size,
        Pageable pageable
    );
}
