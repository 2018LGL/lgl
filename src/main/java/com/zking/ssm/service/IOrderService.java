package com.zking.ssm.service;

import com.zking.ssm.model.Order;
import org.springframework.stereotype.Service;

public interface IOrderService {
    Order querySingleOrder(Integer orderId);
}