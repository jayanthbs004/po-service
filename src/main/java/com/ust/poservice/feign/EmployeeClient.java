package com.ust.poservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employee-service", url = "http://localhost:3030/api/employees")
public interface EmployeeClient {
    @GetMapping("/{id}")
    Object getEmployeeById(@PathVariable Long id);
}
