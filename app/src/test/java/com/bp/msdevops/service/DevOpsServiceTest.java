package com.bp.msdevops.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bp.msdevops.payload.DevOpsPayload;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 
 * @author pedroalexandertenezaca
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class DevOpsServiceTest {

    @Autowired
    DevOpsService devOpsService;

    @Configuration
    public static class Config {
        @Bean
        public DevOpsService getDevOpsService() {
            return new DevOpsService();
        }
    }


    @Test
    void getMessages() {
        DevOpsPayload payload = new DevOpsPayload(
                "This is a test",
                "Juan Perez",
                "Rita Asturia",
                45);
        assertEquals("Hello Juan Perez your message will be send", devOpsService.sendMessage(payload));
    }

}