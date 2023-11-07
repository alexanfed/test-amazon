package com.example.demo.repository;

import com.example.demo.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT pd.item FROM PurchaseDetails pd " +
            "WHERE pd.purchase.user.id = :userId")
    List<Item> findItemsPurchasedByUserId(@Param("userId") Long userId);
}
