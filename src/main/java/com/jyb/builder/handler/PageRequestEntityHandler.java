package com.jyb.builder.handler;

import org.apache.velocity.Template;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/16
 */
@Component
public class PageRequestEntityHandler extends BuildHandler {


    @Override
    public void operate() throws IOException {
        String path = System.getProperty("user.dir" ) + "/entity/request/page/" + tool.firstStrUpper(tableName) + "PageRequestEntity.java";
        super.checkParentFile(path);
        Template template = velocityEngine.getTemplate("vms/pageRequestEntity.java.vm" );
        FileWriter fw = new FileWriter(path);
        template.merge(toolContext, fw);
        fw.close();
    }
}
