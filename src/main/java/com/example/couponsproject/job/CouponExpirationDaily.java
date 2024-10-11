package com.example.couponsproject.job;

import com.example.couponsproject.Entities.Coupon;
import com.example.couponsproject.IRepositories.ICouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
@Scope("singleton")
public class CouponExpirationDaily implements Runnable {
    @Autowired
    private ICouponRepository couponRepository;
    private boolean quit=false;
    public CouponExpirationDaily() {}

    @Override
    public void run() {
        while (!quit) {
            couponRepository.DeleteExpirationCoupon();
            try{
                Thread.sleep(864000000);
            }catch (InterruptedException e){
                System.out.println("exception in CouponExpirationDailyJob");
            }
        }
    }

    public void stop(){quit = true;}
}
