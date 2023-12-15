package com.jyb.builder.handler;

import com.jyb.utils.Tool;
import lombok.RequiredArgsConstructor;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.ToolContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private ToolContext toolContext;

    @Autowired
    private Tool tool;

    void checkParentFile(String path) {
        File file = new File(path);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    public void operate(String file) throws IOException {
        String path = tool.getFile(file);
        checkParentFile(path);
        Template template = velocityEngine.getTemplate("vms/" + file + ".java.vm");
        FileWriter fw = new FileWriter(path);
        template.merge(toolContext, fw);
        fw.close();
    }

    public abstract void operate() throws IOException;

}
