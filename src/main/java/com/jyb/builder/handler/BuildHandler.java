package com.jyb.builder.handler;

import com.jyb.utils.Tool;
import lombok.RequiredArgsConstructor;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.ToolContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/15
 */

@Component
@RequiredArgsConstructor
public abstract class BuildHandler {

    @Resource
    private VelocityEngine velocityEngine;

    @Resource
    private ToolContext toolContext;

    @Resource
    protected Tool tool;

    @Value("${mysql.table}" )
    protected String tableName;

    protected void checkParentFile(String path) {
        File file = new File(path);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    protected void operate(String path, String vmFile) throws IOException {
        String buildPath = System.getProperty("user.dir" ) + "/builder" + path;
        checkParentFile(buildPath);
        Template template = velocityEngine.getTemplate("vms/" + vmFile);
        FileWriter fw = new FileWriter(buildPath);
        template.merge(toolContext, fw);
        fw.close();
    }

    public abstract void operate() throws IOException;

}
