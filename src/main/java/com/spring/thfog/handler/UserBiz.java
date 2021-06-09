package com.spring.thfog.handler;

import com.spring.thfog.entity.User;
import com.spring.thfog.handler.common.DescribableEnum;
import com.spring.thfog.handler.common.JsonResult;
import com.spring.thfog.handler.common.ReturnObject;
import com.spring.thfog.repository.BookRepository;
import com.spring.thfog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @Title
 * @ClassName BookBiz
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/8 23:00
 * @Version 1.0
 **/
@Component
public class UserBiz {
    @Autowired
    UserRepository userRepository;

    public ReturnObject checkUserLogin(String username, String password) {
        ReturnObject returnObject = new ReturnObject();
        User userCheck=userRepository.checkUserLogin(username);
        if (null==userCheck){
            returnObject.setState(-1);
            returnObject.setErrmsg("未找到["+username+"]对应的用户信息");
            return returnObject;
        }else {
            if (userCheck.getPassword().equals(password)){
                returnObject.setResult(userCheck);
                return returnObject;
            }else {
                returnObject.setState(-1);
                returnObject.setErrmsg("密码不正确！");
                return returnObject;
            }
        }
    }

    public ReturnObject registerLoginUser(String username, String password) {
        ReturnObject returnObject = new ReturnObject();
        //是否存在用户名
        User userCheck=userRepository.checkUserLogin(username);
        if (null==userCheck){
            User usernew= new User();
            usernew.setUsername(username);
            usernew.setPassword(password);
            usernew.setCreattime(new Date());
            userRepository.saveAndFlush(usernew);

            returnObject.setResult(userRepository.checkUserLogin(username));
            return returnObject;
        }else {
            returnObject.setState(-1);
            returnObject.setErrmsg("已存在["+username+"]对应的用户信息，请重新输入用户名。");
            return returnObject;
        }
    }
}
