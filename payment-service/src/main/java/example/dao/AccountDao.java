package example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import example.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDao extends BaseMapper<Account> {
}