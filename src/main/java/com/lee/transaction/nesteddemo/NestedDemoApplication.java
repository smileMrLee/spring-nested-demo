package com.lee.transaction.nesteddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 数据库脚本参看本项目根路径：lee_test.sql 文件
 */
@MapperScan(basePackages = {"com.lee.transaction.nesteddemo.mapper"})
@SpringBootApplication
public class NestedDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NestedDemoApplication.class, args);
	}

}
