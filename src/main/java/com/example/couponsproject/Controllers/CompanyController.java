package com.example.couponsproject.Controllers;

import com.example.couponsproject.Entities.Coupon;
import com.example.couponsproject.Exceptions.CustomException;
import com.example.couponsproject.Service.CompanyService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/company")

public class CompanyController extends ClientController{
    @Autowired
    CompanyService companyService;

    public CompanyController (HttpServletRequest request) {}


    @GetMapping("/{id}/Coupons")
    public ArrayList<Coupon> getCouponsOfCompany(int id){return companyService.getCouponsOfCompany(id);}

    @PostMapping("/addCoupon")
    public void addCoupon(@RequestBody Coupon coupon) throws CustomException {
        companyService.addCoupon(coupon);
    }

    @PutMapping("/updateCoupon")
    public void updateCoupon(@RequestBody Coupon coupon) throws CustomException {
        companyService.updateCoupon(coupon);
    }

    @DeleteMapping("/deleteCoupon/{id}")
    public void deleteCoupon(@PathVariable("id") int couponID) throws CustomException {
        companyService.deleteCoupon(couponID);
    }


}
