package com.example.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTests {
    @Autowired
    private AppUserController appUserController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(appUserController).isNotNull();
    }
}
