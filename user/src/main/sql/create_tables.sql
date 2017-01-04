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

DROP TABLE IF EXISTS acc_password_policy;
CREATE TABLE acc_password_policy (
	id INT PRIMARY KEY AUTO_INCREMENT,
	general TEXT NOT NULL COMMENT '常用配置',
	`constraint` TEXT NOT NULL COMMENT '限制',
	expiration TEXT NOT NULL COMMENT '过期配置',
	expireMessage TEXT NOT NULL COMMENT '过期提示信息',
	retry TEXT NOT NULL COMMENT '重试',
	create_time DATETIME NOT NULL,
	create_by CHAR(32) NOT NULL DEFAULT '',
	update_time DATETIME NOT NULL,
	update_by CHAR(32) NOT NULL DEFAULT ''
) COMMENT '密码策略';