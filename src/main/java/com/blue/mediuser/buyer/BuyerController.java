package com.blue.mediuser.buyer;

import com.blue.mediuser.buyer.domain.dto.BuyerDto;
import com.blue.mediuser.buyer.domain.dto.BuyerIdentificationDto;
import com.blue.mediuser.common.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/buyer")
public class BuyerController {

    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addBuyer(@RequestBody BuyerIdentificationDto buyerIdentificationDto) {
        log.info("addBuyer : {}", buyerIdentificationDto);
        buyerService.joinBuyer(buyerIdentificationDto);
        return ResponseEntity.ok(ApiResponse.success());
    }

    @GetMapping("/{buyerSeq}")
    public ResponseEntity<ApiResponse> getBuyer(@PathVariable Long buyerSeq) {
        log.info("getBuyer : {}", buyerSeq);
        return ResponseEntity.ok(ApiResponse.success(buyerService.getBuyerInfo(buyerSeq)));
    }

//    @PatchMapping("/{buyerSeq}")
//    public ResponseEntity<ApiResponse> modifyBuyer(@PathVariable Long buyerSeq, @RequestBody BuyerDto buyerDto) {
//        log.info("getBuyer : {}, {}", buyerSeq, buyerDto);
//        buyerService.modifyBuyer(buyerSeq, buyerDto);
//        return ResponseEntity.ok(ApiResponse.success());
//    }

}
