package com.blue.mediuser.buyer.domain.repository;

import com.blue.mediuser.buyer.domain.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
