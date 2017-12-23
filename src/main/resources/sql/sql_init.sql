# id	部门id
# name	部门名
# insert_user	创建用户名
# insert_time	创建时间
# update_user	修改用户名
# update_time	修改时间
# is_deleted	删除标记
CREATE TABLE department (
  id          INT(10) PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(64) NOT NULL UNIQUE,
  insert_user INT(10)     NOT NULL REFERENCES user (id),
  insert_time DATETIME            DEFAULT now(),
  update_user INT(10)     NOT NULL REFERENCES user (id),
  update_time DATETIME            DEFAULT now(),
  is_deleted  INT(1)              DEFAULT 0
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# id	角色id
# name	角色名
# insert_user	创建用户名
# insert_time	创建时间
# update_user	修改用户名
# update_time	修改时间
# is_deleted	删除标记
CREATE TABLE role (
  id          INT(10) PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(64) UNIQUE NOT NULL,
  insert_user INT(10)            NOT NULL REFERENCES user (id),
  insert_time DATETIME            DEFAULT now(),
  update_user INT(10)            NOT NULL REFERENCES user (id),
  update_time DATETIME            DEFAULT now(),
  is_deleted  INT(1)              DEFAULT 0
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# id	用户id
# username	用户名
# name	姓名
# password	密码
# department_id	部门编号
# role_id	角色
# last_login	最后登录时间
# insert_user	创建用户名
# insert_time	创建时间
# update_user	修改用户名
# update_time	修改时间
# is_deleted	删除标记
CREATE TABLE user (
 id            INT(10) PRIMARY KEY AUTO_INCREMENT,
 username      VARCHAR(64) UNIQUE                 NOT NULL,
 NAME          VARCHAR(64)                        NOT NULL,
 password      VARCHAR(64)                        NOT NULL,
 department_id INT(10)                            NOT NULL REFERENCES department (id),
 role_id       INT(10)                            NOT NULL REFERENCES role (id),
 last_login    DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
 insert_user   INT(10)                            NOT NULL REFERENCES user (id),
 insert_time   DATETIME            DEFAULT now(),
 update_user   INT(10)                            NOT NULL REFERENCES user (id),
 update_time   DATETIME            DEFAULT now(),
 is_deleted    INT(1)              DEFAULT 0
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# id	假条id
# message	假条信息
# user_id	请假者id
# check_id	审核者id
# status	假条状态
# feedback	反馈
# start_time	请假开始时间
# end_time	请假结束时间
# insert_user	创建用户名
# insert_time	创建时间
# update_user	修改用户名
# update_time	修改时间
# is_deleted	删除标记
CREATE TABLE leave_letter
(
  id          INT(10) PRIMARY KEY   AUTO_INCREMENT,
  message     VARCHAR(540) NOT NULL,
  user_id     INT(10)      NOT NULL REFERENCES user (id),
  check_id    INT(10)      NOT NULL REFERENCES user (id),
  STATUS      INT(1)       NOT NULL DEFAULT 0,
  feedback    VARCHAR(540) NOT NULL,
  start_time  DATETIME     NOT NULL,
  end_time    DATETIME     NOT NULL,
  insert_user INT(10)      NOT NULL REFERENCES user (id),
  insert_time DATETIME              DEFAULT now(),
  update_user INT(10)      NOT NULL REFERENCES user (id),
  update_time DATETIME              DEFAULT now(),
  is_deleted  INT(1)                DEFAULT 0
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# id	通知id
# message	通知信息
# insert_user	创建用户名
# insert_time	创建时间
# update_user	修改用户名
# update_time	修改时间
# is_deleted	删除标记
CREATE TABLE notify (
  id          INT(10) PRIMARY KEY AUTO_INCREMENT,
  message     VARCHAR(540) NOT NULL,
  insert_user INT(10)      NOT NULL REFERENCES user (id),
  insert_time DATETIME            DEFAULT now(),
  update_user INT(10)      NOT NULL REFERENCES user (id),
  update_time DATETIME            DEFAULT now(),
  is_deleted  INT(1)              DEFAULT 0
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# id	通知详情id
# notify_id	通知id
# department_id	通知部门id
# insert_user	创建用户名
# insert_time	创建时间
# update_user	修改用户名
# update_time	修改时间
# is_deleted	删除标记
CREATE TABLE notify_info (
  id            INT(10) PRIMARY KEY AUTO_INCREMENT,
  notify_id     INT(10) NOT NULL REFERENCES notify (id),
  department_id INT(10) NOT NULL REFERENCES department (id),
  insert_user   INT(10) NOT NULL REFERENCES user (id),
  insert_time   DATETIME            DEFAULT now(),
  update_user   INT(10) NOT NULL REFERENCES user (id),
  update_time   DATETIME            DEFAULT now(),
  is_deleted    INT(1)              DEFAULT 0
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
