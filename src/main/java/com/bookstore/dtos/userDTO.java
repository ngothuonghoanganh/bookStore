/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dtos;

import com.bookstore.utils.IDAdapter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Admin
 */
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "User", propOrder = {
//    "id",
//    "username",
//    "password",
//    "address",
//    "email",
//    "fullName",
//    "role"
//})
//@XmlRootElement(name = "user")
public class userDTO {

    @XmlElement(name = "id")
    @XmlJavaTypeAdapter(IDAdapter.class)
    private int id;
    @XmlElement(name = "username")
    private String username;
    @XmlElement(name = "password")
    private String password;
    @XmlElement(name = "address")
    private String address;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "role")
    private roleDTO role;

    public userDTO() {
    }

    public userDTO(int id, String username, String password, String address, String email, String fullName, roleDTO role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
    }

    public userDTO(int id, String username, String password, String fullName, String status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public userDTO(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public roleDTO getRole() {
        return role;
    }

    public void setRole(roleDTO role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
