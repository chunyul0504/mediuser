package com.blue.mediuser.buyer.sub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/buyer")
public class BuyerSubController {

    private final BuyerSubService buyerSubService;

    public BuyerSubController(BuyerSubService buyerSubService) {
        this.buyerSubService = buyerSubService;
    }
}
