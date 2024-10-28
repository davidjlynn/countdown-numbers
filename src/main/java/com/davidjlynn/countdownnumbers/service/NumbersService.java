package com.davidjlynn.countdownnumbers.service;

import com.davidjlynn.countdownnumbers.service.model.SumSo;
import com.davidjlynn.countdownnumbers.service.model.operation.OperationSo;
import jakarta.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NumbersService {

  public SequencedSet<SumSo> findNumberCombination(List<Integer> numbers, Integer targetNumber) {
    SequencedSet<SumSo> sums = calculateListOfResults(numbers);

    return sums.stream()
        .filter(sum -> sum.getTotal().equals(targetNumber))
        .collect(Collectors.toCollection(LinkedHashSet::new));
  }

  protected SequencedSet<SumSo> calculateListOfResults(List<Integer> numbers) {
    SequencedSet<List<Integer>> numberCombinations =
        NumberListGeneratorService.generateNumberListIncludingSubsets(numbers);
    SequencedSet<OperationSo> operationSos = SumGeneratorService.summifySet(numberCombinations);
    return operationSos.stream()
        .map(SumSo::new)
        .peek(SumSo::calculateTotal)
        .filter(sum -> !sum.getInvalidSum())
        .collect(Collectors.toCollection(LinkedHashSet::new));
  }

  public @Nullable SumSo calculateFirstResult(List<Integer> numbers, Integer targetNumber) {
    SequencedSet<List<Integer>> numberCombinations =
        NumberListGeneratorService.generateNumberListIncludingSubsets(numbers);
    return SumGeneratorService.summifyFirst(numberCombinations, targetNumber);
  }
}
