package com.jyb.builder;

import com.jyb.builder.handler.BuildHandler;
import com.jyb.builder.handler.ControllerHandler;
import com.jyb.builder.handler.ServiceHandler;
import com.jyb.builder.handler.ServiceImplHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/15
 */
@Component
@RequiredArgsConstructor
public class CodeBuilder {

    private final ControllerHandler controllerHandler;

    private final ServiceImplHandler serviceImplHandler;

    private final ServiceHandler serviceHandler;

    @Value("${build}")
    private List<String> build;

    @PostConstruct
    public void init() throws IOException {
        HashMap<String, BuildHandler> map = new HashMap<>();
        map.put("controller", controllerHandler);
        map.put("serviceImpl", serviceImplHandler);
        map.put("service", serviceHandler);

        if (build.isEmpty()) {
            for (Map.Entry<String, BuildHandler> entry : map.entrySet()) {
                String key = entry.getKey();
                BuildHandler value = entry.getValue();
                value.operate();
            }
        } else {
            for (String s : build) {
                map.get(s).operate();
            }

        }
    }
}
