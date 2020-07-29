package example.controller;

import example.OperationResponse;
import example.entity.ReduceBalanceRequestVO;
import example.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/payment")
@Slf4j
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/reduce-balance")
    @ResponseBody
    public OperationResponse reduceBalance(@Valid @RequestBody ReduceBalanceRequestVO reduceBalanceRequestVO) throws Exception {
        log.info("收到下单请求, 用户:{}, 扣减金额:{}, 数量:{}", reduceBalanceRequestVO.getUserId(), reduceBalanceRequestVO.getPrice());
        return paymentService.reduceBalance(reduceBalanceRequestVO);
    }
}