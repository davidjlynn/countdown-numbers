package com.davidjlynn.countdownnumbers.shell;

import com.davidjlynn.countdownnumbers.service.NumbersService;
import com.davidjlynn.countdownnumbers.service.model.SumSo;
import com.davidjlynn.countdownnumbers.service.model.operation.*;
import java.util.List;
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
    List<SumSo> mockResult =
        List.of(
            new SumSo(new NumberSo(2)),
            new SumSo(new SingleSubtractionSo(new NumberSo(2), new NumberSo(2))),
            new SumSo(new SingleAdditionSo(new NumberSo(2), new NumberSo(2))),
            new SumSo(new SingleMultiplicationSo(new NumberSo(2), new NumberSo(2))),
            new SumSo(new SingleDivisionSo(new NumberSo(2), new NumberSo(2))));
    Mockito.when(numbersService.findNumberCombination(Mockito.eq(numbers), Mockito.eq(target)))
        .thenReturn(mockResult);

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
    List<SumSo> mockResult = List.of();
    Mockito.when(numbersService.findNumberCombination(Mockito.eq(numbers), Mockito.eq(target)))
        .thenReturn(mockResult);

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
    Mockito.when(numbersService.calculateFirstResult(Mockito.eq(numbers), Mockito.eq(target)))
        .thenReturn(mockResult);

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
    Mockito.when(numbersService.calculateFirstResult(Mockito.eq(numbers), Mockito.eq(target)))
        .thenReturn(null);

    // when:
    String result = commands.calculateFirstNumbers(target, numbers);

    // then:
    Assertions.assertNotNull(result);
  }
}
