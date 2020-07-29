package example.service;

import example.OperationResponse;
import example.entity.ReduceStockRequestVO;

public interface WarehouseService {
    OperationResponse reduceStock(ReduceStockRequestVO reduceStockRequestVO) throws Exception;
}
