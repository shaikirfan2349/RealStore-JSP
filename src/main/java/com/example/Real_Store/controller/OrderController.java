package com.example.Real_Store.controller;

import com.example.Real_Store.dto.BookingDTO;
import com.example.Real_Store.dto.ProductDTO;
import com.example.Real_Store.entity.Booking;
import com.example.Real_Store.entity.Cart;
import com.example.Real_Store.entity.Payment;
import com.example.Real_Store.entity.Product;
import com.example.Real_Store.repository.CartRepository;
import com.example.Real_Store.service.OrderService;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    public OrderService orderService;
    @Autowired
    public CartRepository cartRepository;


    @RequestMapping("placeOrder")
    public String placeOrder(@RequestParam("cartList")List<Long> cartIds, @RequestParam("userId")Long userId, Model model){
        List<Cart> cartList = cartRepository.findAllById(cartIds);
        Map<String,Object> amountBookingMap= orderService.calculateTotalAmount(cartList,userId);
        model.addAttribute("cartList",cartList);
        model.addAttribute("userId",userId);
        model.addAttribute("totalAmount",amountBookingMap.get("totalAmount"));
        model.addAttribute("orderId",amountBookingMap.get("booking"));
        return "placeOrder";
    }

    @RequestMapping("makePayment")
    public String makePayment(@RequestParam("userId")Long userId, @RequestParam("totalAmount")Double totalAmount, @RequestParam("orderId")Long orderId, Model model){
        System.out.println(orderId);
        Booking booking = orderService.getOrderById(orderId);
        model.addAttribute("userId",userId);
        model.addAttribute("totalAmount",totalAmount);
        model.addAttribute("booking",booking);
        return "makePayment";
    }

    @RequestMapping("confirmPayment")
    public String confirmPayment(@RequestParam("userId")Long userId,@RequestParam("orderId")Long orderId,@RequestParam("totalAmount") Double totalAmount,@RequestParam("paymentMethod")String paymentMethod, Model model){
        Booking booking = orderService.getOrderById(orderId);
        orderService.updatePayment_OrderStatus(booking,userId,totalAmount,paymentMethod);
        model.addAttribute("userId",userId);
        return "Successful";
    }
}
