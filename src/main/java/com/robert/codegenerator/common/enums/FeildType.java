package com.robert.codegenerator.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author sunweixin
 * @date 2026/3/3
 * @description 字段数据类型枚举
 */
@Getter
@AllArgsConstructor
public enum FeildType {

    INT("int"),
    INTEGER("integer"),
    VARCHAR("varchar"),
    BIGINT("bigint"),
    DATE("date"),
    DATETIME("datetime"),
    TIME("time"),
    TIMESTAMP("timestamp"),
    DECIMAL("decimal"),
    BIT("bit"),
    TEXT("text"),
    BLOB("blob"),
    SMALLINT("smallint"),
    BOOLEAN("boolean"),
    CHAR("char"),
    DOUBLE("double"),
    TINYINT("tinyint"),
    FLOAT("float"),
    JSON("json"),
    TINYTEXT("tinytext"),
    ENUM("enum"),
    SET("set"),
    BINARY("binary"),
    GEOGRAPHY("geography"),
    GEOMETRY("geometry"),
    LONGBLOB("longblob"),
    LONGTEXT("longtext"),
    LINESTRING("linestring"),
    MEDIUMBLOB("mediumblob"),
    MEDIUMINT("mediumint"),
    MEDIUMTEXT("mediumtext"),
    MULTILINESTRING("multilinestring"),
    MULTIPOINT("multipoint"),
    MULTIPOLYGON("multipolygon"),
    NUMERIC("numeric"),
    POINT("point"),
    POLYGON("polygon"),
    TINYBLOB("tinyblob"),
    VARBINARY("varbinary"),
    YEAR("year"),
    ;
    private final String type;


}
