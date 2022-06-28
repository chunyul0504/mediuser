package com.blue.mediuser.buyer;

import com.blue.mediuser.buyer.domain.repository.BuyerRepositorySupport;
import com.blue.mediuser.buyer.domain.dto.BuyerDto;
import com.blue.mediuser.buyer.domain.dto.BuyerIdentificationDto;
import com.blue.mediuser.buyer.domain.entity.Buyer;
import com.blue.mediuser.buyer.domain.repository.BuyerRepository;
import com.blue.mediuser.buyer.sub.BuyerSubService;
import com.blue.mediuser.common.constants.IdentificationTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class) // TODO. readOnly = true 옵션 확인해보기.
public class BuyerService {

    private final BuyerRepository buyerRepository;
    private final BuyerRepositorySupport buyerRepositorySupport;
    private final BuyerSubService buyerSubService;

    public BuyerService(BuyerRepository buyerRepository, BuyerRepositorySupport buyerRepositorySupport, BuyerSubService buyerSubService) {
        this.buyerRepository = buyerRepository;
        this.buyerRepositorySupport = buyerRepositorySupport;
        this.buyerSubService = buyerSubService;
    }


    private Long addBuyer(BuyerDto buyerDto) {
        return buyerRepository.save(buyerDto.insertEntity()).getSeq();
    }

    public void joinBuyer(BuyerIdentificationDto buyerIdentificationDto) {
        Long buyerSeq = this.addBuyer(buyerIdentificationDto.getBuyer());
        buyerIdentificationDto.setBuyer(BuyerDto.byCreate().seq(buyerSeq).build());
        buyerSubService.addBuyerIdentification(buyerIdentificationDto, IdentificationTypeEnum.MAIN.getCode());
    }

    public List<BuyerIdentificationDto> getBuyerList(BuyerIdentificationDto buyerIdentificationDto){
        return buyerRepositorySupport.findBuyerList(buyerIdentificationDto);
    }

    public BuyerIdentificationDto getBuyerInfo(Long buyerSeq){
        return buyerRepositorySupport.findBuyer(buyerSeq);
    }

    public void modifyBuyerState(Long buyerSeq, String buyerState){
        Buyer buyer = buyerRepository.findById(buyerSeq).orElseThrow(() -> new RuntimeException("modifyBuyerState buyer null"));
        BuyerDto buyerDto = BuyerDto.byEntity().buyer(buyer).build();
        buyerRepository.save(buyerDto.updateEntity(buyerDto, buyerState));
    }

}
