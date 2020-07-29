package example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

/**
 * 扣减库存请求 VO
 *
 * @author HelloWoodes
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReduceStockRequestVO {

    private Long productId;

    private Integer amount;

    @Nullable
    boolean throwException;
}
