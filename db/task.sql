/*
Navicat MySQL Data Transfer

Source Server         : 152.101.131.171
Source Server Version : 80013
Source Host           : 152.101.131.171:3306
Source Database       : task

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-01-24 18:51:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `TASK_BLOB_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `TASK_BLOB_TRIGGERS`;
CREATE TABLE `TASK_BLOB_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `TASK_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `TASK_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TASK_BLOB_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for `TASK_CALENDARS`
-- ----------------------------
DROP TABLE IF EXISTS `TASK_CALENDARS`;
CREATE TABLE `TASK_CALENDARS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TASK_CALENDARS
-- ----------------------------

-- ----------------------------
-- Table structure for `TASK_CRON_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `TASK_CRON_TRIGGERS`;
CREATE TABLE `TASK_CRON_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `TASK_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `TASK_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TASK_CRON_TRIGGERS
-- ----------------------------
INSERT INTO `TASK_CRON_TRIGGERS` VALUES ('schedulerFactoryBean', 'ALL-Bet', 'less', '0 */5 * * * ?', 'PRC');
INSERT INTO `TASK_CRON_TRIGGERS` VALUES ('schedulerFactoryBean', 'BBIN', 'more', '0 */4 * * * ?', 'PRC');
INSERT INTO `TASK_CRON_TRIGGERS` VALUES ('schedulerFactoryBean', 'BBIN-Fishing', 'less', '0 */3 * * * ?', 'PRC');
INSERT INTO `TASK_CRON_TRIGGERS` VALUES ('schedulerFactoryBean', 'CQ9', 'more', '0 */5 * * * ?', 'PRC');
INSERT INTO `TASK_CRON_TRIGGERS` VALUES ('schedulerFactoryBean', 'FG', 'less', '0 */3 * * * ?', 'PRC');
INSERT INTO `TASK_CRON_TRIGGERS` VALUES ('schedulerFactoryBean', 'KAGA', 'less', '0 */3 * * * ?', 'PRC');
INSERT INTO `TASK_CRON_TRIGGERS` VALUES ('schedulerFactoryBean', 'LY-LOT', 'less', '0 */3 * * * ?', 'PRC');
INSERT INTO `TASK_CRON_TRIGGERS` VALUES ('schedulerFactoryBean', 'MW', 'less', '0 */3 * * * ?', 'PRC');
INSERT INTO `TASK_CRON_TRIGGERS` VALUES ('schedulerFactoryBean', 'SUNBER-BET', 'more', '0 */5 * * * ?', 'PRC');
INSERT INTO `TASK_CRON_TRIGGERS` VALUES ('schedulerFactoryBean', 'VG', 'less', '0 */3 * * * ?', 'PRC');

