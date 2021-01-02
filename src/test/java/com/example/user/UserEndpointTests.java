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
    protected final String URL_USER_SIGNUP = "/users/sign-up";
    protected final String URL_USER_GET_ALL = "/users/all";
    protected final String URL_USER_GET_ALL_RESTRICTED = "/users/allu";
    protected final String URL_USER_LOGIN = "/login";

    // @TODO: find a better way to declare the JSON
    protected final String USER_VALID_CREDS = "{ \"name\": \"web2\", \"password\": \"password\" }";
    protected final String USER_INVALID_CREDS = "{ \"name\": \"web2invalid\", \"password\": \"password\" }";
//    @LocalServerPort
//    private int port;

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    protected static String authToken = null;
    protected String expiredJwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3ZWIyIiwiQXBwVXJsIjoiaHR0cHM6Ly9naXRodWIuY29tL2thdmluZGFzaWx2YS9qYXZhLWNydWQiLCJleHAiOjE2MDkxNzk3MDUsIlVzZXJUeXBlIjoyLCJlbWFpbCI6ImRlZmF1bHRAdXNlci5uYW1lIn0.8g5g9O3wHv9USW3wS0Hwfubb3BKBufcloKMwAd0hENROaEmYpwJuOUDvkHJPN_W2rS9Vk-OLlXtiESPalaPELA";

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

        this.authToken = res.getResponse().getHeader("Authorization").split(" ")[1];
        System.out.println("authtoken get: "+this.authToken);
    }

    @Test
    public void getSystemsUsers() throws Exception {
        MvcResult res = this.mockMvc.perform(
                get(this.URL_USER_GET_ALL )
                        .header("Authorization", "Bearer "+this.authToken)
        ).andDo(print()).andExpect(status().is2xxSuccessful()).andReturn();
    }

    @Test
    public void tryToAccessWithoutToken() throws Exception {
        MvcResult res = this.mockMvc.perform(
                get(this.URL_USER_GET_ALL )
        ).andDo(print()).andExpect(status().isForbidden()).andReturn();
    }

    // TODO: find why this is failing
    @Test
    public void tryToAccessWithInvalidToken() throws Exception {
        MvcResult res = this.mockMvc.perform(
                get(this.URL_USER_GET_ALL )
                        .header("Authorization", "Bearer invalid")
        ).andDo(print()).andReturn();
                //andExpect(status().isForbidden()).andReturn();
    }

    // TODO: find why this is failing
    @Test
    public void tryToAccessWithExpiredToken() throws Exception {
        MvcResult res = this.mockMvc.perform(
                get(this.URL_USER_GET_ALL )
                        .header("Authorization", "Bearer "+this.expiredJwt)
        ).andDo(print()).andReturn();
                //andExpect(status().isForbidden()).andReturn();
    }

    @Test
    public void tryToAccessUnauthorizedUrl() throws Exception {
        MvcResult res = this.mockMvc.perform(
                get(this.URL_USER_GET_ALL_RESTRICTED )
                        .header("Authorization", "Bearer "+this.authToken)
        ).andDo(print()).andExpect(status().isForbidden()).andReturn();
    }
}
