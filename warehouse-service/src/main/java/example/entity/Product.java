package example.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class Product {
    @NotNull
    private Integer id;
    private Double price;
    @NotNull
    private Integer stock;
}
