//package com.example.Real_Store.service.serviceImpl;
//
//import com.example.Real_Store.conversion.ConversionClass;
//import com.example.Real_Store.dto.CustomerDTO;
//import com.example.Real_Store.entity.Booking;
//import com.example.Real_Store.entity.Customer;
//import com.example.Real_Store.repository.CustomerRepository;
//import com.example.Real_Store.repository.OrderRepository;
//import com.example.Real_Store.service.CustomerService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//    public static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
//
//    @Autowired
//    public ConversionClass conversionClass;
//    @Autowired
//    public CustomerRepository customerRepository;
//    @Autowired
//    public OrderRepository orderRepository;
//
//    @Override
//    public CustomerDTO addCustomer(CustomerDTO customerDTO){
//        if(Objects.nonNull(customerDTO)){
//            Customer customer = conversionClass.CustomerDTO_To_CustomerEntity(customerDTO);
//            customerRepository.save(customer);
//            logger.info("REAL_STORE: CUSTOMER ADDED {}", customerDTO);
//            return conversionClass.CustomerEntity_To_CustomerDTO(customer);
//        }else{
//            logger.info("REAL_STORE: ADD CUSTOMER- customerDTO should not be Null {}", customerDTO);
//        }
//        return null;
//    }
//
//    @Override
//    public CustomerDTO getCustomerById(Long customerId) {
//        if(customerId != null) {
//            Customer customer = customerRepository.findById(customerId).get();
//            logger.info("REAL_STORE: GET CUSTOMER BY ID {}", customerId);
//            return conversionClass.CustomerEntity_To_CustomerDTO(customer);
//        }else {
//            logger.info("REAL_STORE: GET CUSTOMER BY ID- customerId should not be Null {}", customerId);
//        }
//    }
//
//    @Override
//    public List<CustomerDTO> getAllCustomers() {
//        logger.info("REAL_STORE: GET ALL CUSTOMERS ");
//        return customerRepository.
//                findAll().stream().
//                map(customer -> convertCustomerToCustomerDTO(customer)).toList();
//    }
//
//    @Override
//    public void addOrderToCustomer(Long customerId, Long orderId) {
//        Customer customer = customerRepository.findById(customerId).get();
//        Booking booking = orderRepository.findById(orderId).get();
//        customer.getOrderList().add(booking);
//        booking.setCustomer(customer);
//        orderRepository.save(booking);
//    }
//
//    public CustomerDTO convertCustomerToCustomerDTO(Customer customer){
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerId(customer.getCustomerId());
//        customerDTO.setFirstName(customer.getFirstName());
//        customerDTO.setLastName(customer.getLastName());
//        customerDTO.setPhoneNo(customer.getPhoneNo());
//        customerDTO.setEmail(customer.getEmail());
//        customerDTO.setAddress(customer.getAddress());
//        return customerDTO;
//    }
//
//
//}
