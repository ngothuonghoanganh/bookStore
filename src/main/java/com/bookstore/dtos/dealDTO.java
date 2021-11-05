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
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Admin
 */
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "Deal", propOrder = {
//    "id",
//    "userId",
//    "discountId",
//    "discountCode",
//    "discountPirce",
//    "totalPrice",
//    "createDate",
//    "status"
//})
@XmlRootElement(name = "Deal")
public class dealDTO {

    @XmlElement(name = "id")
    private String id;
    @XmlElement(name = "userId")
    private String userId;
    @XmlElement(name = "discountId")
    private String discountId;
    @XmlElement(name = "discountCode")
    private String discountCode;
    @XmlElement(name = "discountPirce")
    private float discountPirce;
    @XmlElement(name = "totalPrice")
    private float totalPrice;
    @XmlElement(name = "createDate")
    private Date createDate;
    @XmlElement(name = "status")
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

    /**
     * Gets the value of the userId property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the name property.
     *
     * @param name allowed object is {@link String }
     *
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Sets the value of the id property.
     *
     * @param id allowed object is {@link String }
     *
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the value of the discountId property.
     *
     * @param discountId allowed object is {@link String }
     *
     */
    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    /**
     * Sets the value of the discountCode property.
     *
     * @param discountCode allowed object is {@link String }
     *
     */
    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    /**
     * Sets the value of the discountPirce property.
     *
     * @param discountPirce allowed object is {@link float }
     *
     */
    public void setDiscountPirce(float discountPirce) {
        this.discountPirce = discountPirce;
    }

    /**
     * Sets the value of the totalPrice property.
     *
     * @param totalPrice allowed object is {@link float }
     *
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Sets the value of the createDate property.
     *
     * @param createDate allowed object is {@link Date }
     *
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Sets the value of the status property.
     *
     * @param status allowed object is {@link String }
     *
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the value of the ids property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the value of the discountId property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getDiscountId() {
        return discountId;
    }

    /**
     * Gets the value of the discountCode property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getDiscountCode() {
        return discountCode;
    }

    /**
     * Gets the value of the discountPirce property.
     *
     * @return possible object is {@link float }
     *
     */
    public float getDiscountPirce() {
        return discountPirce;
    }

    /**
     * Gets the value of the totalPrice property.
     *
     * @return possible object is {@link float }
     *
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * Gets the value of the createDate property.
     *
     * @return possible object is {@link Date }
     *
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

}
