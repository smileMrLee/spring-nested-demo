package com.lee.transaction.nesteddemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:39
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "demo_user")
public class UserPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String passWord;
    @Column(name = "real_name")
    private String realName;
    @Column(name = "remark")
    private String remark;
}
