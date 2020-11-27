package com.lee.transaction.nesteddemo.mapper;

import com.lee.transaction.nesteddemo.MyMapper;
import com.lee.transaction.nesteddemo.entity.UserPo;
import org.springframework.stereotype.Repository;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface UserMapper extends MyMapper<UserPo> {

    UserPo select(int id);
}
