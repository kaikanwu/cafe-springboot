package com.kaikanwu.cafe.application;

import com.kaikanwu.cafe.domain.account.Account;
import com.kaikanwu.cafe.domain.account.AccountRepository;
import com.kaikanwu.cafe.domain.account.validation.NotConflictAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Slf4j
@Service
public class AccountApplicationService {

    @Autowired
    private AccountRepository repository;

    /**
     * 创建账号
     */
    public void createAccount(Account account) {
        log.info("Account.createAccount, request: {}", account);
        Account existAccount = repository.findByUsername(account.getUsername());
        if (existAccount != null) {
            log.error("Account.createAccount, failed: {}", account);
            throw new UnsupportedOperationException("用户名已存在，不支持重复创建。");
        }
        account.setPassword(account.getPassword());
        repository.save(account);
        log.info("Account.createAccount, success {}", account);
    }

    /**
     * 根据用户名获取账号
     */
    public Account getAccountByUsername(String username) {
        return repository.findByUsername(username);
    }

    /**
     * 更新账号
     */
    public void updateAccount(Account account) {
        repository.save(account);
    }

}
