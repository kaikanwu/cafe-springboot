package com.kaikanwu.cafe.application;

import com.kaikanwu.cafe.domain.warehouse.Product;
import com.kaikanwu.cafe.domain.warehouse.ProductService;
import com.kaikanwu.cafe.domain.warehouse.Stock;
import com.kaikanwu.cafe.domain.warehouse.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductApplicationService {

    @Autowired
    private ProductService productService;

    @Autowired
    private StockService stockService;

    /**
     * 获取所有的产品
     */
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * 获取 id 对应产品信息
     */
    public Product getProductById(Integer id) {
        return productService.getProductById(id);
    }

    /**
     * 创建或者更新一个产品
     */
    public Product saveProduct(Product product) {
        return productService.saveProduct(product);
    }

    public void removeProduct(Integer id) {
        productService.removeProduct(id);
    }


    /**
     * 根据产品获取对应库存
     */
    public Stock getStock(Integer productId) {
        return stockService.getByProductId(productId);
    }

    /**
     * 调整库存数量
     */
    public void setStockAmount(Integer productId, Integer amount) {
        stockService.setStockNumber(productId, amount);
    }

}
