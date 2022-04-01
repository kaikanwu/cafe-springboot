package com.kaikanwu.cafe.interfaces;

import com.kaikanwu.cafe.application.PaymentApplicationService;
import com.kaikanwu.cafe.application.dto.Settlement;
import com.kaikanwu.cafe.domain.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/settlement")
public class SettlementResource {

    @Autowired
    private PaymentApplicationService service;

    @PostMapping
    public Payment executeSettlement(@Valid Settlement settlement) {
        return service.executeBySettlement(settlement);
    }
}
