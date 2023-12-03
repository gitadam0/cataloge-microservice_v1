package com.example.Cataloguemicroservice;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*@SpringBootTest*/
public class testClass {

    Calculator calculator = new Calculator();
    @Test
    public void testAdd() {
        int result = calculator.add(2, 3);
        assertEquals(2+3, result);
    }

    @Test
    public void testAdd2() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(2, 1);
    }
}
