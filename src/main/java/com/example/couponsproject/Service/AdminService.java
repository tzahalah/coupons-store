package com.example.couponsproject.Service;

import com.example.couponsproject.Entities.Company;
import com.example.couponsproject.Entities.Coupon;
import com.example.couponsproject.Entities.Credentials;
import com.example.couponsproject.Entities.Customer;
import com.example.couponsproject.Exceptions.CustomException;
import com.example.couponsproject.IRepositories.ICompanyRepository;
import com.example.couponsproject.IRepositories.ICouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class AdminService extends ClientService {

    public AdminService() {}

    public ArrayList<Company> getAllCompanies(){
        return (ArrayList<Company>) companyRepository.findAll();
    }

    public void addCompany(Company company) throws CustomException{
        companyRepository.save(company);
    }

    public void updateCompany( Company company){
            companyRepository.save(company);
    }

   public void deleteCompany(int id) throws CustomException{
        try {
            companyRepository.deleteById(id);
        } catch (Exception e) {
            throw new CustomException("error delete");
        }

   }

    public ArrayList<Customer> getCustomersSortByAB(){return (ArrayList<Customer>) customerRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));}

   public void addCustomer(Customer c){
        customerRepository.save(c);
   }

   public void updateCustomer( Customer c){
           customerRepository.save(c);
   }

   public void deleteCustomer(String id){
        customerRepository.deleteById(id);
   }

    public void addCoupon(Coupon c){
        couponRepository.save(c);
    }

    public void updateCoupon(Coupon coup){
       couponRepository.save(coup);
    }

    public void deleteCoupon(int id){
        couponRepository.deleteById(id);
    }

}