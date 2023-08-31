package de.cegos.SchulungSpring.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.cegos.SchulungSpring.rest.model.Student;
import de.cegos.SchulungSpring.rest.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    StudentService studentService;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Create PostRequest with Json to save Student")
    public void saveStudentPostTest() throws Exception {
        Student.StudentBuilder studentBuilder = Student.builder()
                .fullName("Max P")
                .mail("max@power.de");

        Student inputStudent = studentBuilder.build();
        Student outputStudent = studentBuilder.id(1L).build();
        String jsonInput = objectMapper.writeValueAsString(inputStudent);
        String jsonOutput = objectMapper.writeValueAsString(outputStudent);

        Mockito.when(studentService.saveStudent(Mockito.any()))
                .thenReturn(outputStudent);

        MockHttpServletRequestBuilder postRequest =
                MockMvcRequestBuilders.post("/students/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInput);

        mockMvc.perform(postRequest)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(jsonOutput));
    }
}