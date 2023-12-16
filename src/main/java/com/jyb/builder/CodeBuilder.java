package com.jyb.builder;

import com.jyb.builder.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;

/**
 * @author jinyongbin
 * @version 1.0
 * @since 2023/12/15
 */
@Component
@RequiredArgsConstructor
public class CodeBuilder {

    private final ApplicationContext applicationContext;

    @PostConstruct
    public void init() throws IOException {
        Map<String, BuildHandler> beansOfType = applicationContext.getBeansOfType(BuildHandler.class);
        for (BuildHandler subclass : beansOfType.values()) {
            subclass.operate();
        }
    }
}
