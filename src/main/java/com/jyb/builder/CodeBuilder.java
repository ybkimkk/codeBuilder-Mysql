package com.jyb.builder;

import com.jyb.builder.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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

    private final MapperHandler mapperHandler;

    private final EntityHandler entityHandler;

    private final ResponseEntityHandler responseEntityHandler;

    private final RequestEntityHandler requestEntityHandler;

    private final PageRequestEntityHandler pageRequestEntityHandler;

    private final ConvertHandler convertHandler;

    private final RHandler rHandler;

    @Value("${build}")
    private List<String> build;

    @PostConstruct
    public void init() {
        HashMap<String, BuildHandler> map = new HashMap<>();
        map.put("controller", controllerHandler);
        map.put("serviceImpl", serviceImplHandler);
        map.put("service", serviceHandler);
        map.put("mapper", mapperHandler);
        map.put("entity", entityHandler);
        map.put("requestEntity", requestEntityHandler);
        map.put("pageRequestEntity", pageRequestEntityHandler);
        map.put("responseEntity", responseEntityHandler);
        map.put("convert", convertHandler);
        map.put("r", rHandler);


        if (build.isEmpty()) {
            map.forEach((key, value) -> {
                try {
                    value.operate();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } else {
            build.forEach(x -> {
                try {
                    map.get(x).operate();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        }
    }
}
