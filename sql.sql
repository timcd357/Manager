CREATE TABLE `user` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `userName` varchar(45) NOT NULL COMMENT '用户名',
  `password` varchar(45) NOT NULL COMMENT '密码',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机号',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `status` int DEFAULT NULL COMMENT '用户状态，0为正常，1为封禁，2为删除',
  `idCard` int DEFAULT NULL COMMENT '身份证号',
  `role` int DEFAULT NULL COMMENT '用户权限，0为管普通用户，1为管理员，2为超级管理员',
  `name` varchar(45) DEFAULT NULL COMMENT '用户实名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `user_business` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `date` date NOT NULL COMMENT '日期',
  `itemname` varchar(200) DEFAULT NULL COMMENT '物品名称',
  `batch` varchar(200) DEFAULT NULL COMMENT '批号/流水号',
  `num` float NOT NULL COMMENT '数量',
  `price` float DEFAULT NULL COMMENT '单价',
  `factory` varchar(200) DEFAULT NULL COMMENT '厂家',
  `did` varchar(100) NOT NULL COMMENT '做了什么',
  `start` varchar(200) DEFAULT NULL COMMENT '位置（起点）',
  `end` varchar(200) DEFAULT NULL COMMENT '位置（终点）',
  `userid` varchar(50) NOT NULL COMMENT '用户主键',
  `flag` int(11) DEFAULT '0',
  `comment` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户业务表'

CREATE TABLE `query_location` (
  `id` int NOT NULL COMMENT '主键',
  `start` int NOT NULL DEFAULT '1' COMMENT '是否能作为起始点（0否1是）',
  `content` varchar(200) NOT NULL COMMENT '内容',
  `end` int NOT NULL DEFAULT '1' COMMENT '是否能作为终点（0否1是）',
  `flag` int DEFAULT NULL COMMENT '标志位',
  `comment` varchar(200) DEFAULT NULL COMMENT '备注',
  `userid` varchar(36) NOT NULL COMMENT '添加该记录的人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用于记录对应的位置信息'

