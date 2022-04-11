package com.bp.msdevops.controller;

import com.bp.msdevops.payload.DevOpsPayload;
import com.bp.msdevops.service.DevOpsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 
 * @author pedroalexandertenezaca
 *
 */
@WebMvcTest(controllers = DevOpsController.class)
@ExtendWith(SpringExtension.class)
@ComponentScan("com.bp.msdevops.domain.service")
class DevOpsControllerTest {

	@Autowired
	MockMvc mockMvc;

    @Autowired
    DevOpsService devOpsService;

    @Autowired
    private ObjectMapper objectMapper;

    DevOpsPayload payload = new DevOpsPayload(
        "This is a test",
        "Juan Perez",
        "Rita Asturia",
        45);

	@Test
	void returnMessageErrorWithGetMethod() throws Exception {
        mockMvc.perform(get("/DevOps")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content().string(equalTo("ERROR")));
	}

    @Test
	void returnMessageWithPostMethod() throws Exception {
        mockMvc.perform(post("/DevOps")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(payload)))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.message").value("Hello Juan Perez your message will be send"));
    
    }
	
    @Test
	void returnMessageErrorWithPutMethod() throws Exception {
        mockMvc.perform(put("/DevOps")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(payload)))
          .andExpect(status().isOk())
          .andExpect(content().string(equalTo("ERROR")));
	}

    @Test
	void returnMessageErrorWithDeleteMethod() throws Exception {
        mockMvc.perform(delete("/DevOps")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(payload)))
          .andExpect(status().isOk())
          .andExpect(content().string(equalTo("ERROR")));
	}
}