-- ----------------------------
-- Table structure for `TASK_FIRED_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `TASK_FIRED_TRIGGERS`;
CREATE TABLE `TASK_FIRED_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TASK_FIRED_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for `TASK_JOB_DETAILS`
-- ----------------------------
DROP TABLE IF EXISTS `TASK_JOB_DETAILS`;
CREATE TABLE `TASK_JOB_DETAILS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TASK_JOB_DETAILS
-- ----------------------------
INSERT INTO `TASK_JOB_DETAILS` VALUES ('schedulerFactoryBean', 'ALL-Bet', 'less', '欧博数据抓取限制8次/10分钟,抓票服务每5分钟抓取一次', 'com.ly.bussiness.task.AllBetScheduleTask', '1', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000774000E63726F6E45787072657373696F6E74000D30202A2F35202A202A202A203F74000E4A6F624465736372697074696F6E740048E6ACA7E58D9AE695B0E68DAEE68A93E58F96E99990E588B638E6ACA12F3130E58886E9929F2CE68A93E7A5A8E69C8DE58AA1E6AF8F35E58886E9929FE68A93E58F96E4B880E6ACA1740009636C61737350617468740028636F6D2E6C792E62757373696E6573732E7461736B2E416C6C4265745363686564756C655461736B7400046E616D65740007414C4C2D42657474000A737461727444656C6179737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000001474000567726F75707400046C6573737400067374617475737371007E0010000000017800);
INSERT INTO `TASK_JOB_DETAILS` VALUES ('schedulerFactoryBean', 'BBIN', 'more', '波音其他游戏服务每5分钟抓取一次', 'com.ly.bussiness.task.BBINScheduleTask', '1', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000774000E63726F6E45787072657373696F6E74000D30202A2F34202A202A202A203F74000E4A6F624465736372697074696F6E74002EE6B3A2E99FB3E585B6E4BB96E6B8B8E6888FE69C8DE58AA1E6AF8F35E58886E9929FE68A93E58F96E4B880E6ACA1740009636C61737350617468740026636F6D2E6C792E62757373696E6573732E7461736B2E4242494E5363686564756C655461736B7400046E616D657400044242494E74000A737461727444656C6179737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000001474000567726F75707400046D6F72657400067374617475737371007E0010000000017800);
INSERT INTO `TASK_JOB_DETAILS` VALUES ('schedulerFactoryBean', 'BBIN-Fishing', 'less', '波音捕鱼服务每3分钟抓取一次', 'com.ly.bussiness.task.BbinFishingScheduleTask', '1', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000774000E63726F6E45787072657373696F6E74000D30202A2F33202A202A202A203F74000E4A6F624465736372697074696F6E740028E6B3A2E99FB3E68D95E9B1BCE69C8DE58AA1E6AF8F33E58886E9929FE68A93E58F96E4B880E6ACA1740009636C6173735061746874002D636F6D2E6C792E62757373696E6573732E7461736B2E4262696E46697368696E675363686564756C655461736B7400046E616D6574000C4242494E2D46697368696E6774000A737461727444656C6179737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000001474000567726F75707400046C6573737400067374617475737371007E0010000000017800);
INSERT INTO `TASK_JOB_DETAILS` VALUES ('schedulerFactoryBean', 'CQ9', 'more', 'CQ9抓票服务每5分钟抓取一次', 'com.ly.bussiness.task.CQ9ScheduleTask', '1', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000774000E63726F6E45787072657373696F6E74000D30202A2F35202A202A202A203F74000E4A6F624465736372697074696F6E740025435139E68A93E7A5A8E69C8DE58AA1E6AF8F35E58886E9929FE68A93E58F96E4B880E6ACA1740009636C61737350617468740025636F6D2E6C792E62757373696E6573732E7461736B2E4351395363686564756C655461736B7400046E616D6574000343513974000A737461727444656C6179737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000001474000567726F75707400046D6F72657400067374617475737371007E0010000000017800);
INSERT INTO `TASK_JOB_DETAILS` VALUES ('schedulerFactoryBean', 'FG', 'less', 'FG抓票服务每3分钟抓取一次', 'com.ly.bussiness.task.FGScheduleTask', '1', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000774000E63726F6E45787072657373696F6E74000D30202A2F33202A202A202A203F74000E4A6F624465736372697074696F6E7400244647E68A93E7A5A8E69C8DE58AA1E6AF8F33E58886E9929FE68A93E58F96E4B880E6ACA1740009636C61737350617468740024636F6D2E6C792E62757373696E6573732E7461736B2E46475363686564756C655461736B7400046E616D65740002464774000A737461727444656C6179737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000001474000567726F75707400046C6573737400067374617475737371007E0010000000017800);
INSERT INTO `TASK_JOB_DETAILS` VALUES ('schedulerFactoryBean', 'KAGA', 'less', 'KAGA抓票服务每3分钟抓取一次', 'com.ly.bussiness.task.KAGAScheduleTask', '1', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000774000E63726F6E45787072657373696F6E74000D30202A2F33202A202A202A203F74000E4A6F624465736372697074696F6E7400264B414741E68A93E7A5A8E69C8DE58AA1E6AF8F33E58886E9929FE68A93E58F96E4B880E6ACA1740009636C61737350617468740026636F6D2E6C792E62757373696E6573732E7461736B2E4B4147415363686564756C655461736B7400046E616D657400044B41474174000A737461727444656C6179737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000001474000567726F75707400046C6573737400067374617475737371007E0010000000017800);
INSERT INTO `TASK_JOB_DETAILS` VALUES ('schedulerFactoryBean', 'LY-LOT', 'less', 'LY-LOT抓票服务每3分钟抓取一次', 'com.ly.bussiness.task.LyLotScheduleTask', '1', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000774000E63726F6E45787072657373696F6E74000D30202A2F33202A202A202A203F74000E4A6F624465736372697074696F6E7400284C592D4C4F54E68A93E7A5A8E69C8DE58AA1E6AF8F33E58886E9929FE68A93E58F96E4B880E6ACA1740009636C61737350617468740027636F6D2E6C792E62757373696E6573732E7461736B2E4C794C6F745363686564756C655461736B7400046E616D657400064C592D4C4F5474000A737461727444656C6179737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000001474000567726F75707400046C6573737400067374617475737371007E0010000000017800);
INSERT INTO `TASK_JOB_DETAILS` VALUES ('schedulerFactoryBean', 'MW', 'less', 'MW抓票服务每3分钟抓取一次', 'com.ly.bussiness.task.MWScheduleTask', '1', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000774000E63726F6E45787072657373696F6E74000D30202A2F33202A202A202A203F74000E4A6F624465736372697074696F6E7400244D57E68A93E7A5A8E69C8DE58AA1E6AF8F33E58886E9929FE68A93E58F96E4B880E6ACA1740009636C61737350617468740024636F6D2E6C792E62757373696E6573732E7461736B2E4D575363686564756C655461736B7400046E616D657400024D5774000A737461727444656C6179737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000001474000567726F75707400046C6573737400067374617475737371007E0010000000017800);
INSERT INTO `TASK_JOB_DETAILS` VALUES ('schedulerFactoryBean', 'SUNBER-BET', 'more', 'SUNBER-BET抓票服务每5分钟抓取一次', 'com.ly.bussiness.task.SunBerBetScheduleTask', '1', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000774000E63726F6E45787072657373696F6E74000D30202A2F35202A202A202A203F74000E4A6F624465736372697074696F6E74002C53554E4245522D424554E68A93E7A5A8E69C8DE58AA1E6AF8F35E58886E9929FE68A93E58F96E4B880E6ACA1740009636C6173735061746874002B636F6D2E6C792E62757373696E6573732E7461736B2E53756E4265724265745363686564756C655461736B7400046E616D6574000A53554E4245522D42455474000A737461727444656C6179737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000001474000567726F75707400046D6F72657400067374617475737371007E0010000000017800);
INSERT INTO `TASK_JOB_DETAILS` VALUES ('schedulerFactoryBean', 'VG', 'less', 'VG抓票服务每3分钟抓取一次', 'com.ly.bussiness.task.VGScheduleTask', '1', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000774000E63726F6E45787072657373696F6E74000D30202A2F33202A202A202A203F74000E4A6F624465736372697074696F6E7400245647E68A93E7A5A8E69C8DE58AA1E6AF8F33E58886E9929FE68A93E58F96E4B880E6ACA1740009636C61737350617468740024636F6D2E6C792E62757373696E6573732E7461736B2E56475363686564756C655461736B7400046E616D65740002564774000A737461727444656C6179737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000001474000567726F75707400046C6573737400067374617475737371007E0010000000017800);

-- ----------------------------
-- Table structure for `TASK_JOB_ENTITY`
-- ----------------------------
DROP TABLE IF EXISTS `TASK_JOB_ENTITY`;
CREATE TABLE `TASK_JOB_ENTITY` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `GROUP` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CRON` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `START_DELAY` int(3) DEFAULT NULL,
  `CLASS_PATH` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL COMMENT '1: open   0:close',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of TASK_JOB_ENTITY
