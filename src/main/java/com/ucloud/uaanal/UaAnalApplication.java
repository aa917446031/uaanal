package com.ucloud.uaanal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.ucloud.uaanal.mapper.mysql")
public class UaAnalApplication {

    public static void main(String[] args) {
        SpringApplication.run(UaAnalApplication.class, args);
    }

}
