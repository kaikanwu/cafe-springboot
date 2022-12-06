package com.kaikanwu.cafe.interfaces;

import com.kaikanwu.cafe.application.PaymentApplicationService;
import com.kaikanwu.cafe.domain.payment.Payment;
import com.kaikanwu.cafe.infrastructure.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentResource {

    @Autowired
    private PaymentApplicationService service;

    /**
     * 支付或者取消
     */
    @PostMapping("/{payId}")
    public Response updatePaymentStatus(@PathVariable String payId, Integer accountId, Payment.Status status) {
        if (status == Payment.Status.PAYED) { //todo: check this Enum's usage.
            service.accomplishPayment(accountId, payId);
        } else {
            service.cancelPayment(payId);
        }
        return Response.success();
    }
}
