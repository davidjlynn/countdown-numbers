package com.davidjlynn.countdownnumbers.service;

import com.davidjlynn.countdownnumbers.service.model.SumSo;
import com.davidjlynn.countdownnumbers.service.model.operation.*;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SumGeneratorService {

  public static SumSo summifyFirst(Set<List<Integer>> input, Integer targetNumber) {
    return input.stream()
        .map(SumGeneratorService::summifySingle)
        .flatMap(Collection::stream)
        .map(SumSo::new)
        .peek(SumSo::calculateTotal)
        .filter(sum -> !sum.getInvalidSum())
        .filter(sum -> sum.getTotal().equals(targetNumber))
        .findFirst()
        .orElse(null);
  }

  public static Set<OperationSo> summifySet(Set<List<Integer>> input) {
    return input.stream()
        .map(SumGeneratorService::summifySingle)
        .flatMap(Collection::stream)
        .collect(Collectors.toSet());
  }

  public static Set<OperationSo> summifySingle(List<Integer> input) {
    return summifyOperation(input.stream().map(NumberSo::new).collect(Collectors.toList()));
  }

  public static Set<OperationSo> summifyOperation(List<OperationSo> input) {
    Set<OperationSo> results = new HashSet<>();
    if (input.size() == 1) {
      results.add(input.getFirst());
    } else if (input.size() == 2) {
      results.add(new SingleAdditionSo(input.get(0), input.get(1)));
      results.add(new SingleSubtractionSo(input.get(0), input.get(1)));
      results.add(new SingleMultiplicationSo(input.get(0), input.get(1)));
      results.add(new SingleDivisionSo(input.get(0), input.get(1)));
    } else if (input.size() > 2) {
      IntStream.rangeClosed(1, input.size() - 1)
          .forEach(number -> results.addAll(applyPair(input, number)));
    }
    return results;
  }

  public static Set<OperationSo> applyPair(List<OperationSo> input, Integer joinPair) {
    Set<OperationSo> result = new HashSet<>();
    result.addAll(applyPair(input, joinPair, SingleAdditionSo::new));
    result.addAll(applyPair(input, joinPair, SingleSubtractionSo::new));
    result.addAll(applyPair(input, joinPair, SingleMultiplicationSo::new));
    result.addAll(applyPair(input, joinPair, SingleDivisionSo::new));
    return result;
  }

  public static Set<OperationSo> applyPair(
      List<OperationSo> input, Integer joinPair, BinaryOperator<OperationSo> creator) {
    if (!(joinPair < input.size() && joinPair > 0)) {
      throw new IllegalArgumentException();
    }
    List<OperationSo> copy = new ArrayList<>(input);
    OperationSo firstOp = copy.get(joinPair - 1);
    OperationSo secondOp = copy.get(joinPair);
    OperationSo resultOp = creator.apply(firstOp, secondOp);
    copy.remove(joinPair.intValue());
    copy.remove(joinPair - 1);
    copy.add(joinPair - 1, resultOp);

    return summifyOperation(copy);
  }
}
