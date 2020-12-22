/*
 Navicat MySQL Data Transfer

 Source Server         : mysql_5.7
 Source Server Version : 50713
 Source Host           : localhost
 Source Database       : wind_member_center

 Target Server Version : 50713
 File Encoding         : utf-8

 Date: 12/15/2020 22:38:31 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `money` decimal(10,2) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `member`
-- ----------------------------
BEGIN;
INSERT INTO `member` VALUES ('1', '王海楠', '512.34', '18210451410', '2020-12-15 21:28:31', '2020-12-15 21:28:31'), ('2', '王海楠', '512.34', '18210451410', '2020-12-15 14:11:42', '2020-12-15 22:11:41'), ('3', '王海楠', '512.34', '18210451410', '2020-12-15 14:12:25', '2020-12-15 22:12:25'), ('4', '王海楠', '512.34', '18210451410', '2020-12-15 14:12:35', '2020-12-15 22:12:35'), ('5', '王海楠', '512.34', '18210451410', '2020-12-15 14:14:47', '2020-12-15 22:14:47'), ('6', '王海楠', '512.34', '18210451410', '2020-12-15 14:20:06', '2020-12-15 22:20:06'), ('7', '王海楠', '512.34', '18210451410', '2020-12-15 14:26:36', '2020-12-15 22:26:35'), ('8', '王海楠', '512.34', '18210451410', '2020-12-15 14:27:56', '2020-12-15 22:27:56'), ('9', '王海楠', '512.34', '18210451410', '2020-12-15 14:35:47', '2020-12-15 22:35:47'), ('10', '王海楠', '512.34', '18210451410', '2020-12-15 14:37:43', '2020-12-15 22:37:43');
COMMIT;

-- ----------------------------
--  Table structure for `member_operations`
-- ----------------------------
DROP TABLE IF EXISTS `member_operations`;
CREATE TABLE `member_operations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  `member_record_id` bigint(20) DEFAULT NULL,
  `operation` varchar(255) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `member_operations`
-- ----------------------------
BEGIN;
INSERT INTO `member_operations` VALUES ('1', '1', '1', null, 'memberAdd', '{\"createAt\":1608041545093,\"id\":3,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:12:28'), ('2', '1', '1', null, 'memberAdd', '{\"createAt\":1608041555184,\"id\":4,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:12:58'), ('3', '1', '1', null, 'memberAdd', '{\"createAt\":1608041687460,\"id\":5,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:14:58'), ('4', '1', '1', null, 'memberAdd', '{\"createAt\":1608042005964,\"id\":6,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:20:33'), ('5', '1', '1', null, 'memberAdd', '{\"createAt\":1608042395735,\"id\":7,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:26:57'), ('6', '1', '1', null, 'memberAdd', '{\"createAt\":1608042476230,\"id\":8,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:28:07'), ('7', '1', '9', null, 'memberAdd', '{\"createAt\":1608042947393,\"createTime\":\"2020-12-15 22:35:47\",\"id\":9,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:35:48'), ('8', '1', '10', null, 'memberAdd', '{\"createTime\":\"2020-12-15 22:37:43\",\"id\":10,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:37:43');
COMMIT;

-- ----------------------------
--  Table structure for `member_record`
-- ----------------------------
DROP TABLE IF EXISTS `member_record`;
CREATE TABLE `member_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` varchar(255) NOT NULL,
  `member_name` varchar(255) NOT NULL,
  `money` decimal(10,2) NOT NULL,
  `state` varchar(255) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
