CREATE TABLE `user` (
  `user_id` varchar(30) NOT NULL COMMENT '用户id,为用户在此系统的唯一标识',
  `user_name` varchar(45) DEFAULT NULL COMMENT '用户名称（汉字）',
  `password` varchar(50) DEFAULT '123' COMMENT '用户密码   目前未加密',
  `role_ids` varchar(100) DEFAULT '001' COMMENT '权限id  可有多个',
  `status` tinyint(1) DEFAULT '0' COMMENT '是否可用 0 是 1 否',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `idx_user_username` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';



CREATE TABLE `notice` (
  `notice_id` varchar(30) NOT NULL,
  `notict_time` datetime DEFAULT NULL,
  `notice_title` varchar(45) DEFAULT NULL,
  `notice_content` text,
  `issue_user` varchar(30) DEFAULT NULL,
  `exec_user` varchar(30) DEFAULT NULL,
  `is_exec` varchar(3) DEFAULT NULL,
  `exec_time` datetime DEFAULT NULL,
  `exec_remark` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




