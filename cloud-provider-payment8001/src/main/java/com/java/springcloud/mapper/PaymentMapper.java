package com.java.springcloud.mapper;

import com.java.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

     Payment getById(Integer id);
}
