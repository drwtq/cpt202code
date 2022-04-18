/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50541
 Source Host           : localhost:3306
 Source Schema         : messageboard

 Target Server Type    : MySQL
 Target Server Version : 50541
 File Encoding         : 65001

 Date: 20/06/2021 20:14:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for detail
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NULL DEFAULT NULL,
  `cuser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ctime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of detail
-- ----------------------------
INSERT INTO `detail` VALUES (1, 1, 'song', '2020-12-30 00:00:00');
INSERT INTO `detail` VALUES (2, 2, 'wu',  '2020-12-30 00:00:00');
INSERT INTO `detail` VALUES (3, 1, 'wu', '2020-12-30 00:00:00');
INSERT INTO `detail` VALUES (4, 1, 'wait', '056', '2020-12-31 00:00:00');
INSERT INTO `detail` VALUES (5, 5, 'song', '123\r\n', '2021-04-16 00:00:00');
INSERT INTO `detail` VALUES (6, 5, 'wu', '456', '2021-04-16 00:00:00');
INSERT INTO `detail` VALUES (7, 4, 'wu', '123', '2021-04-16 00:00:00');
INSERT INTO `detail` VALUES (8, 4, 'adc', '666', '2021-04-16 00:00:00');
INSERT INTO `detail` VALUES (9, 1, 'mn623540', '666', '2021-04-16 00:00:00');
INSERT INTO `detail` VALUES (10, 5, 'adc', '666', '2021-04-16 00:00:00');
INSERT INTO `detail` VALUES (11, 1, '15779673909', '888\r\n', '2021-04-17 00:00:00');
INSERT INTO `detail` VALUES (12, 1, '15779673909', '888\r\n', '2021-04-17 00:00:00');
INSERT INTO `detail` VALUES (13, 2, '', 'gg', '2021-04-22 00:00:00');
INSERT INTO `detail` VALUES (14, 1, '15779673909', 'yyy ', '2021-04-24 00:00:00');



-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'song', '123');
INSERT INTO `user` VALUES (2, 'wu', '456');
INSERT INTO `user` VALUES (3, 'li', '789');
INSERT INTO `user` VALUES (4, 'zhou', '123');
INSERT INTO `user` VALUES (5, 'lai', '123');
INSERT INTO `user` VALUES (6, 'quee', '123');
INSERT INTO `user` VALUES (7, 'wait', '123');
INSERT INTO `user` VALUES (8, 'adc', '123');
INSERT INTO `user` VALUES (9, '', '');
INSERT INTO `user` VALUES (10, 'mn623540', '123');
INSERT INTO `user` VALUES (11, '15779673909', '123');
INSERT INTO `user` VALUES (12, '333', '123');
INSERT INTO `user` VALUES (13, '&#32769;&#38081;666', '666');
INSERT INTO `user` VALUES (14, '&#32769;&#38081;6666', '123');
INSERT INTO `user` VALUES (15, '6666', '666');

SET FOREIGN_KEY_CHECKS = 1;
