package com.zking.ssm.mapper;

import com.zking.ssm.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    List<Customer> queryCustomerLst();
}