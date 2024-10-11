package com.example.couponsproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Embedded
    private Credentials cred;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Coupon> coupons;

    public Customer(){}

    public Customer(String id, String firstName, String lastName, Credentials cred) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cred = cred;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Credentials getCred() {
        return cred;
    }

    public void setCred(Credentials cred) {
        this.cred = cred;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
         this.coupons = coupons;

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cred=" + cred +
                ", coupons=" + coupons +
                '}';
    }
}
