package com.jyb.builder.handler.impl;

import com.jyb.builder.handler.BuildHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/16
 */
@Component
public class PageRequestEntityBuildHandler extends BuildHandler {

    @Override
    public void operate() throws IOException {
        super.operate("/entity/request/page/" + tool.firstStrUpper(tableName) + "PageRequestEntity.java", "pageRequestEntity.java.vm" );
    }
}
