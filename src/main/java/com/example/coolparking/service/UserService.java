package com.example.coolparking.service;


import com.example.coolparking.dataobject.ParkingOrder;

import java.util.List;
import java.util.Map;

public interface UserService {
    void login(String openId);
    List<ParkingOrder> findOrderById(String openId);
    String createOrder(int parkingId,String carNum);
    Map getPrice(String license, String id);
    void payOrderSuccess(String orderId);
}
