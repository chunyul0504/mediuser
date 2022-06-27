package com.blue.mediuser.buyer.sub;

import com.blue.mediuser.buyer.domain.dto.BuyerIdentificationDto;
import com.blue.mediuser.buyer.domain.entity.BuyerIdentification;
import com.blue.mediuser.buyer.domain.repository.BuyerIdentificationRepository;
import com.blue.mediuser.common.constants.IdentificationTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class BuyerSubService {
    private final BuyerIdentificationRepository buyerIdentificationRepository;

    public BuyerSubService(BuyerIdentificationRepository buyerIdentificationRepository) {
        this.buyerIdentificationRepository = buyerIdentificationRepository;
    }

    public void addBuyerIdentification(BuyerIdentificationDto buyerIdentificationDto, String identificationType){
        buyerIdentificationRepository.save(buyerIdentificationDto.insertEntity(identificationType));
    }

    public List<BuyerIdentificationDto> getSubBuyerList(Long buyerSeq){
        List<BuyerIdentification> buyerIdentificationList = buyerIdentificationRepository.findAllByBuyerSeqOrderBySeqDesc(buyerSeq);
        return buyerIdentificationList.stream().map(
                list -> BuyerIdentificationDto
                        .entityByDto()
                        .buyerIdentification(list)
                        .ite(IdentificationTypeEnum.SUB)
                        .build())
                .collect(Collectors.toList());
    }

    public void modifySubBuyer(Long buyerIdentificationSeq, String state){
        BuyerIdentification buyerIdentification = buyerIdentificationRepository.findById(buyerIdentificationSeq).orElseThrow(() -> new RuntimeException("modifySubBuyer findById null"));
        BuyerIdentificationDto bid = BuyerIdentificationDto.entityByDto().buyerIdentification(buyerIdentification).ite(IdentificationTypeEnum.SUB).build();
        bid.modifyStateEntity();
    }


}
