package com.blue.mediuser.buyer.sub;

import com.blue.mediuser.buyer.domain.dto.BuyerIdentificationDto;
import com.blue.mediuser.buyer.domain.repository.BuyerIdentificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
