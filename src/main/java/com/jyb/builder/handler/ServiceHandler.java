package com.jyb.builder.handler;

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
