package com.inretailpharma.digital.ordermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Clase principal, anotada como SpringBootApplication
 *
 * @author : Carlos calla
 */
@SpringBootApplication
@EnableSwagger2
public class OrderManagerApplication{

    public static void main( String[] args ){
        SpringApplication.run(OrderManagerApplication.class, args);
    }
}
