package com.muatik;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * Created by mustafaatik on 18/01/17.
 */
@ConfigurationProperties(prefix="my")
public class ConfigBinder {

    @Value("${my.name}")
    private String name;

    private String url; // expected to be filled automatically

    public String getUrl() {
        return this.url;
    }

    public String getName() {
        return this.name;
    }
}
