package org.second.project;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String partNo;
    private String name;
    private String description;
    private Boolean isForSale;
    private BigDecimal price;

    public Product(){
    }

    public Product(Long id, String partNo, String name, String description, Boolean isForSale, BigDecimal price) {
        this.id = id;
        this.partNo = partNo;
        this.name = name;
        this.description = description;
        this.isForSale = isForSale;
        this.price = price;
    }

    public Product(String partNo, String name, String description, Boolean isForSale, BigDecimal price) {
        this.partNo = partNo;
        this.name = name;
        this.description = description;
        this.isForSale = isForSale;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsForSale() {
        return isForSale;
    }

    public void setIsForSale(Boolean isForSale) {
        this.isForSale = isForSale;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
