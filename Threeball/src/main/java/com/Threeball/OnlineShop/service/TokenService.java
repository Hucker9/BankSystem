package com.Threeball.OnlineShop.service;

import com.Threeball.OnlineShop.model.requestDTO.LoginRequest;

public interface TokenService {

    String getToken(LoginRequest request);
}
