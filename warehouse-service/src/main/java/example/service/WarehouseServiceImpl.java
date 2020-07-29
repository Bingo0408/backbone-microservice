package example.service;

import example.OperationResponse;
import example.dao.ProductDao;
import example.entity.Product;
import example.entity.ReduceStockRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public OperationResponse reduceStock(ReduceStockRequestVO reduceStockRequestVO) throws Exception {
        Long productId = reduceStockRequestVO.getProductId();
        Integer amount = reduceStockRequestVO.getAmount();
        // 检查库存
        checkStock(productId, amount);
        log.info("开始扣减 {} 库存", productId);
        // 扣减库存
        Product product = productDao.selectById(productId);
        product.setStock(product.getStock() - amount);
        Integer record = productDao.updateById(product);
        log.info("扣减ID: {} 库存结果: {}", productId, record > 0 ? "成功" : "失败");

        if(reduceStockRequestVO.isThrowException())
            throw new RuntimeException("扣减库存中发生异常, productId: " + productId);

        return OperationResponse.builder()
                .success(record > 0)
                .build();
    }

    private void checkStock(Long productId, Integer requiredAmount) throws Exception {
        log.info("检查ID: {} 库存", productId);
        Product product = productDao.selectById(productId);
        if (product.getStock() < requiredAmount) {
            log.warn("ID:{} 库存不足，当前库存:{}", productId, product.getStock());
            throw new Exception("库存不足");
        }
    }
}
