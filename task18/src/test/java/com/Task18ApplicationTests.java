package com;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserServiceTest.class,
        ApplicationUserServiceTest.class
})
class Task18ApplicationTests {

    @Test
    void contextLoads() {
    }

}
