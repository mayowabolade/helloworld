package com.poc.helloworld.controller;

import com.poc.helloworld.service.HelloWorldService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloWorldService helloWorldService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGreetAsJson() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("date", "June 24, 2024");
        jsonObject.put("time", "10:00 AM");
        jsonObject.put("greeting", "Hello world! Good morning");

        when(helloWorldService.fetchRightGreeting()).thenReturn(jsonObject);

        mockMvc.perform(get("/helloworld/greet"))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonObject.toString()));
    }

    @Test
    void testGreetAsString() throws Exception {
        String greeting = "Hello world! Today's date is June 24, 2024. The time is 10:00 AM. Good morning.";
        when(helloWorldService.getTimeOfDay()).thenReturn(greeting);

        mockMvc.perform(get("/helloworld/sayhi"))
                .andExpect(status().isOk())
                .andExpect(content().string(greeting));
    }
}