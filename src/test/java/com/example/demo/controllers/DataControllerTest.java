package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** Web-layer tests exercising the /print endpoint end to end (JSON in, JSON out). */
@SpringBootTest
@AutoConfigureMockMvc
class DataControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void rendersMultipleLettersInOrder() throws Exception {
        mvc.perform(post("/print")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"letters\": \"XY\", \"size\": 3}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].letterGrid[0]").value("* *"))
                .andExpect(jsonPath("$[0].letterGrid[1]").value(" * "))
                .andExpect(jsonPath("$[0].letterGrid[2]").value("* *"))
                .andExpect(jsonPath("$[1].letterGrid[2]").value(" * "));
    }

    @Test
    void lowercaseLettersAreAccepted() throws Exception {
        mvc.perform(post("/print")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"letters\": \"z\", \"size\": 5}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].letterGrid[0]").value("*****"));
    }

    @Test
    void evenSizeIsRejected() throws Exception {
        mvc.perform(post("/print")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"letters\": \"X\", \"size\": 4}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").exists());
    }

    @Test
    void unsupportedLetterIsRejected() throws Exception {
        mvc.perform(post("/print")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"letters\": \"Q\", \"size\": 3}"))
                .andExpect(status().isBadRequest());
    }
}
