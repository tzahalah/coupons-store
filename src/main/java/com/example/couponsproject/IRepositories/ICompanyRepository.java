package com.example.couponsproject.IRepositories;

import com.example.couponsproject.Entities.Company;
import com.example.couponsproject.Entities.Coupon;
import com.example.couponsproject.Entities.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ICompanyRepository extends JpaRepository <Company,Integer>{
    public Company findByCred(Credentials cred);
    public boolean existsByCred (Credentials cred);
    public boolean existsByNameOrCred_Email(String name, String email);
    public Company findCompanyByIdAndCred_Email( int id ,String email);
    @Query("select c.coupons from Company c where c.id=?1")
    public List<Coupon> getCouponsOfCompany(int CompanyID);



}
