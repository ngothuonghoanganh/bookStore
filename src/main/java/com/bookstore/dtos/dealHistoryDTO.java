package com.bookstore.dtos;

import java.sql.Date;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DealHistory", propOrder = {
    "id",
    "fullName",
    "discountPrice",
    "totalPrice",
    "creatDate",
    "dealList"
})
@XmlRootElement(name = "DealHistory")
public class dealHistoryDTO {

    private String id;
    private String fullName;
    private float discountPrice;
    private float totalPrice;
    private Date creatDate;
    private ArrayList<dealList> dealList;

    public dealHistoryDTO() {
    }

    public dealHistoryDTO(String id, String fullName, float discountPrice, float totalPrice, ArrayList<dealList> dealList) {
        this.id = id;
        this.fullName = fullName;
        this.discountPrice = discountPrice;
        this.totalPrice = totalPrice;
        this.dealList = dealList;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public ArrayList<dealList> getDealList() {
        return dealList;
    }

    public void setDealList(ArrayList<dealList> dealList) {
        this.dealList = dealList;
    }

}
