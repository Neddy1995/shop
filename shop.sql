/*
 Navicat MySQL Data Transfer

 Source Server         : 27
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 30/01/2019 14:52:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business`  (
  `business_id` int(255) NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`business_id`) USING BTREE,
  INDEX `business_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `business_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `good_id` int(255) NOT NULL COMMENT '商品id',
  `good_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `good_version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本',
  `good_colour` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '颜色',
  `good_price` decimal(10, 2) NOT NULL COMMENT '价格',
  `stock_num` int(10) NULL DEFAULT NULL COMMENT '库存数量',
  `sold_num` int(10) NULL DEFAULT NULL COMMENT '出售数量',
  `detail_id` int(255) NULL DEFAULT NULL COMMENT '商品详情表（外键）',
  PRIMARY KEY (`good_id`) USING BTREE,
  INDEX `good_id`(`good_id`) USING BTREE,
  INDEX `detail_id`(`detail_id`) USING BTREE,
  CONSTRAINT `detail_id` FOREIGN KEY (`detail_id`) REFERENCES `good_detials` (`detial_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for good_detials
-- ----------------------------
DROP TABLE IF EXISTS `good_detials`;
CREATE TABLE `good_detials`  (
  `detial_id` int(255) NOT NULL COMMENT '商品详情id',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片路径',
  `date_time` date NULL DEFAULT NULL COMMENT '上架时间',
  `Intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '类型id（外键）',
  `business_id` int(255) NULL DEFAULT NULL COMMENT '商家id（外键）',
  PRIMARY KEY (`detial_id`) USING BTREE,
  INDEX `type_id`(`type_id`) USING BTREE,
  INDEX `business_id`(`business_id`) USING BTREE,
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `business_id` FOREIGN KEY (`business_id`) REFERENCES `business` (`business_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(255) NOT NULL COMMENT '订单id',
  `begin_time` date NOT NULL COMMENT '下单时间',
  `end_time` date NULL DEFAULT NULL COMMENT '结束时间',
  `state` int(2) NULL DEFAULT NULL COMMENT '订单状态（0：失败订单，1：成功完成订单，2：未支付，3：未发货，4：发货中，5：已收货）',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id（外键）',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for order_details
-- ----------------------------
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details`  (
  `detail_id` int(255) NOT NULL COMMENT '订单详情id',
  `order_id` int(255) NULL DEFAULT NULL COMMENT '订单id（外键）',
  `good_id` int(255) NULL DEFAULT NULL COMMENT '商品id（外键）',
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  INDEX `good_id`(`good_id`) USING BTREE,
  CONSTRAINT `good_id` FOREIGN KEY (`good_id`) REFERENCES `good` (`good_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `type_id` int(255) NOT NULL COMMENT '类别id',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码，长度为16位',
  `sex` int(3) NULL DEFAULT NULL COMMENT '年龄',
  `profession` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `regtime` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `power` int(2) NULL DEFAULT NULL COMMENT '权限(区分用户，1：购物者，2：商家，3：管理者)',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
