package com.jyb.builder.handler;

import org.apache.velocity.Template;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/16
 */
@Component
public class ResponseEntityHandler extends BuildHandler {

    @Override
    public void operate() throws IOException {
        super.operate("/entity/response/" + tool.firstStrUpper(tableName) + "ResponseEntity.java", "responseEntity.java.vm" );
    }
}
