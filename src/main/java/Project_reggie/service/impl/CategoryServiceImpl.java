package Project_reggie.service.impl;

import Project_reggie.common.CustomException;
import Project_reggie.entity.Category;
import Project_reggie.entity.Dish;
import Project_reggie.entity.Setmeal;
import Project_reggie.mapper.CategoryMapper;
import Project_reggie.service.CategoryService;
import Project_reggie.service.DishService;
import Project_reggie.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    @Override
    public void remove(Long id) {

        //是否关联了菜品
        LambdaQueryWrapper<Dish> dispatch = new LambdaQueryWrapper<>();
        dispatch.eq(Dish::getCategoryId,id);
        int count1 = dishService.count(dispatch);
        if(count1 > 0){
            throw new CustomException("当前分类下关联了菜品，不能删除");
        }

        //是否关联了套餐
        LambdaQueryWrapper<Setmeal> setmealpatch = new LambdaQueryWrapper<>();
        setmealpatch.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count(setmealpatch);
        if(count2 > 0){
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }

        //正常删除
        super.removeById(id);
    }
}
