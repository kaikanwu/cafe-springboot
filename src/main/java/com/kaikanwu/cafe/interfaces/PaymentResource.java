package com.kaikanwu.cafe.interfaces;

import com.kaikanwu.cafe.application.PaymentApplicationService;
import com.kaikanwu.cafe.domain.payment.Payment;
import com.kaikanwu.cafe.infrastructure.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentResource {

    @Autowired
    private PaymentApplicationService service;

    @PostMapping
    public Response updatePaymentStatus(String payId, Integer accountId, Payment.Status status) {
        if (status == Payment.Status.PAYED) {
            service.accomplishPayment(accountId, payId);
        } else {
            service.cancelPayment(payId);
        }
        return Response.success();
    }
}
