package com.workshop.rest.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(UserController.class)
public class UserControllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void getUser() throws Exception {
        // Stub
        UserModel testModel = new UserModel(1, "demo", 30);
        when(userService.inquiryUserById(1)).thenReturn(testModel);
        // Call API
        MvcResult mvcResult = this.mvc.perform(get("/user/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Convert response to JSON object
        String response = mvcResult.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        UserResponse userResponse = mapper.readValue(response, UserResponse.class);

        // Assert
        assertEquals(1, userResponse.getId());
        assertEquals("demo", userResponse.getName());
        assertEquals(30, userResponse.getAge());

        // Quiz => equals() + hashcode()
        UserResponse expected = new UserResponse(1, "demo", 30);
        assertEquals(expected, userResponse);

    }
}