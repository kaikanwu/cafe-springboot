package com.kaikanwu.cafe.domain.payment;

import com.kaikanwu.cafe.domain.account.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public void decrease(Integer accountId, Double amount) {
        Wallet wallet = walletRepository.findByAccountId(accountId).orElseGet(() -> {
            Wallet newWallet = new Wallet();
            Account account = new Account();
            account.setId(accountId);
            newWallet.setAccount(account);
            // todo: 临时处理
            newWallet.setMoney(amount);
            walletRepository.save(newWallet);
            return newWallet;
        });
        if (wallet.getMoney() > amount) {
            wallet.setMoney(wallet.getMoney() - amount);
            walletRepository.save(wallet);
            log.info("用户{} 支付成功，本次消费 {}，余额 {}", accountId, amount, wallet.getMoney());
        }
    }


    public void increase(Integer accountId, Double amount) {


    }

    public void frozen(Integer accountId, Double amount) {

    }

    public void thaw(Integer accountId, Double amount) {

    }

}
