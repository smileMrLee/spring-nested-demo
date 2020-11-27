package com.lee.transaction.nesteddemo.web;

import com.lee.transaction.nesteddemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lirong
 * @createTime 2020年11月27日 15:24
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class CrudTestController {
    @Resource
    private UserService userService;

    @GetMapping("/required")
    public String required(String name, String remark){
        try {
            boolean result = userService.createUserRequired(name, remark);
            if (result){
                return "成功";
            }else {
                return "失败";
            }
        }catch (Exception e){
            log.error("执行required事务例子异常", e);
            return "异常";
        }
    }

    @GetMapping("/nested")
    public String nested(String name, String remark){
        try {
            boolean result = userService.createUserNested(name, remark);
            if (result){
                return "成功";
            }else {
                return "失败";
            }
        }catch (Exception e){
            log.error("执行nested事务例子异常", e);
            return "异常";
        }
    }
}
