package com.kaikanwu.cafe.application;

import com.kaikanwu.cafe.domain.account.Account;
import com.kaikanwu.cafe.domain.account.AccountRepository;
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
        log.info("new user created: {}", account);
        account.setPassword(account.getPassword());
        repository.save(account);
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
//        if (account.getId() == null) {
//            throw new MissingServletRequestParameterException(account.getId().toString(), "Integer");
//        }
        repository.save(account);
    }

}
