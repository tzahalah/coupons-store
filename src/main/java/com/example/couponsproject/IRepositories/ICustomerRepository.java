package com.example.couponsproject.IRepositories;

import com.example.couponsproject.Entities.Coupon;
import com.example.couponsproject.Entities.Credentials;
import com.example.couponsproject.Entities.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository <Customer,String> {

    public List<Customer> findAll(Sort sort);
    public Customer findByCred(Credentials cred);
    public boolean existsByCred(Credentials cred);
    public boolean existsByCred_Email(String email);
    @Query ("select c from Customer c where c.id=?1")
    public Customer findCustomerById(String id);
    public Customer findCustomerByIdAndCred_Email( String id ,String email);
    @Query("select c.coupons from Customer c where c.id=?1")
    public List<Coupon> getCoupons(int customerId);


}
