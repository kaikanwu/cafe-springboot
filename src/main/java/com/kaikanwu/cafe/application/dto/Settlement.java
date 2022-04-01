package com.kaikanwu.cafe.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaikanwu.cafe.domain.warehouse.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Map;

/**
 * 结算
 */
public class Settlement {

    public static class Item{
        // 商品数量
        @NotNull
        @Min(value =1, message = "结算单中商品数量至少是 1 件")
        private Integer amount;

        @JsonProperty("id")
        @NotNull(message = "商品信息不能为空")
        private Integer productId;

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }
    }

    /**
     * 结算单中的商品
     */
    private Collection<Item> items;


    public transient Map<Integer, Product> productMap;

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }



}
