package org.example.capitole.challenge.infrastructure.inbound.controllers;

import org.example.capitole.AbstractIntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PriceControllerTest extends AbstractIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private static final String URL = "/price_detail";

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void testInput1() throws Exception {

        String content = """
                         {
                           "date": "2020-06-14T10:00:00",
                           "productId": 35455,
                           "brandId": 1
                         }
                         """;

        mockMvc.perform(post(URL).contentType("application/json").content(content))
            .andExpect(status().is(HttpStatus.OK.value()))
            .andExpect(jsonPath("$.price_list_name", is("TARIFA 1")))
            .andExpect(jsonPath("$.productId", is(35455)))
            .andExpect(jsonPath("$.brandId", is(1)))
            .andExpect(jsonPath("$.price", is(35.5)))
            .andExpect(jsonPath("$.startDate", is("2020-06-14T00:00:00")))
            .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
            .andReturn().getResponse().getContentAsString();
    }

    @Test
    void testInput2() throws Exception {

        String content = """
                         {
                           "date": "2020-06-14T16:00:00",
                           "productId": 35455,
                           "brandId": 1
                         }
                         """;

        mockMvc.perform(post(URL).contentType("application/json").content(content))
            .andExpect(status().is(HttpStatus.OK.value()))
            .andExpect(jsonPath("$.price_list_name", is("TARIFA 2")))
            .andExpect(jsonPath("$.productId", is(35455)))
            .andExpect(jsonPath("$.brandId", is(1)))
            .andExpect(jsonPath("$.price", is(25.45)))
            .andExpect(jsonPath("$.startDate", is("2020-06-14T15:00:00")))
            .andExpect(jsonPath("$.endDate", is("2020-06-14T18:30:00")))
            .andReturn().getResponse().getContentAsString();
    }

    @Test
    void testInput3() throws Exception {

        String content = """
                         {
                           "date": "2020-06-14T21:00:00",
                           "productId": 35455,
                           "brandId": 1
                         }
                         """;

        mockMvc.perform(post(URL).contentType("application/json").content(content))
            .andExpect(status().is(HttpStatus.OK.value()))
            .andExpect(jsonPath("$.price_list_name", is("TARIFA 1")))
            .andExpect(jsonPath("$.productId", is(35455)))
            .andExpect(jsonPath("$.brandId", is(1)))
            .andExpect(jsonPath("$.price", is(35.5)))
            .andExpect(jsonPath("$.startDate", is("2020-06-14T00:00:00")))
            .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
            .andReturn().getResponse().getContentAsString();
    }

    @Test
    void testInput4() throws Exception {

        String content = """
                         {
                           "date": "2020-06-15T10:00:00",
                           "productId": 35455,
                           "brandId": 1
                         }
                         """;

        mockMvc.perform(post(URL).contentType("application/json").content(content))
            .andExpect(status().is(HttpStatus.OK.value()))
            .andExpect(jsonPath("$.price_list_name", is("TARIFA 3")))
            .andExpect(jsonPath("$.productId", is(35455)))
            .andExpect(jsonPath("$.brandId", is(1)))
            .andExpect(jsonPath("$.price", is(30.5)))
            .andExpect(jsonPath("$.startDate", is("2020-06-15T00:00:00")))
            .andExpect(jsonPath("$.endDate", is("2020-06-15T11:00:00")))
            .andReturn().getResponse().getContentAsString();
    }

    @Test
    void testInput5() throws Exception {

        String content = """
                         {
                           "date": "2020-06-16T21:00:00",
                           "productId": 35455,
                           "brandId": 1
                         }
                         """;

        mockMvc.perform(post(URL).contentType("application/json").content(content))
            .andExpect(status().is(HttpStatus.OK.value()))
            .andExpect(jsonPath("$.price_list_name", is("TARIFA 4")))
            .andExpect(jsonPath("$.productId", is(35455)))
            .andExpect(jsonPath("$.brandId", is(1)))
            .andExpect(jsonPath("$.price", is(38.95)))
            .andExpect(jsonPath("$.startDate", is("2020-06-15T16:00:00")))
            .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
            .andReturn().getResponse().getContentAsString();
    }

    @Test
    void testMalformedJson() throws Exception {

        String content = """
                         {
                           "date": "2020-06-14dT16:00:00",
                           "productId": 35455,
                           "brandId": 1
                         }
                         """;

        mockMvc.perform(post(URL).contentType("application/json").content(content))
            .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
            .andExpect(jsonPath("$.status", is("BAD_REQUEST")))
            .andExpect(jsonPath("$.message", is("Malformed JSON request")))
            .andExpect(jsonPath("$.debugMessage", is("""
                                                     JSON parse error: Cannot deserialize value of type `java.time.LocalDateTime` \
                                                     from String "2020-06-14dT16:00:00": Failed to deserialize java.time.LocalDateTime: \
                                                     (java.time.format.DateTimeParseException) Text '2020-06-14dT16:00:00' \
                                                     could not be parsed at index 10\
                                                     """)))
            .andReturn().getResponse().getContentAsString();
    }


}