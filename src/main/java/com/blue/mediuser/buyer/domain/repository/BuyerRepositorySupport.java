package com.blue.mediuser.buyer.domain.repository;

import com.blue.mediuser.buyer.domain.dto.BuyerIdentificationDto;
import com.blue.mediuser.buyer.domain.entity.QBuyer;
import com.blue.mediuser.buyer.domain.entity.QBuyerIdentification;
import com.blue.mediuser.common.constants.BuyerTypeEnum;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Slf4j
@Repository
public class BuyerRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public BuyerRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<BuyerIdentificationDto> findBuyerList(BuyerIdentificationDto buyerIdentificationDto) {
        log.info("findBuyerList start : {}", buyerIdentificationDto);
        QBuyer qBuyer = QBuyer.buyer;
        QBuyerIdentification qBuyerIdentification = QBuyerIdentification.buyerIdentification;

        // TODO. 페이징 내용 추가 해야함.
        return jpaQueryFactory.select(Projections.constructor(BuyerIdentificationDto.class, qBuyerIdentification, qBuyer))
                .from(qBuyerIdentification)
                .leftJoin(qBuyer).on(qBuyer.seq.eq(qBuyerIdentification.buyer.seq))
                .where(
                        // TODO. 각 조건에 대해서 like 절은 필요 없는건지? 기획서에 그런 내용 없음.
                          eqId(buyerIdentificationDto.getId())
                        , eqStaffName(buyerIdentificationDto.getStaffName())
                        , eqCorpName(buyerIdentificationDto.getBuyer().getCorpName())
                        ,  eqBuyerType(buyerIdentificationDto.getBuyer().getBuyerType())
                        , eqBuyerState(buyerIdentificationDto.getBuyer().getBuyerState()) // TODO. 계정 상태 값 관리하는 파일 만들기
                )
                .fetch();
    }

    public BuyerIdentificationDto findBuyer(Long buyerSeq) {
        log.info("findBuyer start : {}", buyerSeq);
        QBuyer qBuyer = QBuyer.buyer;
        QBuyerIdentification qBuyerIdentification = QBuyerIdentification.buyerIdentification;

        return jpaQueryFactory.select(Projections.constructor(BuyerIdentificationDto.class, qBuyerIdentification, qBuyer))
                .from(qBuyerIdentification)
                .leftJoin(qBuyer).on(qBuyer.seq.eq(qBuyerIdentification.buyer.seq))
                .where(qBuyer.seq.eq(buyerSeq))
                .fetchOne();
    }

    private BooleanExpression eqBuyerType(String buyerType) {
        if (!BuyerTypeEnum.existsCode(buyerType)) {
            return null;
        }
        return QBuyer.buyer.buyerType.eq(buyerType);
    }

    private BooleanExpression eqId(String id) {
        if (ObjectUtils.isEmpty(id)) {
            return null;
        }
        return QBuyerIdentification.buyerIdentification.id.eq(id);
    }

    private BooleanExpression eqCorpName(String corpName) {
        if (ObjectUtils.isEmpty(corpName)) {
            return null;
        }
        return QBuyer.buyer.corpName.eq(corpName);
    }

    private BooleanExpression eqStaffName(String staffName) {
        if (ObjectUtils.isEmpty(staffName)) {
            return null;
        }
        return QBuyerIdentification.buyerIdentification.staffName.eq(staffName);
    }

    private BooleanExpression eqBuyerState(String buyerState) {
        if (ObjectUtils.isEmpty(buyerState)) { // TODO. 계정 상태 값 관리하는 파일에서 코드 체크 추가.
            return null;
        }
        return QBuyer.buyer.buyerState.eq(buyerState);
    }

}
