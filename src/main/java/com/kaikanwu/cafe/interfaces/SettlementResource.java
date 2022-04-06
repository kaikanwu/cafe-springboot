package com.kaikanwu.cafe.interfaces;

import com.kaikanwu.cafe.application.PaymentApplicationService;
import com.kaikanwu.cafe.application.dto.Settlement;
import com.kaikanwu.cafe.infrastructure.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/settlement")
public class SettlementResource {

    @Autowired
    private PaymentApplicationService service;

    @PostMapping
    public Response executeSettlement(@Valid @RequestBody Settlement settlement) {
        return Response.success(service.executeBySettlement(settlement));
    }
}
