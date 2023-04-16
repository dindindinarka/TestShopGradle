package org.example.controller;

import org.example.Goods;
import org.example.Order;
import org.example.User;
import org.example.components.GoodsComponent;
import org.example.components.OrderComponent;
import org.example.components.ServeComponent;
import org.example.components.UserComponent;
import org.springdoc.api.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping
@RestController
public class TestShopApplicationController {
    @Autowired
    UserComponent userComponent;

    @Autowired
    OrderComponent orderComponent;

    @Autowired
    GoodsComponent goodsComponent;

    @Autowired
    ServeComponent serveComponent;

    @GetMapping("getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userComponent.getAllUsers());
    }

    @GetMapping("orderByPhoneNumber")
    public ResponseEntity<List<Order>> getOrdersByPhoneNumber(
            @RequestParam String phoneNumber) {
        return ResponseEntity.ok(orderComponent.getAllOrdersByUser(phoneNumber));
    }

    @PostMapping("createOrder")
    public ResponseEntity<Order> createOrder(
            @RequestParam String userName,
            @RequestParam String phoneNumber,
            @RequestParam String productName) {
        return ResponseEntity.ok(orderComponent.createOrder(userName, phoneNumber, productName));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorMessage> handleException(NoSuchElementException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(exception.getMessage()));
    }

    @PostMapping("createGood")
    public ResponseEntity<Goods> createGoods(
            @RequestParam String name,
            @RequestParam double price) {
        return ResponseEntity.ok(goodsComponent.addNewGood(name, price));
    }

}
