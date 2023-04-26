package Project_reggie.service.impl;

import Project_reggie.entity.ShoppingCart;
import Project_reggie.mapper.ShoppingCartMapper;
import Project_reggie.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
