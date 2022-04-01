package com.kaikanwu.cafe.domain.payment;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WalletRepository extends CrudRepository<Wallet, Integer> {

    Optional<Wallet> findByAccountId(Integer accountId);

}
