package com.elmarrakchy.billservice.feign;

import com.elmarrakchy.billservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping(path = "/customers")
    PagedModel<Customer> getAllCustomers();

    @GetMapping(path = "/customers/{id}")
    Customer getCustomerById(@PathVariable(name = "id") String id);
}
