package com.eureka.fraud.service;

import com.eureka.fraud.dto.FraudCheckResponse;
import com.eureka.fraud.model.FraudCheckHistory;
import com.eureka.fraud.repository.FraudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {
    @Autowired
    private FraudRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    public FraudCheckResponse isFraudCustomer(int customerId){
        FraudCheckResponse response = restTemplate.getForObject(
                "http://CUSTOMER/api/v1/customer/{customerId}",
                FraudCheckResponse.class,
                customerId);
        repository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .createAt(LocalDateTime.now())
                .isFraudster(!response.isFraudster()).build());
        return response;
    }



}
