package com.demo.action;

import com.demo.bean.Product;

public class ProductAction {
    private Product product;

    public String show() {
        product = new Product();
        product.setName("iphone7");
        return "show";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}