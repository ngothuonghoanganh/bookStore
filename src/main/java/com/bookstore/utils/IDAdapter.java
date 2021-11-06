/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Admin
 */
public class IDAdapter extends XmlAdapter<Integer, Integer> {

    private int counter = 1;

    @Override
    public Integer unmarshal(Integer v) throws Exception {
        return v;
    }

    @Override
    public Integer marshal(Integer v) throws Exception {
        return counter++;
    }

}
