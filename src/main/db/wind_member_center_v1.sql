/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : wind_member_center

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-12-15 16:26:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` bigint(20) NOT NULL,
  `name` varchar(200) NOT NULL,
  `telephone` varchar(100) NOT NULL,
  `money` decimal(10,2) NOT NULL,
  `createAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `updateAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of member
-- ----------------------------

-- ----------------------------
-- Table structure for `member_record`
-- ----------------------------
DROP TABLE IF EXISTS `member_record`;
CREATE TABLE `member_record` (
  `id` bigint(20) NOT NULL,
  `member_id` varchar(255) NOT NULL,
  `member_name` varchar(255) NOT NULL,
  `money` decimal(10,2) NOT NULL,
  `state` varchar(255) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `createAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of member_record
-- ----------------------------
