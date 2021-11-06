/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dtos;

import java.sql.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Admin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DealList", propOrder = {
    "id",
    "fullName",
    "discountPrice",
    "totalPrice",
    "price",
    "quantity",
    "creatDate",
    "bookName"
})
@XmlRootElement(name = "DealList")
public class dealList {

    private int id;
    private String fullName;
    private float discountPrice;
    private float totalPrice;
    private float price;
    private int quantity;
    private Date creatDate;
    private String bookName;

    public dealList() {
    }

    public dealList(int id, String fullName, float discountPrice, float totalPrice, float price, int quantity, Date creatDate, String bookName) {
        this.id = id;
        this.fullName = fullName;
        this.discountPrice = discountPrice;
        this.totalPrice = totalPrice;
        this.price = price;
        this.quantity = quantity;
        this.creatDate = creatDate;
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
