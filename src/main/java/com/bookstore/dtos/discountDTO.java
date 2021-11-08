/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dtos;

import java.sql.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "Discount", propOrder = {
//    "id",
//    "code",
//    "startDate",
//    "endDate",
//    "percent",
//    "status"
//})
@XmlRootElement(name = "Discount")
public class discountDTO {

    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "discountPrice")
    private String discountPrice;
    @XmlElement(name = "discountCode")
    private String discountCode;
    @XmlElement(name = "startDate")
    private Date startDate;
    @XmlElement(name = "endDate")
    private Date endDate;
    @XmlElement(name = "percent")
    private float percent;
    @XmlElement(name = "status")
    private String status;

    public discountDTO() {
    }

    public discountDTO(int id, String discountPrice, String discountCode, Date startDate, Date endDate, float percent, String status) {
        this.id = id;
        this.discountPrice = discountPrice;
        this.discountCode = discountCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percent = percent;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    
}
