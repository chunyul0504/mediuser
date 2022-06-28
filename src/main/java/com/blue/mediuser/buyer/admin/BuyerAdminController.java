package com.blue.mediuser.buyer.admin;

import com.blue.mediuser.buyer.BuyerService;
import com.blue.mediuser.buyer.domain.dto.BuyerIdentificationDto;
import com.blue.mediuser.common.util.ApiListResponse;
import com.blue.mediuser.common.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * buyer admin controller
 */
@Slf4j
@RestController
@RequestMapping("/buyer/admin")
public class BuyerAdminController {

    private final BuyerService buyerService;

    public BuyerAdminController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    // 병의원, 도매업 리스트 조회.
    @GetMapping
    public ResponseEntity<ApiResponse> getBuyerList(@RequestBody BuyerIdentificationDto buyerIdentificationDto) {
        log.info("getBuyerList : {}", buyerIdentificationDto);
        List<BuyerIdentificationDto> buyerIdentificationDtoList = buyerService.getBuyerList(buyerIdentificationDto);
        return ResponseEntity.ok(ApiResponse.success(new ApiListResponse(buyerIdentificationDtoList, buyerIdentificationDtoList.size())));
    }

    // 병의원, 도매업 사업자 정보 조회.
    @GetMapping("/{buyerSeq}")
    public ResponseEntity<ApiResponse> getBuyerInfo(@PathVariable Long buyerSeq) {
        log.info("getBuyerInfo : {}", buyerSeq);
        return ResponseEntity.ok(ApiResponse.success(buyerService.getBuyerInfo(buyerSeq)));
    }

    // 병의원, 도매업 승인처리
    @PatchMapping("/{buyerSeq}")
    public ResponseEntity<ApiResponse> modifyBuyerState(@PathVariable Long buyerSeq, @RequestParam String buyerState) {
        log.info("getBuyerInfo : {}, {}", buyerSeq, buyerState);
        buyerService.modifyBuyerState(buyerSeq, buyerState);
        return ResponseEntity.ok(ApiResponse.success());
    }

}
