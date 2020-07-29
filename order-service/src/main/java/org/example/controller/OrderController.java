package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.OperationResponse;
import org.example.entity.PlaceOrderRequestVO;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place-order")
    @ResponseBody
    public OperationResponse placeOrder(@Valid @RequestBody PlaceOrderRequestVO placeOrderRequestVO) throws Exception {
        log.info("收到下单请求, 用户:{}, 商品:{}, 数量:{}", placeOrderRequestVO.getUserId(), placeOrderRequestVO.getProductId(), placeOrderRequestVO.getAmount());
        return orderService.placeOrder(placeOrderRequestVO);
    }
}