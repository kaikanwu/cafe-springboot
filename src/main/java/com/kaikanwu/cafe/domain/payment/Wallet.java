package com.kaikanwu.cafe.domain.payment;

import com.kaikanwu.cafe.domain.BaseEntity;
import com.kaikanwu.cafe.domain.account.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Wallet extends BaseEntity {


    private Double money;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

}
