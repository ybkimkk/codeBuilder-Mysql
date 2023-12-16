package com.jyb.builder.handler;

import org.apache.velocity.Template;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/15
 */
@Component
public class ServiceImplHandler extends BuildHandler {

    @Value("${mysql.table}")
    private String tableName;

    @Override
    public void operate() throws IOException {
        String path = System.getProperty("user.dir") + "/service/impl/" + tool.firstStrUpper(tableName) + "ServiceImpl.java";
        super.checkParentFile(path);
        Template template = velocityEngine.getTemplate("vms/serviceImpl.java.vm");
        FileWriter fw = new FileWriter(path);
        template.merge(toolContext, fw);
        fw.close();
    }
}
