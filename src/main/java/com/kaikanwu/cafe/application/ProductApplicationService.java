package com.kaikanwu.cafe.application;

import com.kaikanwu.cafe.domain.warehouse.Product;
import com.kaikanwu.cafe.domain.warehouse.ProductService;
import com.kaikanwu.cafe.domain.warehouse.Stock;
import com.kaikanwu.cafe.domain.warehouse.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductApplicationService {

    @Autowired
    private ProductService productService;

    @Autowired
    private StockService stockService;

    public Product createProduct(Product product) {
        return productService.saveProduct(product);
    }

    /**
     * 创建或者更新一个产品
     */
    public Product updateProduct(Product product) {
        if (product.getId() == null) {
            throw new UnsupportedOperationException("缺少需要更新的 Product id");
        }
        Product existProduct = productService.getProductById(product.getId());
        if (existProduct == null) {
            throw new UnsupportedOperationException("要更新的产品不存在");
        }
        return productService.saveProduct(product);
    }

    /**
     * 删除对应 id 的产品
     *
     * @param id 产品 id
     */
    public void removeProduct(Integer id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            throw new EntityNotFoundException("尝试删除的产品不存在，id: " + id);
        }
        productService.removeProduct(id);
    }


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
     * 根据产品获取对应库存
     */
    public Stock getStock(Integer productId) {
        Stock stock = stockService.getByProductId(productId);
        stock.setProduct(productService.getProductById(productId));
        return stock;
    }

    /**
     * 调整库存数量
     */
    public void setStockAmount(Integer productId, Integer amount) {
        stockService.setStockNumber(productId, amount);
    }

}
