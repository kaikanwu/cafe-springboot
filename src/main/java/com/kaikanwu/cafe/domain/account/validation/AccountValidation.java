package com.kaikanwu.cafe.domain.account.validation;

import com.kaikanwu.cafe.domain.account.Account;
import com.kaikanwu.cafe.domain.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.function.Predicate;

public class AccountValidation<T extends Annotation> implements ConstraintValidator<T, Account> {
    @Autowired
    protected AccountRepository repository;

    protected Predicate<Account> predicate = c -> true;


    @Override
    public boolean isValid(Account value, ConstraintValidatorContext context) {
        return repository == null || predicate.test(value);
    }

    public static class NotConflictAccountValidator extends AccountValidation<NotConflictAccount> {
        public void initialize(NotConflictAccount constraintAnnotation) {
            predicate = c -> {
                if (c.getId() == null) {
                    return false;
                }
                // 这里表示 username, email, telephone 这几个字段不能重复，根据业务调整。
                Collection<Account> collection = repository.findByUsernameOrEmailOrTelephone(c.getUsername(), c.getEmail(), c.getTelephone());
                // 返回 true 的两种情况：1. 当数据库中没有符合条件的数据时（对应创建账户） 2. 就是当前要更新的数据（对应更新账户）
                return collection.isEmpty() || (collection.size() == 1) && collection.iterator().next().getId().equals(c.getId());
            };
        }
    }
}

