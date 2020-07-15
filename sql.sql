CREATE TABLE `user` (
  `id` varchar(36) NOT NULL COMMENT '����',
  `userName` varchar(45) NOT NULL COMMENT '�û���',
  `password` varchar(45) NOT NULL COMMENT '����',
  `phone` varchar(45) DEFAULT NULL COMMENT '�ֻ���',
  `email` varchar(45) DEFAULT NULL COMMENT '����',
  `status` int DEFAULT NULL COMMENT '�û�״̬��0Ϊ������1Ϊ�����2Ϊɾ��',
  `idCard` int DEFAULT NULL COMMENT '���֤��',
  `role` int DEFAULT NULL COMMENT '�û�Ȩ�ޣ�0Ϊ����ͨ�û���1Ϊ����Ա��2Ϊ��������Ա',
  `name` varchar(45) DEFAULT NULL COMMENT '�û�ʵ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `user_business` (
  `id` varchar(50) NOT NULL COMMENT '����',
  `date` date NOT NULL COMMENT '����',
  `itemname` varchar(200) DEFAULT NULL COMMENT '��Ʒ����',
  `batch` varchar(200) DEFAULT NULL COMMENT '����/��ˮ��',
  `num` float NOT NULL COMMENT '����',
  `price` float DEFAULT NULL COMMENT '����',
  `factory` varchar(200) DEFAULT NULL COMMENT '����',
  `did` varchar(100) NOT NULL COMMENT '����ʲô',
  `start` varchar(200) DEFAULT NULL COMMENT 'λ�ã���㣩',
  `end` varchar(200) DEFAULT NULL COMMENT 'λ�ã��յ㣩',
  `userid` varchar(50) NOT NULL COMMENT '�û�����',
  `flag` int(11) DEFAULT '0',
  `comment` varchar(200) DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='�û�ҵ���'