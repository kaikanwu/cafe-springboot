package com.kaikanwu.cafe.domain.warehouse;

import com.kaikanwu.cafe.application.dto.Settlement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void setProductMap(Settlement settlement) {
        List<Integer> ids = settlement.getItems().stream().map(Settlement.Item::getProductId).collect(Collectors.toList());
        settlement.productMap = productRepository.findByIdIn(ids).stream().collect(Collectors.toMap(Product::getId, Function.identity()));
    }

    /**
     * 获取所有的货物信息
     */
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * 根据 id 获取对应的产品
     */
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * 创建或更新一个产品
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * 根据 id 删除对应的产品
     */
    public void removeProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
