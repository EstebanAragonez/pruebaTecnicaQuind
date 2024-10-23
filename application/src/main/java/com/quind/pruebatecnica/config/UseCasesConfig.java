package com.quind.pruebatecnica.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.quind.model.ports", "com.quind.usecase"})
public class UseCasesConfig {

}
