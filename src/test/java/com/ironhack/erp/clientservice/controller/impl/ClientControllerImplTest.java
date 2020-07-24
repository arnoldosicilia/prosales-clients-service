package com.ironhack.erp.clientservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.clientservice.model.entities.Client;
import com.ironhack.erp.clientservice.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ClientControllerImplTest {

    @Autowired
    ClientControllerImpl clientController;

    @MockBean
    ClientRepository clientRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    Client client;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        client = new Client("12345678A", "test@test.com", "test", "test","test n1", "test", "test", 38004, "test","test.com", "654654654", Long.valueOf(12345));



        when(clientRepository.findAll()).thenReturn(Arrays.asList(client));
        when(clientRepository.findById((long) 1)).thenReturn(java.util.Optional.ofNullable(client));
        when(clientRepository.save(client)).thenReturn(client);
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/clients")).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/client/1")).andExpect(status().isOk());
    }

    @Test
    void createClient() throws Exception {
        mockMvc.perform(post("/client")
                .content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void updateClient() throws Exception {
        mockMvc.perform(put("/client/1")
                .content(objectMapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteClient() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/client/1")).andExpect(status().isNoContent());
    }
}