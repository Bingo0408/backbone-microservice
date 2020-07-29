package org.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.OperationResponse;
import org.example.dao.OrderDao;
import org.example.entity.Order;
import org.example.entity.OrderStatus;
import org.example.entity.PlaceOrderRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author HelloWoodes
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    @Transactional
    public OperationResponse placeOrder(PlaceOrderRequestVO placeOrderRequestVO) throws Exception {

        Order order = Order.builder()
                           .userId(placeOrderRequestVO.getUserId())
                           .productId(placeOrderRequestVO.getProductId())
                           .status(OrderStatus.INIT)
                           .amount(placeOrderRequestVO.getAmount())
                           .build();

        Integer saveOrderRecord = orderDao.insert(order);
        if(placeOrderRequestVO.isThrowException())
            throw new RuntimeException("保存订单异常");
        boolean succeed = saveOrderRecord > 0 ? true : false;
        log.info("保存订单{}", succeed ? "成功" : "失败");

        return OperationResponse.builder()
                                .success(succeed)
                                .build();
    }
}
