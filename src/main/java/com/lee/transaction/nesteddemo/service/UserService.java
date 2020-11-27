package com.lee.transaction.nesteddemo.service;

import com.lee.transaction.nesteddemo.entity.UserPo;
import com.lee.transaction.nesteddemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author changle
 * @date: 2020/11/26 0026
 */
@Slf4j
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserMoneyService userMoneyService;

    @Transactional(rollbackFor = Exception.class, propagation= Propagation.REQUIRED)
    public Boolean createUserRequired(String userName, String remark){
        UserPo userPo = UserPo.builder()
                .userName(userName)
                .realName("真实的"+userName)
                .passWord("REQUIRED")
                .remark("REQUIRED:" + remark).build();
        userMapper.insert(userPo);
        userMoneyService.createUserBalance(userPo.getId(), remark);
        if (remark.contains("mainError")) {
            throw new RuntimeException("mainMethod 手动抛错");
        }
        return true;
    }

    @Transactional(rollbackFor = Exception.class, propagation= Propagation.REQUIRED)
    public Boolean createUserNested(String userName, String remark){
        UserPo userPo = UserPo.builder()
                .userName(userName)
                .realName("真实的"+userName)
                .passWord("REQUIRED")
                .remark("REQUIRED:" + remark).build();
        userMapper.insert(userPo);
        try {
            userMoneyService.createUserBalanceNested(userPo.getId(), remark);
        }catch (Exception e){
            log.error("创建用户余额时异常|userName:{},remark:{}", userName, remark, e);
        }
        if (remark.contains("mainError")) {
            throw new RuntimeException("mainMethod 手动抛错");
        }
        return true;
    }

}
