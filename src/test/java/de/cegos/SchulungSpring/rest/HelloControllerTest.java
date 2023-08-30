package de.cegos.SchulungSpring.rest;

import de.cegos.SchulungSpring.rest.random.RandomNameGenerator;
import org.junit.jupiter.api.Test;
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


}