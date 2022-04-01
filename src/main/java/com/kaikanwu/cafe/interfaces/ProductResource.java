package com.kaikanwu.cafe.interfaces;

import com.kaikanwu.cafe.application.ProductApplicationService;
import com.kaikanwu.cafe.domain.warehouse.Product;
import com.kaikanwu.cafe.infrastructure.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductResource {
    @Autowired
    ProductApplicationService service;


    // 商品相关接口
    @PostMapping
    public Response createProduct(@Valid Product product) {
        return Response.success(service.saveProduct(product));
    }

    @GetMapping("/{id}")
    public Response getProductById(@PathVariable Integer id) {
        return Response.success(service.getProductById(id));
    }

    @GetMapping
    public Response getAllProducts() {
        return Response.success(service.getAllProducts());
    }

    @PutMapping
    public Response updateProduct(@Valid Product product) {
        return Response.success(service.saveProduct(product));
    }

    @DeleteMapping("/{id}")
    public Response removeProduct(@PathVariable Integer id) {
        service.removeProduct(id);
        return Response.success();
    }

    @GetMapping("/stock/{productId}")
    public Response getStock(@PathVariable Integer productId) {
        return Response.success(service.getStock(productId));
    }

    @PostMapping("/stock/{productId}")
    public Response updateStock(@PathVariable Integer productId, Integer amount) {
        service.setStockAmount(productId, amount);
        return Response.success();
    }
}
