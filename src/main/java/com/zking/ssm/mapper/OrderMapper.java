package com.zking.ssm.mapper;

import com.zking.ssm.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    Order querySingleOrder(Integer orderId);
}