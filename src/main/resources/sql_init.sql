CREATE TABLE `department`(
  `id` int(10) PRIMARY KEY,
  `name` VARCHAR(64) UNIQUE NOT NULL ,
  `insert_user` int(10) NOT NULL REFERENCES user(id),
  `insert_time` DATETIME DEFAULT now(),
  `update_user`   int(10) NOT NULL REFERENCES user(id),
  `update_time` DATETIME DEFAULT now(),
  `is_deleted` INT(1) DEFAULT 0
);

CREATE TABLE `role`(
  `id` int(10) PRIMARY KEY,
  `name` VARCHAR(64) UNIQUE NOT NULL ,
  `insert_user` int(10) NOT NULL REFERENCES user(id),
  `insert_time` DATETIME DEFAULT now(),
  `update_user`   int(10) NOT NULL REFERENCES user(id),
  `update_time` DATETIME DEFAULT now(),
  `is_deleted` INT(1) DEFAULT 0
);

CREATE TABLE `user`(
`id` int(10) PRIMARY KEY,
`username` VARCHAR(64) UNIQUE NOT NULL ,
`NAME` VARCHAR(64) NOT NULL ,
`PASSWORD` VARCHAR(64) NOT NULL ,
`department_id` INT(10) NOT NULL REFERENCES department(id),
`role_id`  INT(10) NOT NULL REFERENCES role(id),
`last_login` int(10) NOT NULL REFERENCES user(id),
`insert_user` int(10) NOT NULL REFERENCES user(id),
`insert_time` DATETIME DEFAULT now(),
`update_user`   int(10) NOT NULL REFERENCES user(id),
`update_time` DATETIME DEFAULT now(),
`is_deleted` INT(1) DEFAULT 0

);