/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dtos;

/**
 *
 * @author Admin
 */
public class categoryDTO {

    private String id;
    private String categoryName;

    public categoryDTO() {
    }

    public categoryDTO(String id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public categoryDTO(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
