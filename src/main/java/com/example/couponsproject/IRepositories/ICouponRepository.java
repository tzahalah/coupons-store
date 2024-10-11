package com.example.couponsproject.IRepositories;

import com.example.couponsproject.Entities.Coupon;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ICouponRepository  extends JpaRepository<Coupon,Integer> {
  public Coupon findById(int id);
  public ArrayList<Coupon> findByCategoryAndCompanyId(Coupon.Category category, int CompanyId);
  public boolean existsByTitleAndCompanyId(String title, int CompanyId);
  public List<Coupon> findByEndDateBefore(Date EndDate);
  @Modifying
  @Query("delete from Coupon c where c.endDate< current_date ")
  public List<Coupon> DeleteExpirationCoupon();
  @Query("select  c.customers from Coupon c where c.id=?1")
  public List<Coupon> getCustomersofCoupon(int CouponId);
  @EntityGraph(attributePaths = {"company"})
  @Query("select c from Coupon c join fetch c.company")
  public List<Coupon> getAllCoupons();

}

