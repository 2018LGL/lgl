package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.BookMapper;
import com.zking.ssm.mapper.CustomerMapper;
import com.zking.ssm.model.Customer;
import com.zking.ssm.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> queryCustomerLst() {
        return customerMapper.queryCustomerLst();
    }
}
