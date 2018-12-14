/*
Navicat MySQL Data Transfer

Source Server         : 192.168.100.85
Source Server Version : 50173
Source Host           : 192.168.100.85:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-12-12 17:26:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_login`;
CREATE TABLE `sys_login` (
  `id` bigint(20) NOT NULL,
  `create_by` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  `del_flag` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login_date` datetime DEFAULT NULL,
  `login_ip` varchar(255) DEFAULT NULL,
  `login_name` varchar(255) NOT NULL,
  `login_status` varchar(255) NOT NULL,
  `login_type` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `photo_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4l5vqa6lo9x4626uhk7a8eoh5` (`login_name`),
  UNIQUE KEY `UK_6owxhxes359ke5gd0iu6b3cxj` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_login
-- ----------------------------
INSERT INTO `sys_login` VALUES ('1', '0', '2018-12-08 21:23:09', '0', null, null, '2018-12-08 21:23:09', null, null, null, 'account1544275389083', '0', '0', '123456', null, null, '1');
INSERT INTO `sys_login` VALUES ('2', '0', '2018-12-10 10:53:19', '0', null, null, '2018-12-10 10:53:19', null, null, null, 'account1544410399076', '0', '0', '123456', null, null, '1');
INSERT INTO `sys_login` VALUES ('3', '0', '2018-12-10 10:53:48', '0', null, null, '2018-12-10 10:53:48', null, null, null, 'account1544410428575', '0', '0', '123456', null, null, '1');
INSERT INTO `sys_login` VALUES ('4', '0', '2018-12-10 10:56:16', '0', null, null, '2018-12-10 10:56:16', null, null, null, 'account1544410575764', '0', '0', '123456', null, null, '1');
