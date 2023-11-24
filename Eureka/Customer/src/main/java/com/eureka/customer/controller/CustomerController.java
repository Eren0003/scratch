package com.eureka.customer.controller;

import com.eureka.customer.dto.CustomerRegisterRequest;
import com.eureka.customer.dto.FraudCheckResponse;
import com.eureka.customer.dto.Response;
import com.eureka.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @PostMapping("/register")
    public Response registerCustomer(@RequestBody CustomerRegisterRequest request){
        return service.customerRegistration(request);
    }
    @GetMapping(path="{customerId}")
    public FraudCheckResponse isRegister(@PathVariable(value="customerId")int customerId){
        return service.isRegister(customerId);
    }

}
