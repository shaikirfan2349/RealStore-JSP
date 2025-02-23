//package com.example.Real_Store.controller;
//
//import com.example.Real_Store.dto.CustomerDTO;
//import com.example.Real_Store.service.CustomerService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/Customer")
//public class CustomerController {
//    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
//
//    @Autowired
//    public CustomerService customerService;
//
//    @PostMapping("/addCustomer")
//    public CustomerDTO addCustomers(@RequestBody CustomerDTO customerDTO) throws Exception {
//        logger.info("REAL_STORE: ADD CUSTOMER METHOD STARTED");
//        return customerService.addCustomer(customerDTO);
//    }
//    @GetMapping("/getCustomerById")
//    public CustomerDTO getCustomer(@RequestParam("customerId") Long customerId){
//        logger.info("REAL_STORE: GET CUSTOMER BY ID METHOD STARTED");
//        return customerService.getCustomerById(customerId);
//    }
//    @GetMapping("/getAllCustomers")
//    public List<CustomerDTO> getCustomers(){
//        logger.info("REAL_STORE: GET ALL CUSTOMERS METHOD STARTED");
//        return customerService.getAllCustomers();
//    }
//    @PostMapping("/addOrderToCustomer")
//    public void addOrderToCustomer(@RequestParam("customerId") Long customerId, @RequestParam("orderId") Long orderId){
//        logger.info("REAL_STORE: ADD ORDER TO CUSTOMER METHOD STARTED");
//        customerService.addOrderToCustomer(customerId,orderId);
//    }
//
//
//    //update and delete
//
//}
