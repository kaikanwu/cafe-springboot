package com.kaikanwu.cafe.application;

import com.kaikanwu.cafe.application.dto.Settlement;
import com.kaikanwu.cafe.domain.payment.Payment;
import com.kaikanwu.cafe.domain.payment.PaymentService;
import com.kaikanwu.cafe.domain.payment.WalletService;
import com.kaikanwu.cafe.domain.warehouse.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentApplicationService {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProductService productService;

    @Autowired
    private WalletService walletService;

    @Resource(name = "settlementCache")
    private Cache settlementCache;


    /**
     * 执行结算清单，生成支付单
     */
    public Payment executeBySettlement(Settlement settlement) {
        // 生成支付单
        Payment payment = paymentService.producePayment(settlement);
        // 设置定时任务
        paymentService.autoThawedTrigger(payment);
        return payment;
    }

    /**
     * 完成支付
     */
    public void accomplishPayment(Integer accountId, String payId) {
        // 完成支付
        double price = paymentService.accomplish(payId);
        // 钱包扣款
        walletService.decrease(accountId, price);
        // 清除定时任务
        settlementCache.evict(payId);
    }

    /**
     * 取消支付
     */
    public void cancelPayment(String payId) {
        // 取消支付单
        paymentService.cancel(payId);
        // 清除定时任务
        settlementCache.evict(payId);
    }
}
