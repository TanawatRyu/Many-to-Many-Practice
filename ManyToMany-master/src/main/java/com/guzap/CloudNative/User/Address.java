/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guzap.CloudNative.User;

import javax.persistence.Embeddable;

/**
 *
 * @author wdrdr
 */
@Embeddable
public class Address {

    private String address;
    private String state;

    public Address() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
