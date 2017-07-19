package com.santhosh2129.inventory.common.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * Created by santhosh on 7/1/17.
 */

@Document(collection = "product")
public class ProductEntity {
    public static final String PRODUCT_NAME = "product_name";
    public static final String CATEGORY = "category";
    public static final String PRICE = "price";
    public static final String UPDATE_TS = "update_ts";
    public static final String CREATE_TS = "create_ts";

    @Id
    private String id;

    @Field(PRODUCT_NAME)
    private String productName;

    @Field(CATEGORY)
    private String category;

    @Field(PRICE)
    private List<Price> price;

    @Field(UPDATE_TS)
    private Date updateTimestamp;

    @Field(CREATE_TS)
    private Date createTimestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Price> getPrice() {
        return price;
    }

    public void setPrice(List<Price> price) {
        this.price = price;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public class Price {
        private String quantity;
        private Integer rate;

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public Integer getRate() {
            return rate;
        }

        public void setRate(Integer rate) {
            this.rate = rate;
        }
    }

}
