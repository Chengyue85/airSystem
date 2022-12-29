package com.example.airsystem_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AirsystemCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirsystemCloudApplication.class, args);
    }

}
