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
@XmlRootElement(name = "dealDetails")

public class dealDetaiDTOs {
    @XmlElement(name="dealDetail",required = true)
    protected List<dealDTO> dealDetals;

    public List<dealDTO> getDeals() {
        if (dealDetals == null) {
            dealDetals = new ArrayList<dealDTO>();
        }
        return this.dealDetals;
    }
}
