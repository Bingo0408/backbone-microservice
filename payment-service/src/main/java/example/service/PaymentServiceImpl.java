package example.service;

import example.OperationResponse;
import example.dao.AccountDao;
import example.entity.Account;
import example.entity.ReduceBalanceRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private AccountDao accountDao;

    @Transactional
    @Override
    public OperationResponse reduceBalance(ReduceBalanceRequestVO reduceBalanceRequestVO) throws Exception {

        String userId = reduceBalanceRequestVO.getUserId();
        Integer price = reduceBalanceRequestVO.getPrice();

        checkBalance(userId, price);

        log.info("开始扣减用户 {} 余额", userId);
        Account account = accountDao.selectById(userId);

        account.setBalance(account.getBalance() - price);
        Integer record = accountDao.updateById(account);

        log.info("扣减用户 {} 余额结果:{}", userId, record > 0 ? "操作成功" : "扣减余额失败");

        if(reduceBalanceRequestVO.isThrowException())
            throw new RuntimeException("扣减余额出错, 用户ID为: " + userId);

        return OperationResponse.builder()
                .success(record > 0)
                .build();
    }

    private void checkBalance(String userId, Integer price) throws Exception {
        log.info("检查用户 {} 余额", userId);
        Account account = accountDao.selectById(userId);

        Integer balance = account.getBalance();

        if (balance < price) {
            log.warn("用户 {} 余额不足，当前余额:{}", userId, balance);
            throw new Exception("余额不足");
        }

    }

}

