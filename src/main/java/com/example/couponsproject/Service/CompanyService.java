package com.example.couponsproject.Service;

import com.example.couponsproject.Entities.Company;
import com.example.couponsproject.Entities.Coupon;
import com.example.couponsproject.Entities.Credentials;
import com.example.couponsproject.IRepositories.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CompanyService extends ClientService{

    private Company currentCompany=new Company();


    public CompanyService(){ }


    public ArrayList<Coupon> getCouponsOfCompany(int id){
        return (ArrayList<Coupon>) companyRepository.getCouponsOfCompany( id);}

    public void addCoupon(Coupon c){
        couponRepository.save(c);
    }

    public void updateCoupon( Coupon coup){
        couponRepository.save(coup);
    }

    public void deleteCoupon(int id){
        couponRepository.deleteById(id);
    }

}
