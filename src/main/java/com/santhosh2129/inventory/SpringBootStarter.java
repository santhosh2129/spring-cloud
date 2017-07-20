package com.santhosh2129.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by santhosh on 7/1/17.
 */

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class SpringBootStarter {
    public static void main(String[] arg) {
        SpringApplication.run(SpringBootStarter.class, arg);
    }
}