-- ----------------------------
INSERT INTO `TASK_JOB_ENTITY` VALUES ('1', 'ALL-Bet', 'less', '0 */5 * * * ?', '20', 'com.ly.bussiness.task.AllBetScheduleTask', '欧博数据抓取限制8次/10分钟,抓票服务每5分钟抓取一次', '1');
INSERT INTO `TASK_JOB_ENTITY` VALUES ('2', 'BBIN-Fishing', 'less', '0 */3 * * * ?', '20', 'com.ly.bussiness.task.BbinFishingScheduleTask', '波音捕鱼服务每3分钟抓取一次', '1');
INSERT INTO `TASK_JOB_ENTITY` VALUES ('3', 'BBIN', 'more', '0 */4 * * * ?', '20', 'com.ly.bussiness.task.BBINScheduleTask', '波音其他游戏服务每5分钟抓取一次', '1');
INSERT INTO `TASK_JOB_ENTITY` VALUES ('4', 'CQ9', 'more', '0 */5 * * * ?', '20', 'com.ly.bussiness.task.CQ9ScheduleTask', 'CQ9抓票服务每5分钟抓取一次', '1');
INSERT INTO `TASK_JOB_ENTITY` VALUES ('5', 'KAGA', 'less', '0 */3 * * * ?', '20', 'com.ly.bussiness.task.KAGAScheduleTask', 'KAGA抓票服务每3分钟抓取一次', '1');
INSERT INTO `TASK_JOB_ENTITY` VALUES ('6', 'FG', 'less', '0 */3 * * * ?', '20', 'com.ly.bussiness.task.FGScheduleTask', 'FG抓票服务每3分钟抓取一次', '1');
INSERT INTO `TASK_JOB_ENTITY` VALUES ('7', 'LY-LOT', 'less', '0 */3 * * * ?', '20', 'com.ly.bussiness.task.LyLotScheduleTask', 'LY-LOT抓票服务每3分钟抓取一次', '1');
INSERT INTO `TASK_JOB_ENTITY` VALUES ('8', 'MW', 'less', '0 */3 * * * ?', '20', 'com.ly.bussiness.task.MWScheduleTask', 'MW抓票服务每3分钟抓取一次', '1');
INSERT INTO `TASK_JOB_ENTITY` VALUES ('9', 'SUNBER-BET', 'more', '0 */5 * * * ?', '20', 'com.ly.bussiness.task.SunBerBetScheduleTask', 'SUNBER-BET抓票服务每5分钟抓取一次', '1');
INSERT INTO `TASK_JOB_ENTITY` VALUES ('10', 'VG', 'less', '0 */3 * * * ?', '20', 'com.ly.bussiness.task.VGScheduleTask', 'VG抓票服务每3分钟抓取一次', '1');

