package com.Assignment3.CRUD.Example;


import com.Assignment3.CRUD.Example.controller.UserController;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.Assignment3.CRUD.Example.entity.User;
import com.Assignment3.CRUD.Example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockitoBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#save(User)}
     */
    @Test
    void testAddEmployee() throws Exception {
        User user = new User();
        user.setSalary("17000");
        user.setEmpid(9);
        user.setEmpname("Name");
        user.setDob("21/01/1997");

        String content = new ObjectMapper().writeValueAsString(user);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UserController#findAll()}
     */
    @Test
    void testGetEmployee() throws Exception {
        User user = new User();
        user.setSalary("17000");
        user.setEmpid(9);
        user.setEmpname("Name");
        user.setDob("21/01/1997");
        when(userService.findById(anyInt())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/findById")
                .param("id", "1");

        String expectedJson = "{\"empid\":9,\"empname\":\"Name\",\"dob\":\"21/01/1997\",\"salary\":\"17000\"}";

        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson)); // field order ignored
    }
}
