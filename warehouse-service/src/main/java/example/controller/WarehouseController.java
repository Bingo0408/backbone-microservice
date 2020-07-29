package example.controller;

import example.OperationResponse;
import example.entity.ReduceStockRequestVO;
import example.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/warehouse")
@Slf4j
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping("/reduce-stock")
    @ResponseBody
    public OperationResponse reduceStock(@Valid @RequestBody ReduceStockRequestVO reduceStockRequestVO) throws Exception {
        log.info("======收到减库存请求, 商品:{}, 数量:{}======", reduceStockRequestVO.getProductId(), reduceStockRequestVO.getAmount());
        return warehouseService.reduceStock(reduceStockRequestVO);
    }
}