-- ----------------------------
-- Table structure for `TASK_LOCKS`
-- ----------------------------
DROP TABLE IF EXISTS `TASK_LOCKS`;
CREATE TABLE `TASK_LOCKS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TASK_LOCKS
-- ----------------------------
INSERT INTO `TASK_LOCKS` VALUES ('schedulerFactoryBean', 'STATE_ACCESS');
INSERT INTO `TASK_LOCKS` VALUES ('schedulerFactoryBean', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for `TASK_PAUSED_TRIGGER_GRPS`
-- ----------------------------
DROP TABLE IF EXISTS `TASK_PAUSED_TRIGGER_GRPS`;
CREATE TABLE `TASK_PAUSED_TRIGGER_GRPS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TASK_PAUSED_TRIGGER_GRPS
-- ----------------------------

-- ----------------------------
-- Table structure for `TASK_SCHEDULER_STATE`
-- ----------------------------
DROP TABLE IF EXISTS `TASK_SCHEDULER_STATE`;
CREATE TABLE `TASK_SCHEDULER_STATE` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TASK_SCHEDULER_STATE
-- ----------------------------
INSERT INTO `TASK_SCHEDULER_STATE` VALUES ('schedulerFactoryBean', '152-101-131-172.static.hk.net1548315884372', '1548327109211', '7500');

