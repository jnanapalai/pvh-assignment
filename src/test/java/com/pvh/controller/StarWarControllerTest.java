package com.pvh.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;



import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class StarWarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin",password = "password")
    public void getPeopleById_Test() throws Exception {
        mockMvc.perform(get("/api/people/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(notNullValue())))
                .andExpect(jsonPath("$.height",is(notNullValue())))
                .andExpect(jsonPath("$.hair_color",is(notNullValue())))
                .andExpect(jsonPath("$.skin_color",is(notNullValue())))
                .andExpect(jsonPath("$.eye_color",is(notNullValue())))
                .andExpect(jsonPath("$.birth_year",is(notNullValue())))
                .andExpect(jsonPath("$.homeworld",is(notNullValue())))
                .andExpect(jsonPath("$.species",is(notNullValue())))
                .andExpect(jsonPath("$.vehicles",is(notNullValue())))
                .andExpect(jsonPath("$.starships",is(notNullValue())))
                .andExpect(jsonPath("$.created",is(notNullValue())))
                .andExpect(jsonPath("$.edited",is(notNullValue())))
                .andExpect(jsonPath("$.url",is(notNullValue())));

    }

    @Test
    @WithMockUser(username = "admin",password = "password")
    public void getPeopleByIdInvalid_Test() throws Exception {
        mockMvc.perform(get("/api/people/111111")).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorMessage",is(notNullValue())))
                .andExpect(jsonPath("$.errorCode",is(notNullValue())))
                .andExpect(jsonPath("$.errorOccurredTime",is(notNullValue())));

    }


    @Test
    @WithMockUser(username = "admin",password = "password")
    public void getPlanetByIdInvalid_Test() throws Exception {
        mockMvc.perform(get("/api/planet/111111")).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorMessage",is(notNullValue())))
                .andExpect(jsonPath("$.errorCode",is(notNullValue())))
                .andExpect(jsonPath("$.errorOccurredTime",is(notNullValue())));

    }

    @Test
    @WithMockUser(username = "admin",password = "password")
    public void getPlanetByIdInvalid_Test_badRequest() throws Exception {
        mockMvc.perform(get("/api/planet/uio")).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorMessage",is(notNullValue())))
                .andExpect(jsonPath("$.errorCode",is(notNullValue())))
                .andExpect(jsonPath("$.errorOccurredTime",is(notNullValue())));

    }

    @Test
    @WithMockUser(username = "admin",password = "password")
    public void getPeopleByIdInvalid_Test_badRequest() throws Exception {
        mockMvc.perform(get("/api/people/uio")).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorMessage",is(notNullValue())))
                .andExpect(jsonPath("$.errorCode",is(notNullValue())))
                .andExpect(jsonPath("$.errorOccurredTime",is(notNullValue())));

    }

    @Test
    @WithMockUser(username = "admin",password = "password")
    public void getPeopleByName_Test() throws Exception {
        mockMvc.perform(get("/api/people?name=Luke")).andExpect(status().isOk())
                .andExpect(jsonPath("$..name",is(notNullValue())))
                .andExpect(jsonPath("$..height",is(notNullValue())))
                .andExpect(jsonPath("$..hair_color",is(notNullValue())))
                .andExpect(jsonPath("$..skin_color",is(notNullValue())))
                .andExpect(jsonPath("$..eye_color",is(notNullValue())))
                .andExpect(jsonPath("$..birth_year",is(notNullValue())))
                .andExpect(jsonPath("$..homeworld",is(notNullValue())))
                .andExpect(jsonPath("$..species",is(notNullValue())))
                .andExpect(jsonPath("$..vehicles",is(notNullValue())))
                .andExpect(jsonPath("$..starships",is(notNullValue())))
                .andExpect(jsonPath("$..created",is(notNullValue())))
                .andExpect(jsonPath("$..edited",is(notNullValue())))
                .andExpect(jsonPath("$..url",is(notNullValue())))
                .andExpect(jsonPath("$.count",is(notNullValue())))
                .andExpect(jsonPath("$.next").hasJsonPath())
                .andExpect(jsonPath("$.previous").hasJsonPath());

    }


     @Test
     @WithMockUser(username = "admin",password = "password")
    public void getPlanetByName_Test() throws Exception {
         mockMvc.perform(get("/api/planet?name=Tatooine")).andExpect(status().isOk())
                 .andExpect(jsonPath("$..rotation_period",is(notNullValue())))
                 .andExpect(jsonPath("$..orbital_period",is(notNullValue())))
                 .andExpect(jsonPath("$..diameter",is(notNullValue())))
                 .andExpect(jsonPath("$..climate",is(notNullValue())))
                 .andExpect(jsonPath("$..gravity",is(notNullValue())))
                 .andExpect(jsonPath("$..terrain",is(notNullValue())))
                 .andExpect(jsonPath("$..surface_water",is(notNullValue())))
                 .andExpect(jsonPath("$..population",is(notNullValue())))
                 .andExpect(jsonPath("$..residents",is(notNullValue())))
                 .andExpect(jsonPath("$..films",is(notNullValue())))
                 .andExpect(jsonPath("$..created",is(notNullValue())))
                 .andExpect(jsonPath("$..edited",is(notNullValue())))
                 .andExpect(jsonPath("$..url",is(notNullValue())))
                 .andExpect(jsonPath("$.count",is(notNullValue())))
                 .andExpect(jsonPath("$.next").hasJsonPath())
                 .andExpect(jsonPath("$.previous").hasJsonPath());;

     }

    @Test
    @WithMockUser(username = "admin",password = "password")
    public void getPlanetById_Test() throws Exception {
        mockMvc.perform(get("/api/planet/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.rotation_period",is(notNullValue())))
                .andExpect(jsonPath("$.orbital_period",is(notNullValue())))
                .andExpect(jsonPath("$.diameter",is(notNullValue())))
                .andExpect(jsonPath("$.climate",is(notNullValue())))
                .andExpect(jsonPath("$.gravity",is(notNullValue())))
                .andExpect(jsonPath("$.terrain",is(notNullValue())))
                .andExpect(jsonPath("$.surface_water",is(notNullValue())))
                .andExpect(jsonPath("$.population",is(notNullValue())))
                .andExpect(jsonPath("$.residents",is(notNullValue())))
                .andExpect(jsonPath("$.films",is(notNullValue())))
                .andExpect(jsonPath("$.created",is(notNullValue())))
                .andExpect(jsonPath("$.edited",is(notNullValue())))
                .andExpect(jsonPath("$.url",is(notNullValue())));

    }

}
