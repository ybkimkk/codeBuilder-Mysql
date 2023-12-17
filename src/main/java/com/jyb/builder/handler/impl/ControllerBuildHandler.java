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
public class ControllerBuildHandler extends BuildHandler {

    @Override
    public void operate() throws IOException {
        super.operate("/controller/" + tool.firstStrUpper(tableName) + "Controller.java", "controller.java.vm" );
    }
}
