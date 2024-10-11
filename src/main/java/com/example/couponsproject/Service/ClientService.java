package com.example.couponsproject.Service;

import com.example.couponsproject.Entities.Credentials;
import com.example.couponsproject.IRepositories.ICompanyRepository;
import com.example.couponsproject.IRepositories.ICouponRepository;
import com.example.couponsproject.IRepositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public abstract class  ClientService {
     @Autowired
    protected ICompanyRepository companyRepository;
    @Autowired
    protected ICouponRepository couponRepository;
    @Autowired
    protected ICustomerRepository customerRepository;

}
