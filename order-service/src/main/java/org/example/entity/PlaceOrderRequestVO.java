package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/** 下单请求 VO */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrderRequestVO {

    @NotNull
    private String userId;

    @NotNull
    private String productId;

    @NotNull
    @Positive
    private Integer amount;

    @Nullable
    boolean throwException;
}
