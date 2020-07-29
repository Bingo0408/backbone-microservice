package example.service;

import example.OperationResponse;
import example.entity.ReduceBalanceRequestVO;

public interface PaymentService {
    OperationResponse reduceBalance(ReduceBalanceRequestVO reduceBalanceRequestVO) throws Exception;
}
