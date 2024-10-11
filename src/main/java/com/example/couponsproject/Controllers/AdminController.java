package com.example.couponsproject.Controllers;

import com.example.couponsproject.Entities.*;
import com.example.couponsproject.Exceptions.CustomException;
import com.example.couponsproject.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController extends ClientController{
    @Autowired
    AdminService adminService;
    public AdminController(){}

    @PostMapping("/addCompany")
    public void addCompany(@RequestBody Company company) throws CustomException {
        adminService.addCompany(company);

    }

    @PutMapping("/updateCompany")
    public void updateCompany(@RequestBody Company company) throws CustomException {
        adminService.updateCompany(company);
    }

    @DeleteMapping("/deleteCompany/{id}")
    public void deleteCompany(@PathVariable("id") int companyID) throws CustomException {
        adminService.deleteCompany(companyID);
    }

    @GetMapping("/AllCompanies")
    public ArrayList<Company> getAllCompanies() throws CustomException {
        return adminService.getAllCompanies();
    }


    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer customer) throws CustomException {
        adminService.addCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public void updateCustomer(@RequestBody Customer customer) throws CustomException {
        adminService.updateCustomer(customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") String customerID) throws CustomException {
        adminService.deleteCustomer(customerID);
    }

    @GetMapping("/AllCustomers")
    public ArrayList<Customer> getAllCustomers() throws CustomException {
        return adminService.getCustomersSortByAB();
    }


    }

