/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guzap.CloudNative.Ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guzap.CloudNative.User.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author wdrdr
 */
@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long ticketId;

    private String title;

    private String description;

    private double price;

    @ManyToMany(
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            fetch = FetchType.EAGER
    )
    @JoinTable(
            joinColumns = {
                @JoinColumn(name = "ticketId")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "userId")
            }
    )
    private Set<User> users;

    public Ticket() {

    }

    public Ticket(long ticketId, String title, String description, double price) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketId=" + ticketId + ", title=" + title + ", description=" + description + ", price=" + price + ", users=" + users + '}';
    }

}
