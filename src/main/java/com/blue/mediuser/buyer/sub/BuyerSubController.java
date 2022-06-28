package com.blue.mediuser.buyer.sub;

import com.blue.mediuser.buyer.BuyerService;
import com.blue.mediuser.buyer.domain.dto.BuyerIdentificationDto;
import com.blue.mediuser.common.constants.IdentificationTypeEnum;
import com.blue.mediuser.common.util.ApiListResponse;
import com.blue.mediuser.common.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/buyer/sub")
public class BuyerSubController {

    private final BuyerSubService buyerSubService;

    public BuyerSubController(BuyerSubService buyerSubService) {
        this.buyerSubService = buyerSubService;
    }

    // 부 계정 회원 가입.
    @PostMapping
    public ResponseEntity<ApiResponse> addSubBuyer(@RequestBody BuyerIdentificationDto buyerIdentificationDto) {
        log.info("addSubBuyer : {}", buyerIdentificationDto);
        buyerSubService.addBuyerIdentification(buyerIdentificationDto, IdentificationTypeEnum.SUB.getCode());
        return ResponseEntity.ok(ApiResponse.success());
    }

}
