package com.jyb.utils;

import com.google.common.base.CaseFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/15
 */
@Component
public class Tool {

    @Value("${mysql.table}")
    private String tableName;

    public String firstStrUpper(String str) {
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, str);
    }

    public String getFile(String str) {
        return System.getProperty("user.dir") + "/" + str + "/" + firstStrUpper(tableName) + firstStrUpper(str) + ".java";

    }
}
