package com.zking.ssm.service.impl;

import com.zking.ssm.model.Customer;
import com.zking.ssm.model.Order;
import com.zking.ssm.service.ICustomerService;
import com.zking.ssm.service.IOrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CustomerServiceImplTest extends BaseTestCase{

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IOrderService orderService;

    @Test
    public void queryCustomerLst() {
        List<Customer> customers = customerService.queryCustomerLst();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void querySingleOrder(){
        Order order = orderService.querySingleOrder(1);
        System.out.println(order);

    }
}