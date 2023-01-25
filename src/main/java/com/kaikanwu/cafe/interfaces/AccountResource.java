package com.kaikanwu.cafe.interfaces;

import com.kaikanwu.cafe.application.AccountApplicationService;
import com.kaikanwu.cafe.domain.account.Account;
import com.kaikanwu.cafe.domain.account.validation.NotConflictAccount;
import com.kaikanwu.cafe.infrastructure.response.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/account")
@Validated
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
    public Response updateUser(@Valid @NotConflictAccount Account account) {
        // 需要更多的想想业务参数如何校验？也就是放在 service 中，还是放在方法参数注解里处理
        // 可以考虑的一种方案，可复用、较简单的放在注解中处理，比较特别的放在 service 实现中。两种结合使用。
        accountService.updateAccount(account);
        return Response.success();
    }
}