-- ----------------------------
-- Table structure for `TASK_SIMPLE_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `TASK_SIMPLE_TRIGGERS`;
CREATE TABLE `TASK_SIMPLE_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `TASK_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `TASK_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TASK_SIMPLE_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for `TASK_SIMPROP_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `TASK_SIMPROP_TRIGGERS`;
CREATE TABLE `TASK_SIMPROP_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `TASK_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `TASK_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TASK_SIMPROP_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for `TASK_TRIGGERS`
-- ----------------------------
DROP TABLE IF EXISTS `TASK_TRIGGERS`;
CREATE TABLE `TASK_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `TASK_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `TASK_JOB_DETAILS` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of TASK_TRIGGERS
-- ----------------------------
INSERT INTO `TASK_TRIGGERS` VALUES ('schedulerFactoryBean', 'ALL-Bet', 'less', 'ALL-Bet', 'less', null, '1548327300000', '1548327000000', '5', 'WAITING', 'CRON', '1548318657000', '0', null, '0', '');
INSERT INTO `TASK_TRIGGERS` VALUES ('schedulerFactoryBean', 'BBIN', 'more', 'BBIN', 'more', null, '1548327120000', '1548326880000', '5', 'WAITING', 'CRON', '1548318657000', '0', null, '0', '');
INSERT INTO `TASK_TRIGGERS` VALUES ('schedulerFactoryBean', 'BBIN-Fishing', 'less', 'BBIN-Fishing', 'less', null, '1548327240000', '1548327060000', '5', 'WAITING', 'CRON', '1548318657000', '0', null, '0', '');
INSERT INTO `TASK_TRIGGERS` VALUES ('schedulerFactoryBean', 'CQ9', 'more', 'CQ9', 'more', null, '1548327300000', '1548327000000', '5', 'WAITING', 'CRON', '1548318657000', '0', null, '0', '');
INSERT INTO `TASK_TRIGGERS` VALUES ('schedulerFactoryBean', 'FG', 'less', 'FG', 'less', null, '1548327240000', '1548327060000', '5', 'WAITING', 'CRON', '1548318657000', '0', null, '0', '');
INSERT INTO `TASK_TRIGGERS` VALUES ('schedulerFactoryBean', 'KAGA', 'less', 'KAGA', 'less', null, '1548327240000', '1548327060000', '5', 'WAITING', 'CRON', '1548318657000', '0', null, '0', '');
INSERT INTO `TASK_TRIGGERS` VALUES ('schedulerFactoryBean', 'LY-LOT', 'less', 'LY-LOT', 'less', null, '1548327240000', '1548327060000', '5', 'WAITING', 'CRON', '1548318657000', '0', null, '0', '');
INSERT INTO `TASK_TRIGGERS` VALUES ('schedulerFactoryBean', 'MW', 'less', 'MW', 'less', null, '1548327240000', '1548327060000', '5', 'WAITING', 'CRON', '1548318657000', '0', null, '0', '');
INSERT INTO `TASK_TRIGGERS` VALUES ('schedulerFactoryBean', 'SUNBER-BET', 'more', 'SUNBER-BET', 'more', null, '1548327300000', '1548327000000', '5', 'WAITING', 'CRON', '1548318657000', '0', null, '0', '');
INSERT INTO `TASK_TRIGGERS` VALUES ('schedulerFactoryBean', 'VG', 'less', 'VG', 'less', null, '1548327240000', '1548327060000', '5', 'WAITING', 'CRON', '1548318657000', '0', null, '0', '');
