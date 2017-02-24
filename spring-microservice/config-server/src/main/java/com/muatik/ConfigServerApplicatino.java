package com.muatik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by mustafaatik on 24/02/2017.
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplicatino {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplicatino.class, args);
    }
}
