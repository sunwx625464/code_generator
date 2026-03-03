SET FOREIGN_KEY_CHECKS = 0;
SET NAMES utf8mb4;
-- code_generator DDL
CREATE DATABASE `code_generator`
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;;
use `code_generator`;
-- code_generator.base_field DDL
DROP TABLE IF EXISTS `code_generator`.`base_field`;
CREATE TABLE `code_generator`.`base_field` (`id` BIGINT NOT NULL AUTO_INCREMENT Comment "id",
`create_time` DATETIME NULL Comment "创建时间",
`update_time` DATETIME NULL Comment "修改时间",
`field_name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL Comment "字段名称",
`field_type` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL Comment "字段类型",
`field_remark` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL Comment "字段备注",
`deleted` TINYINT(1) NULL Comment "逻辑删除",
`base_flag` INT NULL Comment "基础标识",
`status` TINYINT(1) NULL Comment "是否启用",
UNIQUE INDEX `uk_base_field_field_name`(`field_name` ASC) USING BTREE comment "字段名称唯一索引",
PRIMARY KEY (`id`)) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;
-- code_generator.data_origin DDL
DROP TABLE IF EXISTS `code_generator`.`data_origin`;
CREATE TABLE `code_generator`.`data_origin` (`id` BIGINT NOT NULL AUTO_INCREMENT Comment "id",
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
UNIQUE INDEX `uk_data_origin_connect_name`(`connect_name` ASC) USING BTREE comment "连接名唯一索引",
PRIMARY KEY (`id`)) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci AUTO_INCREMENT = 2 ROW_FORMAT = Dynamic;
-- code_generator.base_field DML
INSERT INTO `code_generator`.`base_field` (`id`,`create_time`,`update_time`,`field_name`,`field_type`,`field_remark`,`deleted`,`base_flag`,`status`) VALUES (1,'2026-03-03 13:56:17',NULL,'id','bigint','id',0,-1,0),(2,'2026-03-03 13:57:09',NULL,'create_time','datetime','创建时间',0,-1,0),(3,'2026-03-03 13:58:11',NULL,'create_user','varchar','创建人',0,-1,0),(4,'2026-03-03 13:58:45',NULL,'update_time','datetime','修改时间',0,-1,0),(5,'2026-03-03 13:59:08',NULL,'update_user','varchar','修改人',0,-1,0),(6,'2026-03-03 13:59:58',NULL,'deleted','tinyint','逻辑删除',0,-1,0);
-- code_generator.data_origin DML
INSERT INTO `code_generator`.`data_origin` (`id`,`create_time`,`update_time`,`hostname`,`port`,`username`,`password`,`database_name`,`deleted`,`type`,`connect_name`) VALUES (1,'2026-03-03 10:48:22','2026-03-03 11:14:25','127.0.0.1',3306,'root','625464','code_generator',0,'MYSQL','');
SET FOREIGN_KEY_CHECKS = 1;
