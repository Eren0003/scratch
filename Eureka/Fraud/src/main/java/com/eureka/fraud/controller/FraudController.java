package com.eureka.fraud.controller;

import com.eureka.fraud.dto.FraudCheckResponse;
import com.eureka.fraud.service.FraudCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v2/fraud-check")
public class FraudController {

    @Autowired
    private FraudCheckService service;

    @GetMapping(path="{customerId}")
    public FraudCheckResponse  fraudCheck(@PathVariable(value = "customerId") int customerId){
        return service.isFraudCustomer(customerId);
    }

}
