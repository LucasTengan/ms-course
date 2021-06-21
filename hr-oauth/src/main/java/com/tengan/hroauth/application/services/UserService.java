package com.tengan.hroauth.application.services;

import com.tengan.hroauth.adapter.feignclients.UserFeignClient;
import com.tengan.hroauth.domain.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserFeignClient userFeignClient;

    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null) {
            logger.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }

        logger.info("Email found: " + email);
        return user;
    }
}
