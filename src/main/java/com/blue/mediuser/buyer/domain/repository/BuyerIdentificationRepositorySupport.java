package com.blue.mediuser.buyer.domain.repository;

import com.blue.mediuser.buyer.domain.dto.BuyerIdentificationDto;
import com.blue.mediuser.buyer.domain.entity.QBuyer;
import com.blue.mediuser.buyer.domain.entity.QBuyerIdentification;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BuyerIdentificationRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    public BuyerIdentificationRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public BuyerIdentificationDto getBuyerInfoMain(Long buyerSeq, String identificationType){
        QBuyer buyer = QBuyer.buyer;
        QBuyerIdentification buyerIdentification = QBuyerIdentification.buyerIdentification;
        return jpaQueryFactory.select(Projections.constructor(BuyerIdentificationDto.class, buyer, buyerIdentification))
                .from(buyerIdentification)
                .leftJoin(buyer).on(buyer.seq.eq(buyerIdentification.buyer.seq))
                .where(
                          buyerIdentification.buyer.seq.eq(buyerSeq)
                        , buyerIdentification.identificationType.eq(identificationType)
                )
                .fetchOne();
    }
}
