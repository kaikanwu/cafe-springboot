package com.kaikanwu.cafe.domain.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    /**
     * 获取所有的货物信息
     */
    public Iterable<Product> getAllProducts() {
        return repository.findAll();
    }

    /**
     * 根据 id 获取对应的产品
     */
    public Product getProductById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * 创建或更新一个产品
     */
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    /**
     * 根据 id 删除对应的产品
     */
    public void removeProduct(Integer id) {
        repository.deleteById(id);
    }
}
