package com.jyb.builder.handler;

import com.jyb.utils.Tool;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.ToolContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/15
 */
@Component
public class ServiceHandler extends BuildHandler {


    @Override
    public void operate() throws IOException {
        super.operate("service");
    }
}
