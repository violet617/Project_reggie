package Project_reggie.service.impl;

import Project_reggie.entity.OrderDetail;
import Project_reggie.mapper.OrderDetailMapper;
import Project_reggie.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
