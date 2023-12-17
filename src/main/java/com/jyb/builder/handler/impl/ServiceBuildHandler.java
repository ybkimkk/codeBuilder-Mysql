package com.jyb.builder.handler.impl;

import com.jyb.builder.handler.BuildHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/15
 */
@Component
public class ServiceBuildHandler extends BuildHandler {

    @Override
    public void operate() throws IOException {
        super.operate("/service/" + tool.firstStrUpper(tableName) + "Service.java", "service.java.vm" );

    }
}
