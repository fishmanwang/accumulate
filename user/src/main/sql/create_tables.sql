DROP TABLE IF EXISTS acc_user;
CREATE TABLE acc_user(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(128) NOT NULL DEFAULT '',
	age SMALLINT NOT NULL DEFAULT -1,
	`password` CHAR(32) NOT NULL DEFAULT '',
	create_time DATETIME NOT NULL,
	create_by CHAR(32) NOT NULL DEFAULT '',
	update_time DATETIME NOT NULL,
	update_by CHAR(32) NOT NULL DEFAULT ''
);

DROP TABLE IF EXISTS acc_password_policy_constraint;
CREATE TABLE acc_password_policy_constraint(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`min` TINYINT NOT NULL DEFAULT 6 COMMENT '最小长度',
	`max` TINYINT NOT NULL DEFAULT 100 COMMENT '最大长度',
	max_repeat_character TINYINT NOT NULL DEFAULT 3 COMMENT '最大重复字符数',
	min_non_alphanumeric TINYINT NOT NULL DEFAULT 0 COMMENT '最少拥有特殊字符数',
	min_digits TINYINT NOT NULL DEFAULT 0 COMMENT '最少拥有数字数',
	min_lowercase TINYINT NOT NULL DEFAULT 0 COMMENT '最少小写字母数',
	min_uppercase TINYINT NOT NULL DEFAULT 0 COMMENT '最少大写字母数',
	not_blank TINYINT(1) NOT NULL DEFAULT FALSE COMMENT '是否能使用空字符'
) COMMENT '密码策略限制';

DROP TABLE IF EXISTS acc_password_policy_expiration;
CREATE TABLE acc_password_policy_expiration(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`enable` TINYINT(1) NOT NULL DEFAULT FALSE COMMENT '是否启用',
	expired_day SMALLINT NOT NULL DEFAULT 30 COMMENT '过期天数',
	waring_before_day SMALLINT NOT NULL DEFAULT 10 COMMENT '过期前多少天提醒',
	waring_action TINYINT NOT NULL DEFAULT 1 COMMENT '提醒方式。1.邮件；2.短信',
	`subject` VARCHAR(128) NOT NULL DEFAULT '' COMMENT '邮件主题',
	email_expiring_message VARCHAR(255) NOT NULL DEFAULT '' COMMENT '将过期邮件信息',
	email_expired_message VARCHAR(255) NOT NULL DEFAULT '' COMMENT '已过期邮件信息',
	sms_expiring_message VARCHAR(255) NOT NULL DEFAULT '' COMMENT '将过期短信信息',
	sms_expired_message VARCHAR(255) NOT NULL DEFAULT '' COMMENT '已过期短信信息'
) COMMENT '密码策略过期设置';

DROP TABLE IF EXISTS acc_password_policy_retry;
CREATE TABLE acc_password_policy_retry(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`enable` TINYINT(1) NOT NULL DEFAULT FALSE COMMENT '是否启用',
	num TINYINT NOT NULL DEFAULT 5 COMMENT '重试次数',
	lock_time INT NOT NULL DEFAULT 2 COMMENT '锁定时间，单位：分钟'
) COMMENT '密码策略重试设置';

DROP TABLE IF EXISTS acc_password_policy_config;
CREATE TABLE acc_password_policy_config (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(64) UNIQUE NOT NULL DEFAULT '',
	description VARCHAR(128) NOT NULL DEFAULT '',
	`enable` TINYINT(1) NOT NULL DEFAULT FALSE COMMENT '是否启用',
	banned	TINYINT(1) NOT NULL DEFAULT FALSE COMMENT '是否存在黑名单',
	banned_url VARCHAR(512) NOT NULL DEFAULT '' COMMENT '黑名单，以后可考虑放入另一张表',
	`constraint_id` INT NOT NULL DEFAULT 0,
	expiration_id INT NOT NULL DEFAULT 0,
	retry_id INT NOT NULL DEFAULT 0,
	create_time DATETIME NOT NULL,
	create_by CHAR(32) NOT NULL DEFAULT '',
	update_time DATETIME NOT NULL,
	update_by CHAR(32) NOT NULL DEFAULT ''
) COMMENT '密码策略';