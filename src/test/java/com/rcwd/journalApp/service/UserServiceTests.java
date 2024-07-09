package com.rcwd.journalApp.service;

import com.rcwd.journalApp.entity.User;
import com.rcwd.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  UserService userService;

    @Disabled
    @Test
    public void testFindByUserName1(){
        User user = userRepository.findByUserName("ram");
        assertFalse(user.getJournalEntries().isEmpty());
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "shyam",
            "Aman"
    })
    public void testFindByUserName(String name){

        Assertions.assertNotNull(userRepository.findByUserName(name), "failed for: " + name);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })

    public void test(int a, int b, int expected){
        Assertions.assertEquals(expected, a+b);
    }



    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    @Disabled
    public void testSaveNewUser(User user) {
        assertTrue(userService.saveNewUser(user));
    }
}
