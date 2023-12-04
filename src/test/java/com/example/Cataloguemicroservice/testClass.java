package com.example.Cataloguemicroservice;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*@SpringBootTest*/
public class testClass {

    Calculator calculator = new Calculator();
    @Test
    public void testAdd() {
        int result = calculator.add(2, 3);
//        assertEquals(2+3, result);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void testAdd2() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(2, 1);
    }


    public class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
        public int minus(int a, int b) {
            return a + b;
        }
    }

}
