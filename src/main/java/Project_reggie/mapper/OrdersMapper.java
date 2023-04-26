package Project_reggie.mapper;

import Project_reggie.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}
