/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dtos;

import java.util.ArrayList;
import java.util.List;
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
//@XmlType(name = "", propOrder = {
//    "user"
//})
@XmlRootElement(name = "users")
public class userDTOs {

    @XmlElement(name="user",required = true)
    protected List<userDTO> user;

    public List<userDTO> getUser() {
        if (user == null) {
            user = new ArrayList<userDTO>();
        }
        return this.user;
    }
}
