package com.blue.mediuser.common.util;

import com.blue.mediuser.common.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PropertiesUtil {

    private ServerProperties serverProperties;

    public PropertiesUtil(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    private static Map<String, String> pathMap = new HashMap<>();

    @Bean
    private void putProperties() {
        pathMap.putAll(serverProperties.getPath());
    }

    public static String getPathProperty(String name) {
        return pathMap.get(name);
    }

}
