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
public class ServiceImplBuildHandler extends BuildHandler {

    @Override
    public void operate() throws IOException {
        super.operate("/service/impl/" + tool.firstStrUpper(tableName) + "ServiceImpl.java", "serviceImpl.java.vm" );
    }
}
