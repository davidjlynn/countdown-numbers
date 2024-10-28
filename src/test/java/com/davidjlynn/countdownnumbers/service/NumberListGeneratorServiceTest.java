package com.davidjlynn.countdownnumbers.service;

import java.util.List;
import java.util.SequencedSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberListGeneratorServiceTest {

  @Test
  void calculateListOfResults_0() {
    // given:
    List<Integer> input = List.of();

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListAllIntegers(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(0, result.size());
  }

  @Test
  void calculateListOfResults_1() {
    // given:
    List<Integer> input = List.of(1);

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListAllIntegers(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(1, result.size());
  }

  @Test
  void calculateListOfResults_2() {
    // given:
    List<Integer> input = List.of(1, 2);

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListAllIntegers(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(2, result.size());
  }

  @Test
  void calculateListOfResults_3() {
    // given:
    List<Integer> input = List.of(1, 2, 3);

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListAllIntegers(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(6, result.size());
  }

  @Test
  void calculateListOfResults_4() {
    // given:
    List<Integer> input = List.of(1, 2, 3, 4);

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListAllIntegers(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(24, result.size());
  }

  @Test
  void calculateListOfResults_5() {
    // given:
    List<Integer> input = List.of(1, 2, 3, 4, 5);

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListAllIntegers(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(120, result.size());
  }

  @Test
  void calculateListOfResults_6() {
    // given:
    List<Integer> input = List.of(1, 2, 3, 4, 5, 6);

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListAllIntegers(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(720, result.size());
  }

  @Test
  void cutDown_0() {
    // given:
    List<Integer> input = List.of();

    // when:
    SequencedSet<List<Integer>> result = NumberListGeneratorService.cutDown(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(0, result.size());
  }

  @Test
  void cutDown_1() {
    // given:
    List<Integer> input = List.of(1);

    // when:
    SequencedSet<List<Integer>> result = NumberListGeneratorService.cutDown(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(0, result.size());
  }

  @Test
  void cutDown_2() {
    // given:
    List<Integer> input = List.of(1, 2);

    // when:
    SequencedSet<List<Integer>> result = NumberListGeneratorService.cutDown(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(1, result.size());
  }

  @Test
  void cutDown_3() {
    // given:
    List<Integer> input = List.of(1, 2, 3);

    // when:
    SequencedSet<List<Integer>> result = NumberListGeneratorService.cutDown(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(2, result.size());
  }

  @Test
  void cutDown_4() {
    // given:
    List<Integer> input = List.of(1, 2, 3, 4);

    // when:
    SequencedSet<List<Integer>> result = NumberListGeneratorService.cutDown(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(3, result.size());
  }

  @Test
  void cutDown_5() {
    // given:
    List<Integer> input = List.of(1, 2, 3, 4, 5);

    // when:
    SequencedSet<List<Integer>> result = NumberListGeneratorService.cutDown(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(4, result.size());
  }

  @Test
  void cutDown_6() {
    // given:
    List<Integer> input = List.of(1, 2, 3, 4, 5, 6);

    // when:
    SequencedSet<List<Integer>> result = NumberListGeneratorService.cutDown(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(5, result.size());
  }

  @Test
  void generateNumberListIncludingSubsets_0() {
    // given:
    List<Integer> input = List.of();

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListIncludingSubsets(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(0, result.size());
  }

  @Test
  void generateNumberListIncludingSubsets_1() {
    // given:
    List<Integer> input = List.of(1);

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListIncludingSubsets(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(1, result.size());
  }

  @Test
  void generateNumberListIncludingSubsets_2() {
    // given:
    List<Integer> input = List.of(1, 2);

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListIncludingSubsets(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(4, result.size());
  }

  @Test
  void generateNumberListIncludingSubsets_3() {
    // given:
    List<Integer> input = List.of(1, 2, 3);

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListIncludingSubsets(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(15, result.size());
  }

  @Test
  void generateNumberListIncludingSubsets_4() {
    // given:
    List<Integer> input = List.of(1, 2, 3, 4);

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListIncludingSubsets(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(64, result.size());
  }

  @Test
  void generateNumberListIncludingSubsets_5() {
    // given:
    List<Integer> input = List.of(1, 2, 3, 4, 5);

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListIncludingSubsets(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(325, result.size());
  }

  @Test
  void generateNumberListIncludingSubsets_6() {
    // given:
    List<Integer> input = List.of(1, 2, 3, 4, 5, 6);

    // when:
    SequencedSet<List<Integer>> result =
        NumberListGeneratorService.generateNumberListIncludingSubsets(input);

    // then:
    Assertions.assertNotNull(result);
    Assertions.assertEquals(1956, result.size());
  }
}
