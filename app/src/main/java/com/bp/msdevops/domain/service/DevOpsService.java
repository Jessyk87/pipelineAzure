package com.bp.msdevops.domain.service;

import com.bp.msdevops.payload.DevOpsPayload;

import org.springframework.stereotype.Service;

@Service
public class DevOpsService {
    public String sendMessage(DevOpsPayload payload) {
        return "Hello " + payload.getTo() + " your message will be send";
    }
}
