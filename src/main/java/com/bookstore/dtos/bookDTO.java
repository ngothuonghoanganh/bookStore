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
//@XmlType(name = "Book", propOrder = {
//    "id",
//    "title",
//    "image",
//    "description",
//    "author",
//    "categoryId",
//    "category",
//    "importDate",
//    "status",
//    "price",
//    "name"
//})
@XmlRootElement(name = "Book")
public class bookDTO {

    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "image")
    private String image;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "author")
    private String author;
    @XmlElement(name = "categoryId")
    private int categoryId;
    @XmlElement(name = "categoryName")
    private String categoryName;
    @XmlElement(name = "importDate")
    private Date importDate;
    @XmlElement(name = "quantity")
    private int quantity;
    @XmlElement(name = "status")
    private String status;
    @XmlElement(name = "price")
    private float price;
    @XmlElement(name = "name")
    private String name;

    public bookDTO() {
    }

    public bookDTO(int id, String title, String image, String description, String author, int categoryId, String categoryName, Date importDate, int quantity, String status, float price, String name) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.author = author;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.importDate = importDate;
        this.quantity = quantity;
        this.status = status;
        this.price = price;
        this.name = name;
    }

    public bookDTO(String title, String image, String description, String author, int categoryId, Date importDate, int quantity, String status, float price, String name) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.author = author;
        this.categoryId = categoryId;
        this.importDate = importDate;
        this.quantity = quantity;
        this.status = status;
        this.price = price;
        this.name = name;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param name allowed object is {@link String }
     *
     */
    public void setName(String name) {
        this.name = name;
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
     * @param id allowed object is {@link String }
     *
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the value of the title property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param title allowed object is {@link String }
     *
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the value of the image property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     *
     * @param image allowed object is {@link String }
     *
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param description allowed object is {@link String }
     *
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the value of the author property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     *
     * @param author allowed object is {@link String }
     *
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the value of the categoryId property.
     *
     * @return possible object is {@link String }
     *
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the value of the categoryId property.
     *
     * @param categoryId allowed object is {@link String }
     *
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Gets the value of the category property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the value of the category property.
     *
     * @param category allowed object is {@link String }
     *
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets the value of the importDate property.
     *
     * @return possible object is {@link Date }
     *
     */
    public Date getImportDate() {
        return importDate;
    }

    /**
     * Sets the value of the importDate property.
     *
     * @param importDate allowed object is {@link Date }
     *
     */
    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    /**
     * Gets the value of the quantity property.
     *
     * @return possible object is {@link int }
     *
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     *
     * @param quantity allowed object is {@link int }
     *
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
     * Gets the value of the price property.
     *
     * @return possible object is {@link float }
     *
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     * @param price allowed object is {@link float }
     *
     */
    public void setPrice(float price) {
        this.price = price;
    }

}
