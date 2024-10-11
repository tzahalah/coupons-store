package com.example.couponsproject.Service;
import com.example.couponsproject.Entities.Coupon;

import com.example.couponsproject.Entities.Credentials;
import com.example.couponsproject.Entities.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService extends ClientService {

    private Customer currentCustomer= new Customer();

    public CustomerService(){}



    public void buyCoupon(Coupon c,String customerId){
        if (c.getAmount()>0) {
            c.setAmount(c.getAmount() - 1);
            this.currentCustomer =customerRepository.findCustomerById(customerId);
            if (!c.getCustomers().contains(currentCustomer))
                c.getCustomers().add(currentCustomer);
            if (!currentCustomer.getCoupons().contains(c))
                currentCustomer.getCoupons().add(c);
            couponRepository.save(c);
            customerRepository.save(currentCustomer);
        }
        else
            System.out.println("this coupon out of stock");

    }


public List<Coupon> getAllCoupons(){return (List<Coupon>) couponRepository.getAllCoupons();}

}
