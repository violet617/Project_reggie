package Project_reggie.service.impl;

import Project_reggie.entity.User;
import Project_reggie.mapper.UserMapper;
import Project_reggie.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
