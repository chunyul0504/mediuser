package com.blue.mediuser.buyer.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * buyer admin controller
 */
@Slf4j
@RestController
@RequestMapping("/buyer")
public class BuyerAdminController {

    private final BuyerAdminService buyerAdminService;

    public BuyerAdminController(BuyerAdminService buyerAdminService) {
        this.buyerAdminService = buyerAdminService;
    }


}
