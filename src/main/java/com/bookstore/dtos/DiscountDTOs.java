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

/**
 *
 * @author tranv
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "discounts")

public class DiscountDTOs {

    @XmlElement(name = "discount", required = true)
    protected List<discountDTO> discount;

    public List<discountDTO> getDiscounts() {
        if (discount == null) {
            discount = new ArrayList<discountDTO>();
        }
        return this.discount;
    }
}
