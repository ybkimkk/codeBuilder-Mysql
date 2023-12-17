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
public class EntityBuildHandler extends BuildHandler {

    @Override
    public void operate() throws IOException {
        super.operate("/entity/" + tool.firstStrUpper(tableName) + "Entity.java", "entity.java.vm" );
    }
}
