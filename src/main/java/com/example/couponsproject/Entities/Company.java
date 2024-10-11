package com.example.couponsproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Embedded
    private Credentials cred;
    @OneToMany(mappedBy = "company", orphanRemoval = true,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Coupon> coupons;




    public Company(){}

    public Company(String name, Credentials cred) {
        this.name = name;
        this.cred = cred;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cred=" + cred +
                ", coupons=" + coupons +
                '}';
    }
}
