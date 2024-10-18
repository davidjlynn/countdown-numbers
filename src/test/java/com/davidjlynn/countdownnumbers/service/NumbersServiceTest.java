package com.davidjlynn.countdownnumbers.service;

import com.davidjlynn.countdownnumbers.service.model.SumSo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NumbersServiceTest {

    private final NumbersService numbersService = new NumbersService();

    @Test
    public void calculateListOfResults_0() {
        // given:
        List<Integer> input = List.of();

        // when:
        List<SumSo> result = numbersService.calculateListOfResults(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void calculateListOfResults_1() {
        // given:
        List<Integer> input = List.of(1);

        // when:
        List<SumSo> result = numbersService.calculateListOfResults(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void calculateListOfResults_2() {
        // given:
        List<Integer> input = List.of(1, 2);

        // when:
        List<SumSo> result = numbersService.calculateListOfResults(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(9, result.size());
    }

    @Test
    public void calculateListOfResults_3() {
        // given:
        List<Integer> input = List.of(1, 2, 3);

        // when:
        List<SumSo> result = numbersService.calculateListOfResults(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(163, result.size());
    }

    @Test
    public void calculateListOfResults_4() {
        // given:
        List<Integer> input = List.of(1, 2, 3, 4);

        // when:
        List<SumSo> result = numbersService.calculateListOfResults(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(6039, result.size());
    }

    @Test
    public void calculateListOfResults_5() {
        // given:
        List<Integer> input = List.of(1, 2, 3, 4, 5);

        // when:
        List<SumSo> result = numbersService.calculateListOfResults(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(362971, result.size());
    }

    @Disabled("Too much memory")
    @Test
    public void calculateListOfResults_6() {
        // given:
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);

        // when:
        List<SumSo> result = numbersService.calculateListOfResults(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(362971, result.size());
    }

    @Test
    public void findNumberCombination_0() {
        // given:
        List<Integer> inputNumbers = List.of();
        Integer inputTargetNumber = 1;

        // when:
        List<SumSo> result = numbersService.findNumberCombination(inputNumbers, inputTargetNumber);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void findNumberCombination_1() {
        // given:
        List<Integer> inputNumbers = List.of(1);
        Integer inputTargetNumber = 1;

        // when:
        List<SumSo> result = numbersService.findNumberCombination(inputNumbers, inputTargetNumber);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void findNumberCombination_2() {
        // given:
        List<Integer> inputNumbers = List.of(1, 2);
        Integer inputTargetNumber = 1;

        // when:
        List<SumSo> result = numbersService.findNumberCombination(inputNumbers, inputTargetNumber);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void findNumberCombination_3() {
        // given:
        List<Integer> inputNumbers = List.of(1, 2, 3);
        Integer inputTargetNumber = 1;

        // when:
        List<SumSo> result = numbersService.findNumberCombination(inputNumbers, inputTargetNumber);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(19, result.size());
    }

    @Test
    public void findNumberCombination_4() {
        // given:
        List<Integer> inputNumbers = List.of(1, 2, 3, 4);
        Integer inputTargetNumber = 1;

        // when:
        List<SumSo> result = numbersService.findNumberCombination(inputNumbers, inputTargetNumber);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(365, result.size());
    }

    @Test
    public void findNumberCombination_5() {
        // given:
        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5);
        Integer inputTargetNumber = 1;

        // when:
        List<SumSo> result = numbersService.findNumberCombination(inputNumbers, inputTargetNumber);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(14523, result.size());
    }

    @Disabled("Too much memory")
    @Test
    public void findNumberCombination_6() {
        // given:
        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer inputTargetNumber = 1;

        // when:
        List<SumSo> result = numbersService.findNumberCombination(inputNumbers, inputTargetNumber);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(14523, result.size());
    }
}
