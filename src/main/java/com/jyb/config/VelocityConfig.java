package com.jyb.config;

import com.jyb.domain.TableInfo;
import com.jyb.utils.Tool;
import lombok.RequiredArgsConstructor;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.ToolManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/15
 */
@Configuration
@RequiredArgsConstructor
public class VelocityConfig {

    private final Tool tool;

    @Value("${mysql.host}")
    private String host;

    @Value("${mysql.port}")
    private String port;

    @Value("${mysql.database}")
    private String database;

    @Value("${mysql.username}")
    private String username;

    @Value("${mysql.password}")
    private String password;

    @Value("${mysql.table}")
    private String tableName;

    @Value("${mysql.encoding}")
    private String encoding;

    @Value("${packageName}")
    private String packageName;

    @Bean
    public VelocityEngine velocityEngine() {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(Velocity.RESOURCE_LOADER, "class");
        velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine.init();
        return velocityEngine;
    }

    @Bean
    public ToolContext toolContext() throws SQLException {
        ToolManager toolManager = new ToolManager();
        toolManager.configure("tools.xml");
        ToolContext context = toolManager.createContext();
        List<TableInfo> tableInfo = getTableInfo();
        context.put("tableInfo", tableInfo);
        context.put("tableName", tableName);
        context.put("packageName", packageName);
        context.put("tool", tool);
        return context;
    }

    private List<TableInfo> getTableInfo() throws SQLException {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?characterEncoding=" + encoding;
        Connection conn = DriverManager.getConnection(url, username, password);
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet columns = metaData.getColumns(null, null, tableName, null);
        List<TableInfo> tableInfos = new ArrayList<>();
        while (columns.next()) {
            TableInfo tableInfo = new TableInfo();
            tableInfo.setColumnName(columns.getString("COLUMN_NAME"));
            tableInfo.setTypeName(columns.getString("TYPE_NAME"));
            tableInfo.setColumnSize(columns.getInt("COLUMN_SIZE"));
            tableInfos.add(tableInfo);
        }
        return tableInfos;
    }

}
