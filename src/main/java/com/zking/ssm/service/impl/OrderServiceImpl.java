package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.OrderMapper;
import com.zking.ssm.model.Order;
import com.zking.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order querySingleOrder(Integer orderId) {
        return orderMapper.querySingleOrder(orderId);
    }
}
