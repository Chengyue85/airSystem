package com.plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// 启用eureka的客户端
@EnableEurekaClient
//@EnableDiscoveryClient
public class AirsystemServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirsystemServiceApplication.class, args);
    }

}
