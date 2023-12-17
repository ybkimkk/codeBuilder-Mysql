package com.jyb.builder.handler.impl;

import com.jyb.builder.handler.BuildHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/17
 */
@Component
public class MapperXmlBuildHandler extends BuildHandler {
    @Override
    public void operate() throws IOException {
        super.operate("/mapper/" + tool.firstStrUpper(tableName) + "Mapper.xml", "mapperXml.xml.vm" );

    }
}
