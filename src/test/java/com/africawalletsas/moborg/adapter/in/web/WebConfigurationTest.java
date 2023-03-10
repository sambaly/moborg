package com.africawalletsas.moborg.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class WebConfigurationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getOfDashboardEndpointReturns200Ok() throws Exception {
        mockMvc.perform(get("/dashboard"))
                .andExpect(status().isOk());
    }

    @Test
    void getOfHuddleDetailEndpointReturns200Ok() throws Exception {
        mockMvc.perform(get("/huddle"))
                .andExpect(status().isOk());
    }

    @Test
    void postToScheduleHuddleEndpointRedirects() throws Exception {
        mockMvc.perform(post("/schedule"))
                .andExpect(status().is3xxRedirection());
    }
}
