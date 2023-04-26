package Project_reggie.service;

import Project_reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;


public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
