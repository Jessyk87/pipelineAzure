package com.bp.msdevops.service;

import com.bp.msdevops.payload.DevOpsPayload;

import org.springframework.stereotype.Service;

/**
 * 
 * @author pedroalexandertenezaca
 *
 */
@Service
public class DevOpsService {
    public String sendMessage(DevOpsPayload payload) {
        return "Hello " + payload.getTo() + " your message will be send";
    }
}
