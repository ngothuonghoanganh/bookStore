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
public class bookDTO {

    private String id;
    private String title;
    private String image;
    private String description;
    private String author;
    private String categoryId;
    private String category;
    private Date importDate;
    private int quantity;
    private String status;
    private float price;
    private String name;

    public bookDTO() {
    }

    public bookDTO(String id, String title, String image, String description, String author, String categoryId, String category, Date importDate, int quantity, String status, float price, String name) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.author = author;
        this.categoryId = categoryId;
        this.category = category;
        this.importDate = importDate;
        this.quantity = quantity;
        this.status = status;
        this.price = price;
        this.name = name;
    }

    public bookDTO(String title, String image, String description, String author, String categoryId, Date importDate, int quantity, String status, float price, String name) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
