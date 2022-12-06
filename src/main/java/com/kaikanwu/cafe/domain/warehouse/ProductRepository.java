package com.kaikanwu.cafe.domain.warehouse;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    /**
     * 批量查找
     */
    List<Product> findByIdIn(List<Integer> ids);

}
