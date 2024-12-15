/*
 Navicat Premium Data Transfer

 Source Server         : estoredb
 Source Server Type    : MySQL
 Source Server Version : 80300
 Source Host           : localhost:3306
 Source Schema         : itmusic_db

 Target Server Type    : MySQL
 Target Server Version : 80300
 File Encoding         : 65001

 Date: 15/12/2024 21:26:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) DEFAULT NULL COMMENT '用户id',
  `type` tinyint(1) DEFAULT NULL COMMENT '收藏类型',
  `song_id` int(0) DEFAULT NULL COMMENT '歌曲id',
  `song_list_id` int(0) DEFAULT NULL COMMENT '歌单id',
  `create_time` timestamp(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `user_id` int(11) UNSIGNED ZEROFILL DEFAULT NULL COMMENT '用户id',
  `type` tinyint(1) DEFAULT NULL COMMENT '评论类型',
  `song_id` int(11) UNSIGNED ZEROFILL DEFAULT NULL COMMENT '歌曲id',
  `song_list_id` int(11) UNSIGNED ZEROFILL DEFAULT NULL COMMENT '歌单id',
  `create_time` datetime(0) DEFAULT NULL COMMENT '评论时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '评论内容',
  `up` int(0) DEFAULT 0 COMMENT '评论点赞数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for consumer
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `phone_num` char(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `email` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `birth` datetime(0) DEFAULT NULL COMMENT '生日',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '签名',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地区',
  `avator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `create_time` timestamp(0) DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) DEFAULT CURRENT_TIMESTAMP,
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '前端用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for list_song
-- ----------------------------
DROP TABLE IF EXISTS `list_song`;
CREATE TABLE `list_song`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `song_id` int(0) DEFAULT NULL COMMENT '歌曲id',
  `song_list_id` int(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '歌单包含歌曲列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rank
-- ----------------------------
DROP TABLE IF EXISTS `rank`;
CREATE TABLE `rank`  (
  `id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `song_list_id` int(11) UNSIGNED ZEROFILL DEFAULT NULL COMMENT '歌单id',
  `consumer_id` int(11) UNSIGNED ZEROFILL DEFAULT NULL COMMENT '用户id',
  `score` int(11) UNSIGNED ZEROFILL DEFAULT NULL COMMENT '评分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评价' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for singer
-- ----------------------------
DROP TABLE IF EXISTS `singer`;
CREATE TABLE `singer`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '歌手姓名',
  `sex` tinyint(1) DEFAULT NULL COMMENT '歌手性别',
  `pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '歌手头像',
  `birth` date DEFAULT NULL COMMENT '歌手生日',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '所属地区',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '歌手' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for song
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `singer_id` int(0) DEFAULT NULL COMMENT '歌手id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '歌名',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '简介',
  `create_time` timestamp(0) DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) DEFAULT CURRENT_TIMESTAMP,
  `pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '歌曲图片',
  `lyric` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '歌曲歌词',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '歌曲地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '歌曲' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for song_list
-- ----------------------------
DROP TABLE IF EXISTS `song_list`;
CREATE TABLE `song_list`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '歌单标题',
  `pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '歌单图片',
  `introduc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '歌单简介',
  `style` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '风格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '歌单' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
