package org.example.service;

import org.example.OperationResponse;
import org.example.entity.PlaceOrderRequestVO;

public interface OrderService {
    OperationResponse placeOrder(PlaceOrderRequestVO placeOrderRequestVO) throws Exception;
}
