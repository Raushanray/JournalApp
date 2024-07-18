package com.rcwd.journalApp.repository;

import com.rcwd.journalApp.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class UserRepositoryImplTests {

    @Autowired
    private UserRepositoryImpl userRepository;


    @Disabled("tested")
    @Test
    public void testSaveNewUser(){
       Assertions.assertNotNull(userRepository.getUserForSA());
    }

}
