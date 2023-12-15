package com.jyb.builder.handler;

import com.jyb.utils.Tool;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.ToolContext;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private ToolContext toolContext;

    @Autowired
    private Tool tool;

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
