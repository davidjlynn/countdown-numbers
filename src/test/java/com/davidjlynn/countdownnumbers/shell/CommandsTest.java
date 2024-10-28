package com.davidjlynn.countdownnumbers.shell;

import com.davidjlynn.countdownnumbers.service.NumbersService;
import com.davidjlynn.countdownnumbers.service.model.SumSo;
import com.davidjlynn.countdownnumbers.service.model.operation.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommandsTest {

  private final NumbersService numbersService = Mockito.mock(NumbersService.class);

  private final Commands commands = new Commands(numbersService);

  @Test
  void calculateNumbers_results() {
    // given:
    Integer target = 3;
    List<Integer> numbers = List.of();

    // and:
    SequencedSet<SumSo> mockResult = new LinkedHashSet<>();
    mockResult.add(new SumSo(new NumberSo(2)));
    mockResult.add(new SumSo(new SingleSubtractionSo(new NumberSo(2), new NumberSo(2))));
    mockResult.add(new SumSo(new SingleAdditionSo(new NumberSo(2), new NumberSo(2))));
    mockResult.add(new SumSo(new SingleMultiplicationSo(new NumberSo(2), new NumberSo(2))));
    mockResult.add(new SumSo(new SingleDivisionSo(new NumberSo(2), new NumberSo(2))));
    Mockito.when(numbersService.findNumberCombination(numbers, target)).thenReturn(mockResult);

    // when:
    String result = commands.calculateNumbers(target, numbers);

    // then:
    Assertions.assertNotNull(result);
  }

  @Test
  void calculateNumbers_noResults() {
    // given:
    Integer target = 3;
    List<Integer> numbers = List.of();

    // and:
    SequencedSet<SumSo> mockResult = new LinkedHashSet<>();
    Mockito.when(numbersService.findNumberCombination(numbers, target)).thenReturn(mockResult);

    // when:
    String result = commands.calculateNumbers(target, numbers);

    // then:
    Assertions.assertNotNull(result);
  }

  @Test
  void calculateFirstNumbers_results() {
    // given:
    Integer target = 3;
    List<Integer> numbers = List.of();

    // and:
    SumSo mockResult = new SumSo(new NumberSo(2));
    Mockito.when(numbersService.calculateFirstResult(numbers, target)).thenReturn(mockResult);

    // when:
    String result = commands.calculateFirstNumbers(target, numbers);

    // then:
    Assertions.assertNotNull(result);
  }

  @Test
  void calculateFirstNumbers_noResults() {
    // given:
    Integer target = 3;
    List<Integer> numbers = List.of();

    // and:
    Mockito.when(numbersService.calculateFirstResult(numbers, target)).thenReturn(null);

    // when:
    String result = commands.calculateFirstNumbers(target, numbers);

    // then:
    Assertions.assertNotNull(result);
  }
}
