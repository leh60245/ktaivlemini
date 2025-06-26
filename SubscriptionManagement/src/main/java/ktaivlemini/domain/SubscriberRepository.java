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
    collectionResourceRel = "subscribers",
    path = "subscribers"
)
public interface SubscriberRepository
    extends PagingAndSortingRepository<Subscriber, Long> {
    @Query(
        value = "select subscriber " +
        "from Subscriber subscriber " +
        "where(:subscriberId is null or subscriber.subscriberId = :subscriberId) and (:bookId is null or subscriber.bookId = :bookId) and (:readAtFrom is null or subscriber.readAtFrom = :readAtFrom) and (:readAtTo is null or subscriber.readAtTo = :readAtTo) and (:page is null or subscriber.page = :page) and (:size is null or subscriber.size = :size)"
    )
    List<Subscriber> bookReadHistory(
        Long subscriberId,
        Long bookId,
        Date readAtFrom,
        Date readAtTo,
        Integer page,
        Integer size,
        Pageable pageable
    );

    @Query(
        value = "select subscriber " +
        "from Subscriber subscriber " +
        "where(:subscriberId is null or subscriber.subscriberId = :subscriberId) and (:subscriptionStatus is null or subscriber.subscriptionStatus = :subscriptionStatus) and (:points is null or subscriber.points = :points) and (:bookId is null or subscriber.bookId = :bookId) and (:readCount is null or subscriber.readCount = :readCount) and (subscriber.isBestSeller = :isBestSeller) and (:usedPoints is null or subscriber.usedPoints = :usedPoints) and (:usageDate is null or subscriber.usageDate = :usageDate) and (:page is null or subscriber.page = :page) and (:size is null or subscriber.size = :size)"
    )
    List<Subscriber> adminSubscriberSummary(
        Long subscriberId,
        SubscriptionStatus subscriptionStatus,
        Integer points,
        Long bookId,
        Integer readCount,
        Boolean isBestSeller,
        Integer usedPoints,
        Date usageDate,
        Integer page,
        Integer size,
        Pageable pageable
    );

    @Query(
        value = "select subscriber " +
        "from Subscriber subscriber " +
        "where(:subscriberId is null or subscriber.subscriberId = :subscriberId)"
    )
    Subscriber subscriptionStatus(Long subscriberId);

    @Query(
        value = "select subscriber " +
        "from Subscriber subscriber " +
        "where(:subscriberId is null or subscriber.subscriberId = :subscriberId) and (:createdAtFrom is null or subscriber.createdAtFrom = :createdAtFrom) and (:createdAtTo is null or subscriber.createdAtTo = :createdAtTo) and (:page is null or subscriber.page = :page) and (:size is null or subscriber.size = :size)"
    )
    List<Subscriber> pointUsageHistory(
        Long subscriberId,
        Date createdAtFrom,
        Date createdAtTo,
        Integer page,
        Integer size,
        Pageable pageable
    );

    @Query(
        value = "select subscriber " +
        "from Subscriber subscriber " +
        "where(:subscriberId is null or subscriber.subscriberId = :subscriberId)"
    )
    Subscriber subscriberDetails(Long subscriberId);
}
