/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dtos;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class dealDTO {

    private String id;
    private String userId;
    private String discountId;
    private String discountCode;
    private float discountPirce;
    private float totalPrice;
    private Date createDate;
    private String status;

    public dealDTO() {
    }

    public dealDTO(String id, String userId, String discountId, String discountCode, float discountPirce, float totalPrice, Date createDate, String status) {
        this.id = id;
        this.userId = userId;
        this.discountId = discountId;
        this.discountCode = discountCode;
        this.discountPirce = discountPirce;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
        this.status = status;
    }

    public dealDTO(String id, String userId, String discountId, String discountCode, float discountPirce, float totalPrice, Date createDate) {
        this.id = id;
        this.userId = userId;
        this.discountId = discountId;
        this.discountCode = discountCode;
        this.discountPirce = discountPirce;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public void setDiscountPirce(float discountPirce) {
        this.discountPirce = discountPirce;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getDiscountId() {
        return discountId;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public float getDiscountPirce() {
        return discountPirce;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getStatus() {
        return status;
    }

}
