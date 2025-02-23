package com.example.Real_Store.service.serviceImpl;
import com.example.Real_Store.entity.*;
import com.example.Real_Store.repository.*;
import com.example.Real_Store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.*;

import static com.example.Real_Store.constants.RealStoreConstants.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public OrderRepository orderRepository;
    @Autowired
    public CartRepository cartRepository;
    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public PaymentRepository paymentRepository;

    @Override
    public Map<String,Object> calculateTotalAmount(List<Cart> cartList, Long userId) {
        Map<String,Object> map = new HashMap<>();
        List<Cart> carts = cartList.stream().filter(cart -> cart.getUserId()==userId).toList();
        Customer customer = userRepository.findById(userId).get();
            double totalAmount = carts.stream().mapToDouble(cart->cart.getTotalAmount()).sum();
            Booking booking = new Booking();
            booking.setTotalAmount(totalAmount);
            booking.setOrderStatus(PENDING);
            booking.setPaymentStatus(PAYMENT_INPROGRESS);
            booking.setDate(new Date());
            booking.setCustomer(customer);
            map.put("totalAmount",totalAmount);
            map.put("booking",booking);
            orderRepository.save(booking);
            carts.forEach(cart -> {
                Product product = productRepository.findById(cart.getProductId()).get();
                double decreaseQuantity = product.getStockQuantity()-cart.getRequiredQuantity();
                product.setStockQuantity((int) decreaseQuantity);
                cartRepository.delete(cart);
            });
        return map;
    }

    @Override
    public Booking getOrderById(Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    @Override
    public void updatePayment_OrderStatus(Booking booking, Long userId, Double totalAmount, String paymentMethod) {
        booking.setPaymentStatus(PAYMENT_SUCCESFUL);
        booking.setOrderStatus(ORDER_PLACED);
        Payment payment = new Payment();
        payment.setPaymentDate(new Date());
        payment.setPaymentMethod(paymentMethod);
        payment.setPaymentAmount(totalAmount);
        payment.setPaymentStatus(PAYMENT_SUCCESFUL);
        payment.setBooking(booking);
        paymentRepository.save(payment);
        orderRepository.save(booking);
    }
}
