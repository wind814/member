/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : wind_member_center

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-12-18 09:57:12
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
-- Table structure for `member_permission`
-- ----------------------------
DROP TABLE IF EXISTS `member_permission`;
CREATE TABLE `member_permission` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `descripion` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) DEFAULT NULL COMMENT '授权链接',
  `is_blank` int(255) DEFAULT '0' COMMENT '是否跳转 0 不跳转 1跳转',
  `pid` varchar(255) DEFAULT NULL COMMENT '父节点id',
  `perms` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `visible` int(255) DEFAULT NULL COMMENT '是否可见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of member_permission
-- ----------------------------
INSERT INTO `member_permission` VALUES ('1', '首页', '首页', '#', '0', '0', '#', '0', 'fa fa-home', '1', '0');
INSERT INTO `member_permission` VALUES ('14', '权限展示', '权限展示', '/v1/member/permission/view', '0', '411522822607867904', 'system:permission:view', '1', 'fa fa-key', '3', '0');
INSERT INTO `member_permission` VALUES ('15', '权限集合', '权限集合', '/v1/member/permission/list', '0', '14', 'system:permission:list', '2', '', null, '0');
INSERT INTO `member_permission` VALUES ('24', '会员管理', '会员管理', '#', '0', '1', '#', '0', 'fa fa-gear', '3', '0');
INSERT INTO `member_permission` VALUES ('25', '会员列表', '会员列表', '/v1/member/view', '0', '24', '#', '1', 'fa fa-id-badge', '1', '0');
INSERT INTO `member_permission` VALUES ('26', '订单管理', '订单管理', '#', '0', '1', '#', '0', 'fa fa-gear', '3', '0');
INSERT INTO `member_permission` VALUES ('27', '订单列表', '订单列表', '/v1/memberRecord/view?type=ORDER', '0', '26', '#', '1', 'fa fa-gear', '1', '0');
INSERT INTO `member_permission` VALUES ('28', '充值列表', '充值列表', '/v1/memberRecord/view?type=STORE', '0', '26', '#', '1', 'fa fa-gear', '1', '0');
INSERT INTO `member_permission` VALUES ('4', '用户管理', '用户展示', '/v1/member/user/view', '0', '411522822607867904', 'system:user:view', '1', 'icon icon-user', '1', '0');
INSERT INTO `member_permission` VALUES ('411522822607867904', '用户管理', '用户管理', '#', '0', '496782496638173184', '#', '1', 'fa fa-id-badge', '3', '0');
INSERT INTO `member_permission` VALUES ('496782496638173184', '系统设置', '后台设置', '', '0', '1', '#', '0', 'fa fa-gear', '3', '0');
INSERT INTO `member_permission` VALUES ('9', '角色管理', '角色展示', '/RoleController/view', '0', '411522822607867904', 'system:role:view', '1', 'fa fa-group', '2', '0');
-- ----------------------------
-- Table structure for `member_permission_role`
-- ----------------------------
DROP TABLE IF EXISTS `member_permission_role`;
CREATE TABLE `member_permission_role` (
  `id` varchar(255) NOT NULL,
  `role_id` varchar(255) DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(255) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限中间表';

-- ----------------------------
-- Records of member_permission_role
-- ----------------------------
INSERT INTO `member_permission_role` VALUES ('10aa6f17-c1fd-4c5a-bb83-e507ef7c3e83', '488243256161730560', '411522822607867904');
INSERT INTO `member_permission_role` VALUES ('11', '488243256161730560', '14');
INSERT INTO `member_permission_role` VALUES ('12', '488243256161730560', '15');
INSERT INTO `member_permission_role` VALUES ('3e1f5813-1ca8-416b-898c-128741fbf4f9', '488243256161730560', '496782496638173184');
INSERT INTO `member_permission_role` VALUES ('5', '488243256161730560', '24');
INSERT INTO `member_permission_role` VALUES ('6', '488243256161730560', '25');
INSERT INTO `member_permission_role` VALUES ('7', '488243256161730560', '26');
INSERT INTO `member_permission_role` VALUES ('8', '488243256161730560', '27');
INSERT INTO `member_permission_role` VALUES ('8923b8e8-501f-4ad1-93da-aed83dfac5cd', '488243256161730560', '1');
INSERT INTO `member_permission_role` VALUES ('9', '488243256161730560', '28');
INSERT INTO `member_permission_role` VALUES ('94247c65-56a9-40ff-9373-444332b1e9e2', '488243256161730560', '9');
INSERT INTO `member_permission_role` VALUES ('bda27d37-31fb-4a51-8e36-0e33b6c487ec', '488243256161730560', '4');


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
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `member_record`
-- ----------------------------
BEGIN;
INSERT INTO `member_record` VALUES ('1', '10', '王海楠wind', '243.23', 'USE', null, '2020-12-20 15:52:57', 'ORDER'), ('2', '10', '王海楠wind', '1243.23', 'USE', null, '2020-12-20 15:53:04', 'ORDER'), ('3', '2', '王海楠', '100.00', 'USE', '200', '2020-12-20 08:48:24', 'STORE');
COMMIT;
-- ----------------------------
-- Table structure for `member_role`
-- ----------------------------
DROP TABLE IF EXISTS `member_role`;
CREATE TABLE `member_role` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of member_role
-- ----------------------------
INSERT INTO `member_role` VALUES ('488243256161730560', '超级管理员');
INSERT INTO `member_role` VALUES ('499362129900605440', '用户');

-- ----------------------------
-- Table structure for `member_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `member_role_user`;
CREATE TABLE `member_role_user` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(255) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色中间表';

-- ----------------------------
-- Records of member_role_user
-- ----------------------------
INSERT INTO `member_role_user` VALUES ('499363826978918400', '1', '488243256161730560');

-- ----------------------------
-- Table structure for `member_user`
-- ----------------------------
DROP TABLE IF EXISTS `member_user`;
CREATE TABLE `member_user` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户账号',
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户密码',
  `nickname` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
-- Records of member_user
-- ----------------------------
INSERT INTO `member_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '超管--wind');
