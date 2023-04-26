package Project_reggie.service.impl;

import Project_reggie.entity.DishFlavor;
import Project_reggie.mapper.DishFlavorMapper;
import Project_reggie.service.DishFlavorService;
import Project_reggie.service.DishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
