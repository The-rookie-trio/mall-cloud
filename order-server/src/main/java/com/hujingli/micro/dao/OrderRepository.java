package com.hujingli.micro.dao;

import org.trt.micro.common.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {

}
