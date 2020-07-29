package example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Account {

    @TableId(type = IdType.AUTO)
    private String user_id;

    private Integer balance;
}
