package com.muatik;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by mustafaatik on 18/01/17.
 */
@Component
public class ConfigValueBinder {
    @Value("${my.url}")
    private String url;

    @Value("${my.name}")
    private String name;

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}
