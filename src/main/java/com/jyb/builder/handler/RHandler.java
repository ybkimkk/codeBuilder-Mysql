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
public class RHandler extends BuildHandler {

    @Override
    public void operate() throws IOException {
        String path = System.getProperty("user.dir" ) + "/entity/common/R.java";
        super.checkParentFile(path);
        Template template = velocityEngine.getTemplate("vms/R.java.vm" );
        FileWriter fw = new FileWriter(path);
        template.merge(toolContext, fw);
        fw.close();
    }
}
