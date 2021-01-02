package com.example.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import com.example.security.SecurityConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserEndpointTests {
    // @TODO: make these URLs constant in UserController, and try to import here
    protected static final String URL_USER_SIGNUP = "/users/sign-up";
    protected static final String URL_USER_GET_ALL = "/users/all";
    protected static final String URL_USER_GET_ALL_RESTRICTED = "/users/allu";
    protected static final String URL_USER_LOGIN = "/login";

    // @TODO: find a better way to decvlare the JSON
    protected static final String USER_VALID_CREDS = "{ \"name\": \"web2\", \"password\": \"password\" }";
    protected static final String USER_INVALID_CREDS = "{ \"name\": \"web2invalid\", \"password\": \"password\" }";
//    @LocalServerPort
//    private int port;

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

//    protected String getCredentails(boolean isValid){
////        ObjectMapper objMapper = new ObjectMapper();
////        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        try {
//            JSONObject jsonObject;
////            if(isValid)
//            jsonObject = (isValid) ? new JSONObject(this.USER_VALID_CREDS) : new JSONObject(this.USER_INVALID_CREDS);
//        }catch (JSONException err){
//            System.out.println("Error: " + err.toString());
//        }
//        return
//    }
////
    @Test
    public void shouldShowUnauthorizedMessage() throws Exception {
        this.mockMvc.perform(get(this.URL_USER_GET_ALL)).andDo(print()).andExpect(status().isForbidden())
                .andExpect( content().string("") );
    }

    @Test
    public void tryLoginWithBadCredentials() throws Exception {
        this.mockMvc.perform(
                    post(this.URL_USER_LOGIN )
                            .contentType(MediaType.APPLICATION_JSON)
                            .content( this.USER_INVALID_CREDS )
                )
                .andDo(print()).andExpect(status().isUnauthorized())
                .andExpect( content().string("") );
    }

//    @Test
//    public void greetingShouldReturnDefaultMessage() throws Exception {
//        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
//                String.class)).contains("Hello, World");
//    }
}
