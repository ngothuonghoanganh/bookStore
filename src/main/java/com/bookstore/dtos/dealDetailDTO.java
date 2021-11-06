/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Admin
 */
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "DealDetail", propOrder = {
//    "id",
//    "dealId",
//    "bookId",
//    "bookName",
//    "quantity",
//    "price"
//})
@XmlRootElement(name = "DealDetail")
public class dealDetailDTO {

    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "dealId")
    private int dealId;
    @XmlElement(name = "bookId")
    private int bookId;
    @XmlElement(name = "bookName")
    private String bookName;
    @XmlElement(name = "quantity")
    private int quantity;
    @XmlElement(name = "price")
    private float price;

    public dealDetailDTO() {
    }

    public dealDetailDTO(int id, int dealId, int bookId, String bookName, int quantity, float price) {
        this.id = id;
        this.dealId = dealId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDealId() {
        return dealId;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return Integer.toString(bookId);
    }

}
