package Project_reggie.controller;

import Project_reggie.common.R;
import Project_reggie.entity.User;
import Project_reggie.service.UserService;
import Project_reggie.utils.ValidateCodeUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession httpSession){
       String phone=user.getPhone();
       if(StringUtils.isNotBlank(phone)){
           String code= ValidateCodeUtils.generateValidateCode(4).toString();
           log.info("code={}",code);

           //httpSession.setAttribute(phone,code);
           redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
           return R.success("验证码发送成功");
       }
       return R.error("发送失败");
   }

    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession httpSession){
        log.info(map.toString());
        String phone = map.get("phone").toString();
        String code = map.get("code").toString();

        /*Object attribute = httpSession.getAttribute(phone);
        if(attribute!=null&& attribute.equals(code)){
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);
            User user =userService.getOne(queryWrapper);
            if(user==null){
                user =new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            httpSession.setAttribute("user",user.getId());
            return R.success(user);*/
        Object codeRedis = redisTemplate.opsForValue().get(phone);
        log.info("code={},httpSession={}",code,codeRedis);
        if(code!=null&&code.equals(codeRedis)){
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);
            User user= userService.getOne(queryWrapper);
            if(user==null){
                user = new User();
                user.setPhone(phone);
                user.setName(codeRedis.toString());
                user.setStatus(1);
                userService.save(user);
            }
            httpSession.setAttribute("user",user.getId());
            redisTemplate.delete(phone);
            return R.success(user);
    }
        return R.error("登录失败");
    }

    //用户登出
    @PostMapping("/loginout")
    public R<String> loginout(HttpServletRequest request){
        //清理Session中保存的当前用户登录的id
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }

}
