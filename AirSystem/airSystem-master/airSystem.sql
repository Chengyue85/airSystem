create database airSystem;
use airSystem;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `planeId` int(11) DEFAULT NULL COMMENT '航班号',
  `time` datetime DEFAULT NULL COMMENT '下单时间',
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('3', '1', '6', '2022-11-05 21:53:07');
INSERT INTO `order` VALUES ('4', '1', '2', '2022-11-05 19:34:52');
INSERT INTO `order` VALUES ('5', '1', '4', '2022-11-05 22:53:12');

-- ----------------------------
-- Table structure for planes
-- ----------------------------
DROP TABLE IF EXISTS `planes`;
CREATE TABLE `planes` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '航班号',
  `planeName` varchar(50) DEFAULT NULL COMMENT '航班飞机名称',
  `number` int(11) DEFAULT '30' COMMENT '剩余票数',
  `time` time DEFAULT NULL,
  `money` int(11) DEFAULT '60',
  `first` varchar(50) DEFAULT NULL COMMENT '起始地',
  `destination` varchar(50) DEFAULT NULL COMMENT '目的地',
  PRIMARY KEY (`id`)
)AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
-- drop table planes;
-- ----------------------------
-- Records of planes
-- ----------------------------
INSERT INTO `planes` VALUES ('1', 'CA981', '40', '18:45', '2000', '纽约', '北京');
INSERT INTO `planes` VALUES ('2', 'MU2281', '39', '18:49', '300', '厦门', '天津');
INSERT INTO `planes` VALUES ('3', 'CJ2976', '0', '22:01', '290', '湖北', '浙江');
INSERT INTO `planes` VALUES ('4', 'MF8201', '49', '22:01', '400', '北京', '西宁');
INSERT INTO `planes` VALUES ('5', 'MU5458', '0', '22:01', '600', '深圳', '江西');
INSERT INTO `planes` VALUES ('6', 'CZ8889', '39', '19:38', '650', '广州', '深圳');
INSERT INTO `planes` VALUES ('7', 'MF8120', '30', '12:30', '400', '北京', '武汉');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `name` varchar(15) DEFAULT NULL COMMENT '姓名',
  `idNumber` varchar(100) DEFAULT NULL COMMENT '身份证',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号',
  `admin` int(11) DEFAULT '0' COMMENT '判定是否为管理员',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` int(50) DEFAULT '1000',
  `time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('陆行词', '00000000000000000', 'admin', '12345', '13049600299', '1', '1', '820', '2022-11-19 20:38:36');
INSERT INTO `user` VALUES ('江小白', '441624199804210078', 'xiaobai', '12345', '13049600299', '0', '2', '1000', '2022-11-20 12:50:24');

-- ----------------------------
-- Table structure for wait
-- ----------------------------
DROP TABLE IF EXISTS `wait`;
CREATE TABLE `wait` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '没票的时候用户进行预定则放入这里',
  `userid` int(11) DEFAULT NULL COMMENT '等待购票的用户id',
  `planeid` int(11) DEFAULT NULL COMMENT '等待的航班号',
  `time` datetime DEFAULT NULL COMMENT '开始等待的时间',
  `result` int(11) DEFAULT '0' COMMENT '标志位  如果为1则为已经下单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wait
-- ----------------------------
INSERT INTO `wait` VALUES ('1', '2', '3', '2022-11-04 22:45:48', '0');
INSERT INTO `wait` VALUES ('2', '1', '3', '2022-11-04 22:46:20', '0');
