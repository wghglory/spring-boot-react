package com.guanghui.springbootreact.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// This connects to the real db without @AutoConfigureTestDatabase!
@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAuthentication() throws Exception {
        mockMvc.perform(
                        post("/api/v1/login")
                                .content("{\"username\": \"guanghuiw\", \"password\": \"123123\"}")
                                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}