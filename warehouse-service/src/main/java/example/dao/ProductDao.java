package example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import example.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao extends BaseMapper<Product> {

}
