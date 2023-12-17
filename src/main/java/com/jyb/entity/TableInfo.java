package com.jyb.entity;

import lombok.Data;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/15
 */
@Data
public class TableInfo {
    private String columnName;
    private String typeName;
    private Integer columnSize;
    private String javaType;
    private Boolean primaryKey = false;
}
