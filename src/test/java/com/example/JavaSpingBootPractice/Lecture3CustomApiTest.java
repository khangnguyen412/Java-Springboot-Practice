package com.example.JavaSpingBootPractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class Lecture3CustomApiTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_get_all_account() throws Exception {
        mockMvc.perform(get("/lecture2/api/account/fillter-balance/600")).andExpect(status().isOk());
    }

}
