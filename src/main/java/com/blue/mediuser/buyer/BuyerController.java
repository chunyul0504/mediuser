package com.blue.mediuser.buyer;

import com.blue.mediuser.buyer.domain.dto.BuyerDto;
import com.blue.mediuser.buyer.domain.dto.BuyerIdentificationDto;
import com.blue.mediuser.common.constants.IdentificationTypeEnum;
import com.blue.mediuser.common.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * buyer controller
 */
@Slf4j
@RestController
@RequestMapping("/buyer")
public class BuyerController {

    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }


    // 메인 계정 - 회원 가입.
    @PostMapping
    public ResponseEntity<ApiResponse> addMainBuyer(@RequestBody BuyerIdentificationDto buyerIdentificationDto) {
        log.info("addMainBuyer : {}", buyerIdentificationDto);
        buyerService.joinBuyer(buyerIdentificationDto);
        return ResponseEntity.ok(ApiResponse.success());
    }

    // 메인 계정 - 정보 단건 조회.
    @GetMapping("/{buyerSeq}")
    public ResponseEntity<ApiResponse> getBuyer(@PathVariable Long buyerSeq) {
        log.info("getBuyer : {}", buyerSeq);
        return ResponseEntity.ok(ApiResponse.success(buyerService.getBuyerInfo(buyerSeq)));
    }

    // 메인 계정 - 정보 수정.
    @PatchMapping("/{buyerSeq}")
    public ResponseEntity<ApiResponse> modifyBuyer(@PathVariable Long buyerSeq, @RequestBody BuyerIdentificationDto buyerIdentificationDto) {
        log.info("getBuyer : {}, {}", buyerSeq, buyerIdentificationDto);
        buyerService.modifyBuyer(buyerSeq, buyerIdentificationDto);
        return ResponseEntity.ok(ApiResponse.success());
    }

}
