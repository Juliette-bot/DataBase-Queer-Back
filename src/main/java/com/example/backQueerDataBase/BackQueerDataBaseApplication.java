package com.example.backQueerDataBase;

import com.example.backQueerDataBase.Configuration.EnvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackQueerDataBaseApplication {

    public static void main(String[] args) {
        EnvConfig.loadEnvironmentVariables();
        SpringApplication.run(BackQueerDataBaseApplication.class, args);
    }
}