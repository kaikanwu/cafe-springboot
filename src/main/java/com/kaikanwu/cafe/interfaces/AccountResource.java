package com.kaikanwu.cafe.interfaces;

import com.kaikanwu.cafe.application.AccountApplicationService;
import com.kaikanwu.cafe.domain.account.Account;
import com.kaikanwu.cafe.infrastructure.response.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountResource {

    @Resource
    private AccountApplicationService accountService;


    @PostMapping
    public Response createUser(@Valid Account user) {
        accountService.createAccount(user);
        return Response.success();
    }

    @GetMapping("/{username}")
    public Response getUser(@PathVariable String username) {
        return Response.success(accountService.getAccountByUsername(username));
    }

    @PutMapping
    public Response updateUser(@Valid Account account) {
        accountService.updateAccount(account);
        return Response.success();
    }

}
