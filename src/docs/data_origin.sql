SET FOREIGN_KEY_CHECKS = 0;
SET NAMES utf8mb4;
-- data_origin DDL
DROP TABLE IF EXISTS `data_origin`;
CREATE TABLE `data_origin` (`id` BIGINT NOT NULL AUTO_INCREMENT Comment "id",
`create_time` DATETIME NULL Comment "创建时间",
`update_time` DATETIME NULL Comment "修改时间",
`hostname` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL Comment "主机地址",
`port` INT NULL Comment "端口",
`username` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL Comment "用户名",
`password` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL Comment "密码",
`database_name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL Comment "数据库名",
`deleted` TINYINT(1) NULL Comment "逻辑删除",
`type` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL Comment "类型",
`connect_name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL Comment "连接名",
PRIMARY KEY (`id`)) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci AUTO_INCREMENT = 2 ROW_FORMAT = Dynamic;
-- data_origin DML
INSERT INTO `data_origin` (`id`,`create_time`,`update_time`,`hostname`,`port`,`username`,`password`,`database_name`,`deleted`,`type`,`connect_name`) VALUES (1,'2026-03-02 14:39:06',NULL,'127.0.0.1',3306,'root','625464',NULL,0,'MySQL',NULL);
SET FOREIGN_KEY_CHECKS = 1;
