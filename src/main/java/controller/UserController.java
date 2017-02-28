package controller;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;
import java.util.HashMap;

/**
 * Created by lzw on 16-9-4.
 */

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value="/register")
    public HashMap<String,Object> register(@RequestParam String userName, @RequestParam String passwd)
    {
        HashMap<String ,Object> result=new HashMap<String,Object>();
        User user=userService.getUserByUserName(userName);
        if(user ==null)
        {
            result.put("status",UserService.USER_NOT_EXITED);
            result.put("message","用户名已存在");
            return result;
        }else{
            User inputUser=new User();
            inputUser.setUsername(userName);
            inputUser.setPassword(passwd);
            userService.insertUser(inputUser);

            result.put("status",UserService.SUCCESS);
            result.put("message","注册成功");
            return result;
        }
    }
    @RequestMapping(value="/loginByUser")
    public HashMap<String,Object> loginByUser(@RequestParam String userName,@RequestParam String passwd)
    {
        HashMap<String ,Object> result=new HashMap<String,Object>();
        switch (userService.checkUserPasswd(userName,passwd))
        {
            case UserService.SUCCESS:
                String token=userService.updateUserToken(userService.getUserByUserName(userName));

                result.put("token",token);
                result.put("status",UserService.SUCCESS);
                result.put("message","登录成功");
                break;
            case UserService.PASSWD_WRONG:
                result.put("status",UserService.PASSWD_WRONG);
                result.put("message","密码错误");
                break;
            case UserService.USER_NOT_EXITED:
                result.put("status",UserService.USER_NOT_EXITED);
                result.put("message","用户名不存在");
                break;
            default:
                break;
        }
        return result;
    }

    @RequestMapping(value="/loginByToken")
    public String loginByToken(@RequestParam String token)
    {
        HashMap<String ,Object> result=new HashMap<String,Object>();
        User user=userService.getUserByToken(token);
        if(user==null)
        {
            return null;
        }
        else
        {
            return user.getUsername();
        }
    }


}
