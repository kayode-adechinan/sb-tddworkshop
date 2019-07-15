package com.adechinan.dev.sbtddworkshop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private HomeController controller;


   /*
        // setup object mapper for mapping string to json
    private ObjectMapper objectMapper;


    @Before
    public void setUp(){

        objectMapper = new ObjectMapper();


    }*/


    @Test
    public void homeControllerShouldExist() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        //this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
        //      .andExpect(content().string(containsString("Hello World")));

        MvcResult mvcResult = this.mockMvc.perform(get("/")).andReturn();

        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(200);

        String content = mvcResult.getResponse().getContentAsString();

        assertThat(content.contains("Hello World"));


        /* map result to json and test

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/greeting")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(200);

        String content = mvcResult.getResponse().getContentAsString();

        Greeting greeting = objectMapper.readValue(content, Greeting.class);

        assertThat(greeting).isNotNull();



         */


    }

}