package com.blue.mediuser.buyer;

import com.blue.mediuser.buyer.domain.dto.BuyerDto;
import com.blue.mediuser.buyer.domain.dto.BuyerIdentificationDto;
import com.blue.mediuser.buyer.domain.entity.Buyer;
import com.blue.mediuser.buyer.domain.entity.BuyerIdentification;
import com.blue.mediuser.buyer.domain.repository.BuyerIdentificationRepository;
import com.blue.mediuser.buyer.domain.repository.BuyerIdentificationRepositorySupport;
import com.blue.mediuser.buyer.domain.repository.BuyerRepository;
import com.blue.mediuser.buyer.sub.BuyerSubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class) // TODO. readOnly = true 옵션 확인해보기.
public class BuyerService {

    private final BuyerRepository buyerRepository;
    private final BuyerIdentificationRepository buyerIdentificationRepository;
    private final BuyerIdentificationRepositorySupport buyerIdentificationRepositorySupport;
    private final BuyerSubService buyerSubService;

    public BuyerService(BuyerRepository buyerRepository, BuyerIdentificationRepository buyerIdentificationRepository, BuyerIdentificationRepositorySupport buyerIdentificationRepositorySupport, BuyerSubService buyerSubService) {
        this.buyerRepository = buyerRepository;
        this.buyerIdentificationRepository = buyerIdentificationRepository;
        this.buyerIdentificationRepositorySupport = buyerIdentificationRepositorySupport;
        this.buyerSubService = buyerSubService;
    }

    private Long addBuyer(BuyerDto buyerDto){
        return  buyerRepository.save(buyerDto.insertEntity()).getSeq();
    }

    public List<BuyerIdentification> getBuyerInfo(Long buyerSeq){
        List<BuyerIdentification> buyerIdentificationList = buyerIdentificationRepository.findByBuyerSeqAndIdentificationType(buyerSeq, "M");
        return buyerIdentificationList;
    }

    public void joinBuyer(BuyerIdentificationDto buyerIdentificationDto){
        Long buyerSeq = this.addBuyer(buyerIdentificationDto.getBuyer());
        buyerIdentificationDto.setBuyer(BuyerDto.builder().seq(buyerSeq).build());
        buyerSubService.addBuyerIdentification(buyerIdentificationDto);
    }


}
