package de.cegos.SchulungSpring.rest;

import de.cegos.SchulungSpring.rest.controller.HelloController;
import de.cegos.SchulungSpring.rest.random.RandomNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RandomNameGenerator randomNameGenerator;

    @Test
    public void testSayHello() throws Exception {
        MockHttpServletRequestBuilder getRequest =
                MockMvcRequestBuilders.get("/hello/Claudia");

        mockMvc.perform(getRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("Hallöchen Claudia"));
    }

    @Test
    public void testDefault() throws Exception {
        Mockito.when(randomNameGenerator.getRandomFullName())
                .thenReturn("Max Mustermann");

        MockHttpServletRequestBuilder getRequest =
                MockMvcRequestBuilders.get("/");

        mockMvc.perform(getRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("Max Mustermann"));
    }

    @Test
    public void testBye() throws Exception {
        MockHttpServletRequestBuilder getRequest =
                MockMvcRequestBuilders.get("/bye")
                        .param("name", "Max");

        mockMvc.perform(getRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("Goodbye Max"));
    }

}