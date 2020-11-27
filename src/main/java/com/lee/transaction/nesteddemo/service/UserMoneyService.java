package com.lee.transaction.nesteddemo.service;

import com.lee.transaction.nesteddemo.entity.UserMoneyPo;
import com.lee.transaction.nesteddemo.entity.UserPo;
import com.lee.transaction.nesteddemo.mapper.UserMapper;
import com.lee.transaction.nesteddemo.mapper.UserMoneyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author changle
 * @date 2020/11/26
 */
@Slf4j
@Service
public class UserMoneyService {
    @Resource
    private UserMoneyMapper userMoneyMapper;

    @Transactional(rollbackFor = Exception.class, propagation= Propagation.REQUIRED)
    public boolean createUserBalance(Integer userId, String remark){
        userMoneyMapper.insert(UserMoneyPo.builder()
                .userId(userId)
                .balance(11)
                .remark("REQUIRED:"+remark).build());
        if (remark.contains("childError")) {
            throw new RuntimeException("childMethod 手动抛错");
        }
        return true;
    }

    @Transactional(rollbackFor = Exception.class, propagation= Propagation.NESTED)
    public boolean createUserBalanceNested(Integer userId, String remark){
        userMoneyMapper.insert(UserMoneyPo.builder()
                .userId(userId)
                .balance(11)
                .remark("NESTED:"+remark).build());
        log.error("余额创建成功-------手动回滚-------");
        if (remark.contains("childError")) {
            throw new RuntimeException("childMethod 手动抛错");
        }
        return true;
    }

    
}
