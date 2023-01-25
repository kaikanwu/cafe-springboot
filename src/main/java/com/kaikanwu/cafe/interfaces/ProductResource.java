package com.kaikanwu.cafe.interfaces;

import com.kaikanwu.cafe.application.ProductApplicationService;
import com.kaikanwu.cafe.domain.warehouse.Product;
import com.kaikanwu.cafe.infrastructure.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductResource {

    @Autowired
    ProductApplicationService productService;


    @PostMapping
    public Response createProduct(@Valid Product product) {
        return Response.success(productService.createProduct(product));
    }

    @DeleteMapping("/{id}")
    public Response removeProduct(@PathVariable Integer id) {
        productService.removeProduct(id);
        return Response.success();
    }

    @PutMapping
    public Response updateProduct(@Valid Product product) {
        return Response.success(productService.updateProduct(product));
    }

    @GetMapping("/{id}")
    public Response getProductById(@PathVariable Integer id) {
        return Response.success(productService.getProductById(id));
    }

    @GetMapping
    public Response getAllProducts() {
        return Response.success(productService.getAllProducts());
    }

    @GetMapping("/stock/{productId}")
    public Response getStock(@PathVariable Integer productId) {
        return Response.success(productService.getStock(productId));
    }

    @PostMapping("/stock/{productId}")
    public Response updateStock(@PathVariable Integer productId, Integer amount) {
        productService.setStockAmount(productId, amount);
        return Response.success();
    }
}
