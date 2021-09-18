/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 80018
Source Host           : localhost:3307
Source Database       : team

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-05-10 18:26:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `fan_group`
-- ----------------------------
DROP TABLE IF EXISTS `fan_group`;
CREATE TABLE `fan_group` (
  `group_id` int(11) NOT NULL,
  `group_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `group_team_id` int(11) DEFAULT NULL,
  `group_member` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of fan_group
-- ----------------------------
INSERT INTO `fan_group` VALUES ('100', '战队一', '100', '100000,100001');

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `record_videoid` int(11) DEFAULT NULL,
  `record_win` int(11) DEFAULT NULL,
  `record_fail` int(11) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('100', '100', '100', '101');
INSERT INTO `record` VALUES ('101', '101', '100', '101');

-- ----------------------------
-- Table structure for `review_match`
-- ----------------------------
DROP TABLE IF EXISTS `review_match`;
CREATE TABLE `review_match` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `review_owner` bigint(20) DEFAULT NULL,
  `review_info` varchar(255) DEFAULT NULL,
  `review_parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`review_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of review_match
-- ----------------------------
INSERT INTO `review_match` VALUES ('1000', '100000', '打得真好', '100');
INSERT INTO `review_match` VALUES ('1001', '0', 'demoData', '0');

-- ----------------------------
-- Table structure for `review_member`
-- ----------------------------
DROP TABLE IF EXISTS `review_member`;
CREATE TABLE `review_member` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `review_owner` bigint(20) DEFAULT NULL,
  `review_info` varchar(255) DEFAULT NULL,
  `review_parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`review_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of review_member
-- ----------------------------
INSERT INTO `review_member` VALUES ('1000', '100000', '打得真好', '100');

-- ----------------------------
-- Table structure for `review_team`
-- ----------------------------
DROP TABLE IF EXISTS `review_team`;
CREATE TABLE `review_team` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `review_owner` bigint(20) DEFAULT NULL,
  `review_info` varchar(255) DEFAULT NULL,
  `review_parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`review_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of review_team
-- ----------------------------
INSERT INTO `review_team` VALUES ('1000', '100000', '打得真好', '100');
INSERT INTO `review_team` VALUES ('1001', '0', 'demoData', '0');

-- ----------------------------
-- Table structure for `team`
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(255) DEFAULT NULL,
  `team_icon` varchar(255) DEFAULT NULL,
  `team_support` bigint(20) DEFAULT NULL,
  `team_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('100', '李四队', '111', '100', '一支由李四组成的国家队');
INSERT INTO `team` VALUES ('101', 'demoData', 'demoData', '1', 'demoData');
INSERT INTO `team` VALUES ('1000', 'demoData', 'demoData', '0', 'demoData');
INSERT INTO `team` VALUES ('1001', 'demoData', 'demoData', '0', 'demoData');
INSERT INTO `team` VALUES ('1002', 'demoData', 'demoData', '0', 'demoData');
INSERT INTO `team` VALUES ('1003', '李四', '飒飒', '10', '带你的事');

-- ----------------------------
-- Table structure for `team_record_info`
-- ----------------------------
DROP TABLE IF EXISTS `team_record_info`;
CREATE TABLE `team_record_info` (
  `team_record_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_record_info_member_one` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `team_record_info_member_two` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `team_record_info_hexo_one` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `team_record_info_hexo_two` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `team_record_info_parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`team_record_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of team_record_info
-- ----------------------------
INSERT INTO `team_record_info` VALUES ('100', '张三', '李四', '王五', '吓死人', '100');
INSERT INTO `team_record_info` VALUES ('101', '李四蛋', '阿杰', '冲啊', '盖伦', '100');
INSERT INTO `team_record_info` VALUES ('102', '不要吓人', '杰克', '奶妈', '哄人', '100');
INSERT INTO `team_record_info` VALUES ('103', '丫丫', '二狗子', '上班', '收定金', '100');
INSERT INTO `team_record_info` VALUES ('104', '大祭司', '开麦', '上号', '第三课时', '100');
INSERT INTO `team_record_info` VALUES ('105', 'de', 'de', 'de', 'de', '101');
INSERT INTO `team_record_info` VALUES ('106', '得了', '定快的', '口', ' 扣扣', '101');
INSERT INTO `team_record_info` VALUES ('107', '囧', '1on', '接口； ', '孔盼曼', '101');
INSERT INTO `team_record_info` VALUES ('108', '积极', '孔盼曼', '朴，了', '看评论， ', '101');
INSERT INTO `team_record_info` VALUES ('109', '恐怕', '看破', '盘，哦', '靠谱， ', '101');
INSERT INTO `team_record_info` VALUES ('110', '及', 'jojo', '靠谱', '看破', '102');
INSERT INTO `team_record_info` VALUES ('111', '牛', '寂寞', '恐怕', '抠门', '102');
INSERT INTO `team_record_info` VALUES ('112', 'join', '龙婆坤', '恐怕', 'join开麦', '102');
INSERT INTO `team_record_info` VALUES ('113', '口', '恐怕', '录屏', '及', '102');
INSERT INTO `team_record_info` VALUES ('114', '恐怕', 'i就OK', '可怕可怕', '可偏偏', '102');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_power` int(11) DEFAULT NULL,
  `user_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('100000', '阿杰', '111111', '0', '0');
INSERT INTO `user` VALUES ('100001', '张三', '111111', '1', '0');
INSERT INTO `user` VALUES ('100002', '李四', '111111', '1', '0');
INSERT INTO `user` VALUES ('100003', '王五', '111111', '0', '1');

-- ----------------------------
-- Table structure for `u_member`
-- ----------------------------
DROP TABLE IF EXISTS `u_member`;
CREATE TABLE `u_member` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(255) DEFAULT NULL,
  `member_info` varchar(255) DEFAULT NULL,
  `member_support` bigint(20) DEFAULT NULL,
  `member_team` int(11) DEFAULT NULL,
  `member_icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of u_member
-- ----------------------------
INSERT INTO `u_member` VALUES ('10000', '张三', '顶级队员', '13', '100', 'qq');
INSERT INTO `u_member` VALUES ('10001', '里斯', '明代曾多次法国红酒', '12', '100', 'qwerghj');

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `video_id` int(11) NOT NULL AUTO_INCREMENT,
  `video_name` varchar(255) DEFAULT NULL,
  `video_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('100', '715.mp4', 'https://picuploader8997.oss-cn-beijing.aliyuncs.com/img/715.mp4');
INSERT INTO `video` VALUES ('101', 'cc.mp4', 'https://picuploader8997.oss-cn-beijing.aliyuncs.com/mp4/cc.mp4');
