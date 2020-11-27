/*
 Navicat Premium Data Transfer

 Source Server         : lby-rds
 Source Server Type    : MySQL
 Source Server Version : 50616
 Source Host           : rm-8vbep090lnm6uw9cs3o.mysql.zhangbei.rds.aliyuncs.com:3306
 Source Schema         : lee_test

 Target Server Type    : MySQL
 Target Server Version : 50616
 File Encoding         : 65001

 Date: 27/11/2020 17:34:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for demo_user
-- ----------------------------
DROP TABLE IF EXISTS `demo_user`;
CREATE TABLE `demo_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `real_name` varchar(30) DEFAULT NULL COMMENT '真实姓名',
  `remark` varchar(255) DEFAULT NULL COMMENT '事务标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for demo_user_money
-- ----------------------------
DROP TABLE IF EXISTS `demo_user_money`;
CREATE TABLE `demo_user_money` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `balance` int(255) DEFAULT NULL COMMENT '钱包余额',
  `remark` varchar(255) DEFAULT NULL COMMENT '事务标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
