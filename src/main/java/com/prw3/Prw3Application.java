package com.prw3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/*
* Avaliação 3 - PW3
* Integrantes:
* -> Gustavo Trizotti (SC 3044998)
* -> Arthur Mascaro (SC3044599)
* */

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode =
        EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class Prw3Application {
    public static void main(String[] args) {
        SpringApplication.run(Prw3Application.class, args);
    }
}