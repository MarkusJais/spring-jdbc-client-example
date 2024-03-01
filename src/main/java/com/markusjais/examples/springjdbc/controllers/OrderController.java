//package com.markusjais.examples.springjdbc.controllers;
//
//
//import com.markusjais.examples.springbootkafka.domain.Order;
//import com.markusjais.examples.springbootkafka.exceptions.ResourceNotFoundException;
//import com.markusjais.examples.springbootkafka.repository.OrderRepository;
//import com.markusjais.examples.springjdbc.entities.Order;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/orders")
//public class OrderController {
//
//    private final OrderRepository orderRepository;
//
//    public OrderController(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }
//
//
//    @GetMapping("/{orderId}")
//    public ResponseEntity<Order> getOrderById(@PathVariable(value = "orderId") Long orderId)
//            throws ResourceNotFoundException {
//        System.out.println("O_2");
//        var order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
//        return ResponseEntity.ok().body(order);
//    }
//
//
//    @GetMapping
//    public List<Order> getAllOrders() {
//        System.out.println("O_1");
//        var allCustomers = orderRepository.findAll();
//        return allCustomers;
//    }
////
////    @PostMapping("/customers")
////    public Customer createCustomer(@Valid @RequestBody Customer customer) {
////        System.out.println("A_3 book creation: " + customer );
////        return customerRepository.save(customer);
////    }
//
//
//
//}