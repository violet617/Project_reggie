package Project_reggie.service;

import Project_reggie.dto.DishDto;
import Project_reggie.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface DishService extends IService<Dish> {

    public void saveWithFlavor(DishDto dishDto);
    public DishDto getByIdWithFlavor(Long id);
    public void updateWithFlavor(DishDto dishDto);
    public void removeWithFlavor(List<Long> id);
}
