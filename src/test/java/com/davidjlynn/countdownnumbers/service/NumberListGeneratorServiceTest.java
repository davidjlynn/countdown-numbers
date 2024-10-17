package com.davidjlynn.countdownnumbers.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class NumberListGeneratorServiceTest {

    private final NumberListGeneratorService numberListGeneratorService = new NumberListGeneratorService();

    @Test
    public void calculateListOfResults_0() {
        // given:
        List<Integer> input = List.of();

        // when:
        List<List<Integer>> result = numberListGeneratorService.generateNumberListAllIntegers(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void calculateListOfResults_1() {
        // given:
        List<Integer> input = List.of(1);

        // when:
        List<List<Integer>> result = numberListGeneratorService.generateNumberListAllIntegers(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void calculateListOfResults_2() {
        // given:
        List<Integer> input = List.of(1, 2);

        // when:
        List<List<Integer>> result = numberListGeneratorService.generateNumberListAllIntegers(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void calculateListOfResults_3() {
        // given:
        List<Integer> input = List.of(1, 2, 3);

        // when:
        List<List<Integer>> result = numberListGeneratorService.generateNumberListAllIntegers(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(6, result.size());
    }

    @Test
    public void calculateListOfResults_4() {
        // given:
        List<Integer> input = List.of(1, 2, 3, 4);

        // when:
        List<List<Integer>> result = numberListGeneratorService.generateNumberListAllIntegers(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(24, result.size());
    }

    @Test
    public void cutDown_0() {
        // given:
        List<Integer> input = List.of();

        // when:
        List<List<Integer>> result = numberListGeneratorService.cutDown(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void cutDown_1() {
        // given:
        List<Integer> input = List.of(1);

        // when:
        List<List<Integer>> result = numberListGeneratorService.cutDown(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void cutDown_2() {
        // given:
        List<Integer> input = List.of(1, 2);

        // when:
        List<List<Integer>> result = numberListGeneratorService.cutDown(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void cutDown_3() {
        // given:
        List<Integer> input = List.of(1, 2, 3);

        // when:
        List<List<Integer>> result = numberListGeneratorService.cutDown(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void cutDown_4() {
        // given:
        List<Integer> input = List.of(1, 2, 3, 4);

        // when:
        List<List<Integer>> result = numberListGeneratorService.cutDown(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void generateNumberListIncludingSubsets_0() {
        // given:
        List<Integer> input = List.of();

        // when:
        Set<List<Integer>> result = numberListGeneratorService.generateNumberListIncludingSubsets(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void generateNumberListIncludingSubsets_1() {
        // given:
        List<Integer> input = List.of(1);

        // when:
        Set<List<Integer>> result = numberListGeneratorService.generateNumberListIncludingSubsets(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void generateNumberListIncludingSubsets_2() {
        // given:
        List<Integer> input = List.of(1, 2);

        // when:
        Set<List<Integer>> result = numberListGeneratorService.generateNumberListIncludingSubsets(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(4, result.size());
    }

    @Test
    public void generateNumberListIncludingSubsets_3() {
        // given:
        List<Integer> input = List.of(1, 2, 3);

        // when:
        Set<List<Integer>> result = numberListGeneratorService.generateNumberListIncludingSubsets(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(15, result.size());
    }

    @Test
    public void generateNumberListIncludingSubsets_4() {
        // given:
        List<Integer> input = List.of(1, 2, 3, 4);

        // when:
        Set<List<Integer>> result = numberListGeneratorService.generateNumberListIncludingSubsets(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(64, result.size());
    }
}
