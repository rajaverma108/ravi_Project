package com.user.reg.sys.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.reg.sys.model.user.entities.Address;
import com.user.reg.sys.model.user.entities.UserData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Timestamp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebAppConfiguration
public class UserDataControllerTest {
    @InjectMocks
    private UserDataController userDataController;

    @Autowired
    WebApplicationContext context;
    @Autowired
    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();


    }

    @Test
    public void getAllUser() {
    }

    @Test
    public void getAllUserByid() {
    }

    @Test
    public void createAllUser() throws Exception {
        Address address = new Address();
        address.setPincode(12);
        address.setAddressline1("test");
        address.setAddressline2("test");
        address.setCity("test");
        address.setState("mp");
        UserData userData = new UserData();
        userData.setCid("21");
        userData.setFirstname("test");
        userData.setLastname("test");
        userData.setAddress(address);
        userData.setDateofbirth("10/08/1997");
        userData.setUid(121);
        userData.setRecordCreationDate(Mockito.mock(Timestamp.class));
        userData.setLastModified(Mockito.mock(Timestamp.class));
        address.setUserData(userData);
        String jsonReq = objectMapper.writeValueAsString(userData);

        mockMvc.perform(post("/users1").content(jsonReq).contentType(MediaType.APPLICATION_JSON_VALUE).
                        accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

//        String resultContent = result.getResponse().getContentAsString();
//        userData = objectMapper.readValue(resultContent, UserData.class);

    }

    @Test
    public void updateUserData() {
    }

    @Test
    public void deleteUserData() {
    }
}