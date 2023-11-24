package com.eureka.customer.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
public class CustomerConfig {
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpComponentsClientHttpRequestFactory.setConnectTimeout(3000);
//        return new RestTemplate(httpComponentsClientHttpRequestFactory);
//    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
//    @Bean
//    public Docket swaggerConfig(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis("/api/**");
//    }
}
