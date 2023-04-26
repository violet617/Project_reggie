package Project_reggie.service;

import Project_reggie.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.core.annotation.Order;


public interface OrdersService extends IService<Orders> {
    public void submit(Orders orders);
}
