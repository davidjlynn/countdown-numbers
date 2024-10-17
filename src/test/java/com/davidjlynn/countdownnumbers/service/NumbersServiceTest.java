package com.davidjlynn.countdownnumbers.service;

import com.davidjlynn.countdownnumbers.service.model.SumSo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NumbersServiceTest {

    private final NumbersService numbersService = new NumbersService();

    @Test
    public void calculateListOfResults_validOne() {
        // given:
        List<Integer> input = List.of(2);

        // when:
        List<SumSo> result = numbersService.calculateListOfResults(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void calculateListOfResults_validTwo() {
        // given:
        List<Integer> input = List.of(2, 4);

        // when:
        List<SumSo> result = numbersService.calculateListOfResults(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(7, result.size());
    }

    @Test
    public void calculateListOfResults_validThree() {
        // given:
        List<Integer> input = List.of(2, 4, 6);

        // when:
        List<SumSo> result = numbersService.calculateListOfResults(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(90, result.size());
    }
}
