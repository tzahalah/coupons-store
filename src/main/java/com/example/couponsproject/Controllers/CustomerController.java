package com.example.couponsproject.Controllers;

import com.example.couponsproject.Entities.Coupon;
import com.example.couponsproject.Exceptions.CustomException;
import com.example.couponsproject.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController extends ClientController {
    @Autowired
    CustomerService customerService;

    public CustomerController() {}



    @PostMapping("{id}/purchaseCoupon")
    public void purchaseCoupon(@RequestBody Coupon coupon, @PathVariable ("id") String customerId) throws CustomException {
        customerService.buyCoupon(coupon, customerId);
    }


    @GetMapping("/AllCoupons")
    public List<Coupon> getAllCoupons() throws CustomException {
        return customerService.getAllCoupons();
    }

}
