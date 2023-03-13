package com.msb.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class TrafficSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrafficSystemApplication.class, args);
    }

}
