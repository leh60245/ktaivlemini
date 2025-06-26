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
    collectionResourceRel = "pointWallets",
    path = "pointWallets"
)
public interface PointWalletRepository
    extends PagingAndSortingRepository<PointWallet, Long> {
    @Query(
        value = "select pointWallet " +
        "from PointWallet pointWallet " +
        "where(:walletId is null or pointWallet.walletId = :walletId)"
    )
    PointWallet pointWalletDetails(Long walletId);

    @Query(
        value = "select pointWallet " +
        "from PointWallet pointWallet " +
        "where(:walletId is null or pointWallet.walletId = :walletId)"
    )
    PointWallet pointExhaustedStatus(Long walletId);

    @Query(
        value = "select pointWallet " +
        "from PointWallet pointWallet " +
        "where(:walletId is null or pointWallet.walletId = :walletId) and (:transactionType is null or pointWallet.transactionType like %:transactionType%) and (:createdAtFrom is null or pointWallet.createdAtFrom = :createdAtFrom) and (:createdAtTo is null or pointWallet.createdAtTo = :createdAtTo) and (:page is null or pointWallet.page = :page) and (:size is null or pointWallet.size = :size)"
    )
    List<PointWallet> pointTransactionHistory(
        Long walletId,
        String transactionType,
        Date createdAtFrom,
        Date createdAtTo,
        Integer page,
        Integer size,
        Pageable pageable
    );
}
