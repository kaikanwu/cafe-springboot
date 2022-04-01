package com.kaikanwu.cafe.domain.payment;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    Payment getByPayId(String payId);
}
