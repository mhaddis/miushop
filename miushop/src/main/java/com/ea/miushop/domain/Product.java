package com.ea.miushop.domain;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    private String productWalmartLink;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private Category category;

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductWalmartLink() {
        return productWalmartLink;
    }

    public void setProductWalmartLink(String productWalmartLink) {
        this.productWalmartLink = productWalmartLink;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
