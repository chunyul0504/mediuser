package com.blue.mediuser.buyer.domain.repository;

import com.blue.mediuser.buyer.domain.entity.BuyerIdentification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerIdentificationRepository extends JpaRepository<BuyerIdentification, Long> {
    List<BuyerIdentification> findByBuyerSeqAndIdentificationType(Long buyerSeq, String identificationType);
}
