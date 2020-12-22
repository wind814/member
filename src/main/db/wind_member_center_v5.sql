/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : wind_member_center

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-12-16 16:28:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `money` decimal(10,2) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '王海楠', '512.34', '18210451410', '2020-12-15 21:28:31', '2020-12-15 21:28:31', 'DELETE');
INSERT INTO `member` VALUES ('2', '王海楠', '512.34', '18210451410', '2020-12-15 14:11:42', '2020-12-15 22:11:41', 'USE');
INSERT INTO `member` VALUES ('3', '王海楠', '512.34', '18210451410', '2020-12-15 14:12:25', '2020-12-15 22:12:25', 'USE');
INSERT INTO `member` VALUES ('4', '王海楠', '512.34', '18210451410', '2020-12-15 14:12:35', '2020-12-15 22:12:35', 'USE');
INSERT INTO `member` VALUES ('5', '王海楠', '512.34', '18210451410', '2020-12-15 14:14:47', '2020-12-15 22:14:47', 'USE');
INSERT INTO `member` VALUES ('6', '王海楠', '512.34', '18210451410', '2020-12-15 14:20:06', '2020-12-15 22:20:06', 'USE');
INSERT INTO `member` VALUES ('7', '王海楠', '512.34', '18210451410', '2020-12-15 14:26:36', '2020-12-15 22:26:35', 'USE');
INSERT INTO `member` VALUES ('8', '王海楠', '512.34', '18210451410', '2020-12-15 14:27:56', '2020-12-15 22:27:56', 'USE');
INSERT INTO `member` VALUES ('9', '王海楠', '512.34', '18210451410', '2020-12-15 14:35:47', '2020-12-15 22:35:47', 'DELETE');
INSERT INTO `member` VALUES ('10', '王海楠wind', '200.00', '18210451410', '2020-12-15 14:37:43', '2020-12-16 07:17:08', 'USE');
INSERT INTO `member` VALUES ('11', '王海楠', '453.23', '18210451410', '2020-12-16 06:57:19', '2020-12-16 06:57:19', 'USE');

-- ----------------------------
-- Table structure for `member_operations`
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of member_operations
-- ----------------------------
INSERT INTO `member_operations` VALUES ('1', '1', '1', null, 'memberAdd', '{\"createAt\":1608041545093,\"id\":3,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:12:28');
INSERT INTO `member_operations` VALUES ('2', '1', '1', null, 'memberAdd', '{\"createAt\":1608041555184,\"id\":4,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:12:58');
INSERT INTO `member_operations` VALUES ('3', '1', '1', null, 'memberAdd', '{\"createAt\":1608041687460,\"id\":5,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:14:58');
INSERT INTO `member_operations` VALUES ('4', '1', '1', null, 'memberAdd', '{\"createAt\":1608042005964,\"id\":6,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:20:33');
INSERT INTO `member_operations` VALUES ('5', '1', '1', null, 'memberAdd', '{\"createAt\":1608042395735,\"id\":7,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:26:57');
INSERT INTO `member_operations` VALUES ('6', '1', '1', null, 'memberAdd', '{\"createAt\":1608042476230,\"id\":8,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:28:07');
INSERT INTO `member_operations` VALUES ('7', '1', '9', null, 'memberAdd', '{\"createAt\":1608042947393,\"createTime\":\"2020-12-15 22:35:47\",\"id\":9,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:35:48');
INSERT INTO `member_operations` VALUES ('8', '1', '10', null, 'memberAdd', '{\"createTime\":\"2020-12-15 22:37:43\",\"id\":10,\"money\":512.34,\"name\":\"王海楠\",\"telephone\":\"18210451410\"}', '2020-12-15 14:37:43');
INSERT INTO `member_operations` VALUES ('9', '1', '9', null, 'memberDelete', '{\"createAt\":1608042947000,\"createTime\":\"2020-12-15 22:35:47\",\"id\":9,\"money\":512.34,\"name\":\"王海楠\",\"state\":\"\",\"telephone\":\"18210451410\"}', '2020-12-16 07:05:06');
INSERT INTO `member_operations` VALUES ('10', '1', '10', null, 'memberUpdate', '{\"new\":{\"createAt\":1608043063000,\"createTime\":\"2020-12-15 22:37:43\",\"id\":10,\"money\":200.00,\"name\":\"王海楠wind\",\"state\":\"USE\",\"telephone\":\"18210451410\"},\"old\":{\"createAt\":1608043063000,\"createTime\":\"2020-12-15 22:37:43\",\"id\":10,\"money\":512.34,\"name\":\"王海楠\",\"state\":\"USE\",\"telephone\":\"18210451410\"}}', '2020-12-16 07:17:08');
INSERT INTO `member_operations` VALUES ('11', '1', '1', null, 'memberRecordAdd', '{\"createTime\":\"2020-12-16 16:14:45\",\"id\":1,\"memberId\":10,\"memberName\":\"王海楠wind\",\"money\":243.23,\"state\":\"USE\"}', '2020-12-16 08:14:45');
INSERT INTO `member_operations` VALUES ('12', '1', '10', '1', 'memberRecordDelete', '{\"createAt\":1608106485000,\"id\":1,\"memberId\":10,\"memberName\":\"王海楠wind\",\"money\":243.23,\"state\":\"USE\"}', '2020-12-16 08:17:08');
INSERT INTO `member_operations` VALUES ('13', '1', '10', '1', 'memberRecordDelete', '{\"createAt\":1608106485000,\"id\":1,\"memberId\":10,\"memberName\":\"王海楠wind\",\"money\":243.23,\"state\":\"USE\"}', '2020-12-16 08:21:56');
INSERT INTO `member_operations` VALUES ('14', '1', '10', '2', 'memberRecordAdd', '{\"createTime\":\"2020-12-16 16:24:40\",\"id\":2,\"memberId\":10,\"memberName\":\"王海楠wind\",\"money\":1243.23,\"state\":\"USE\"}', '2020-12-16 08:24:40');
INSERT INTO `member_operations` VALUES ('15', '1', '10', '2', 'memberRecordDelete', '{\"createAt\":1608107080000,\"id\":2,\"memberId\":10,\"memberName\":\"王海楠wind\",\"money\":1243.23,\"state\":\"USE\"}', '2020-12-16 08:25:17');

-- ----------------------------
-- Table structure for `member_record`
-- ----------------------------
DROP TABLE IF EXISTS `member_record`;
CREATE TABLE `member_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(255) NOT NULL,
  `member_name` varchar(255) NOT NULL,
  `money` decimal(10,2) NOT NULL,
  `state` varchar(255) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of member_record
-- ----------------------------
INSERT INTO `member_record` VALUES ('1', '10', '王海楠wind', '243.23', 'DELETE', null, '2020-12-16 16:21:55');
INSERT INTO `member_record` VALUES ('2', '10', '王海楠wind', '1243.23', 'DELETE', null, '2020-12-16 16:24:59');
