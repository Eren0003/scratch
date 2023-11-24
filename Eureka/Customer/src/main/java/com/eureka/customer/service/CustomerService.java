package com.eureka.customer.service;
import com.eureka.customer.dto.CustomerRegisterRequest;
import com.eureka.customer.dto.FraudCheckResponse;
import com.eureka.customer.dto.Response;
import com.eureka.customer.model.Customer;
import com.eureka.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    public Response customerRegistration(CustomerRegisterRequest request) {
        Customer temp = repository.existByEmail(request.email());
        if(temp != null){
            return new Response("Email already Exist");
        }else {
            Customer customer = repository.saveAndFlush(Customer.builder()
                    .firstname(request.firstname())
                    .lastname(request.lastname())
                    .email(request.email()).build());
//        FraudCheck check = restTemplate.getForObject(
//                "http://localhost:8081/api/v2/fraud-check/{customerId}"
//                , FraudCheck.class,customer.getId());
//        if(check.isFraudster() == true){
//            throw new IllegalArgumentException("fraudster");
//        }
            return new Response("Register Successfully");
        }
    }
    public FraudCheckResponse isRegister(int customerId) {
        Customer customer = repository.findById(customerId);
        System.out.println(customer);
        if(customer != null){
            return new FraudCheckResponse(true);
        }else{
            return new FraudCheckResponse(false);
        }
    }
}
