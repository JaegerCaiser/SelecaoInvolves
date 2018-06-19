package com.involves.selecao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SelecaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelecaoApplication.class, args);
    }
}
