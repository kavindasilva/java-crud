package com.example.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserEndpointTests {
    // @TODO: make these URLs constant in UserController, and try to import here
    protected static final String URL_USER_SIGNUP = "/users/sign-up";
    protected static final String URL_USER_GET_ALL = "/users/all";
    protected static final String URL_USER_GET_ALL_RESTRICTED = "/users/allu";
    protected static final String URL_USER_LOGIN = "/login";

    // @TODO: find a better way to declare the JSON
    protected static final String USER_VALID_CREDS = "{ \"name\": \"web2\", \"password\": \"password\" }";
    protected static final String USER_INVALID_CREDS = "{ \"name\": \"web2invalid\", \"password\": \"password\" }";
//    @LocalServerPort
//    private int port;

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldShowUnauthorizedMessage() throws Exception {
        this.mockMvc.perform(get(this.URL_USER_GET_ALL)).andDo(print()).andExpect(status().isForbidden())
                .andExpect( content().string("") );
    }

    @Test
    public void tryLoginWithBadCredentials() throws Exception {
        MvcResult res = this.mockMvc.perform(
                post(this.URL_USER_LOGIN )
                        .contentType(MediaType.APPLICATION_JSON)
                        .content( this.USER_INVALID_CREDS )
                ).andDo(print()).andExpect(status().isUnauthorized()).andReturn();

        Assertions.assertEquals( 401, res.getResponse().getStatus() );
        Assertions.assertTrue( res.getResponse().containsHeader("Reason-Failed") );
        Assertions.assertFalse( res.getResponse().containsHeader("Authorization") );
        Assertions.assertEquals( "Bad credentials", res.getResponse().getHeader("Reason-Failed") );
    }

    @Test
    public void tryLoginWithCorrectCredentials() throws Exception {
        MvcResult res = this.mockMvc.perform(
                post(this.URL_USER_LOGIN )
                        .contentType(MediaType.APPLICATION_JSON)
                        .content( this.USER_VALID_CREDS )
        ).andDo(print()).andExpect(status().is2xxSuccessful()).andReturn();

        Assertions.assertEquals( 200, res.getResponse().getStatus() );
        Assertions.assertFalse( res.getResponse().containsHeader("Reason-Failed") );
        Assertions.assertTrue( res.getResponse().containsHeader("Authorization") );
        Assertions.assertEquals( "Bearer", res.getResponse().getHeader("Authorization").split(" ")[0] );
    }

//    @Test
//    public void greetingShouldReturnDefaultMessage() throws Exception {
//        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
//                String.class)).contains("Hello, World");
//    }
}
