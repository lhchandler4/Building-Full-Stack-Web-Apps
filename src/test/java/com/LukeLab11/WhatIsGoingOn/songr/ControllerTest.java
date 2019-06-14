package com.LukeLab11.WhatIsGoingOn.songr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCapitalizeMe(){
        Controller testing = new Controller();
        String resultingOutput = "GODZILLA";
        assertEquals(resultingOutput, testing.capitalizeMe("godzilla"));
    }

    @Test
    public void testReverseMe(){
        Controller testing = new Controller();
        String resultingOutput = "Get to the Chopper ";
        assertEquals(resultingOutput, testing.reverseMe("Chopper the to Get"));
    }

    @Test
    public void testRequestToRootGivesHelloWorldGeckoBecomesGodzilla() throws Exception {
        mockMvc.perform(get("/hello")).andExpect(content().string(containsString("Hello, world! The Gecko Becomes Godzilla!")));
    }

    @Test
    public void testCapitalizeRoute() throws Exception {
        mockMvc.perform(get("/capitalize/iguana")).andExpect(content().string(containsString("IGUANA")));
    }

    @Test
    public void testReverseRoute() throws Exception {
        mockMvc.perform(get("/reverse?sentence=Hello world")).andExpect(content().string(containsString("world Hello ")));
    }

}
