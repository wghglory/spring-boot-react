package com.guanghui.springbootreact;

import com.guanghui.springbootreact.controller.CarController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
// this should use the default in-memory db
@AutoConfigureTestDatabase
class SpringBootReactApplicationTests {
    @Autowired
    private CarController carController;


    @Test
    @DisplayName("First example test case")
    void contextLoads() {
        assertThat(carController).isNotNull();
    }

}
