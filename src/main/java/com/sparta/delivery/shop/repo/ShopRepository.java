package com.sparta.delivery.shop.repo;

import com.sparta.delivery.shop.entity.Store;
import com.sparta.delivery.shop.statusEnum.ShopDataStatus;
import com.sparta.delivery.shop.statusEnum.ShopPrivacyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShopRepository extends JpaRepository<Store , UUID>{

    @Query("SELECT s FROM Store s WHERE s.shopId = :shopId  AND s.deleteStatus = :deleteStatus")
    Optional<Store> findByIdAndDeleteStatus(@Param("shopId") UUID shopId , @Param("deleteStatus") ShopDataStatus deleteStatus);

    @Query("SELECT s FROM Store s WHERE s.shopId = :shopId  AND s.privacyStatus = :privacyStatus")
    Optional<Store> findByIdAndPrivacyStatus(@Param("shopId") UUID shopId , @Param("privacyStatus") ShopPrivacyStatus shopPrivacyStatus);
}
