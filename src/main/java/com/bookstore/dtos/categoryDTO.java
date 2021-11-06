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
//@XmlType(name = "Category", propOrder = {
//    "id",
//    "categoryName"
//})
@XmlRootElement(name = "Category")
public class categoryDTO {

    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "categoryName")
    private String categoryName;

    public categoryDTO() {
    }

    public categoryDTO(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public categoryDTO(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is {@link String }
     *
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param id allowed object is {@link float }
     *
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the value of the categoryName property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the value of the categoryName property.
     *
     * @param categoryName allowed object is {@link float }
     *
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
