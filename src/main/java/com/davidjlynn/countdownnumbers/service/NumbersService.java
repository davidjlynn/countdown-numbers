package com.davidjlynn.countdownnumbers.service;

import com.davidjlynn.countdownnumbers.service.model.AdditionSo;
import com.davidjlynn.countdownnumbers.service.model.ChallengeSo;
import com.davidjlynn.countdownnumbers.service.model.DivisionSo;
import com.davidjlynn.countdownnumbers.service.model.MultiplicationSo;
import com.davidjlynn.countdownnumbers.service.model.NumberSo;
import com.davidjlynn.countdownnumbers.service.model.OperationSo;
import com.davidjlynn.countdownnumbers.service.model.SubtractionSo;
import com.davidjlynn.countdownnumbers.service.model.SumSo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class NumbersService {

  public Map<String, List<SumSo>> findNumberCombination(ChallengeSo challenge) {
    List<SumSo> sums = calculateListOfResults(challenge.getAvailableNumbers());

    List<SumSo> validSums =
        sums.stream()
            .filter(sum -> sum.getTotal().equals(challenge.getTargetNumber()))
            .collect(Collectors.toList());

    return validSums.stream()
        .collect(Collectors.groupingBy(sum -> sum.getOperation().getOperationString()));
  }

  private List<SumSo> calculateListOfResults(List<Integer> numbers) {

    Stream<OperationSo> additionStream = createOperations(numbers).stream();

    Stream<OperationSo> joinedStream =
        Stream.of(/*numberStream, */ additionStream).flatMap(Function.identity());

    return joinedStream
        .map(SumSo::new)
        .peek(sum -> setTotal(sum))
        .filter(sum -> !sum.getInvalidSum())
        .collect(Collectors.toList());
  }

  private List<OperationSo> createOperations(List<Integer> numbers) {
    if (numbers.isEmpty()) {
      throw new IllegalStateException("Should never get here.");
    } else if (numbers.size() == 1) {
      return List.of(new NumberSo(numbers.get(0)));
    } else if (numbers.size() == 2) {
      List<OperationSo> generatedAdditions = new ArrayList<>();
      generatedAdditions.add(new AdditionSo(numbers.get(0), numbers.get(1)));
      generatedAdditions.add(new SubtractionSo(numbers.get(0), numbers.get(1)));
      generatedAdditions.add(new MultiplicationSo(numbers.get(0), numbers.get(1)));
      generatedAdditions.add(new DivisionSo(numbers.get(0), numbers.get(1)));
      generatedAdditions.addAll(createOperations(List.of(numbers.get(1))));
      return generatedAdditions;
    } else {
      List<OperationSo> generatedAdditions = new ArrayList<>();
      for (int i = 0; i < numbers.size(); i++) {
        Integer number = numbers.get(i);
        List<Integer> numbersCopy = new ArrayList<>(numbers);
        numbersCopy.remove(number);
        List<OperationSo> subAdditions = createOperations(numbersCopy);
        subAdditions.forEach(
            subAddition -> generatedAdditions.add(new AdditionSo(number, subAddition)));
        subAdditions.forEach(
            subAddition -> generatedAdditions.add(new SubtractionSo(number, subAddition)));
        subAdditions.forEach(
            subAddition -> generatedAdditions.add(new MultiplicationSo(number, subAddition)));
        subAdditions.forEach(
            subAddition -> generatedAdditions.add(new DivisionSo(number, subAddition)));
        generatedAdditions.addAll(subAdditions);
      }
      return generatedAdditions;
    }
  }

  private void setTotal(SumSo sum) {
    try {
      sum.setTotal(sum.getOperation().getTotal());
    } catch (ArithmeticException e) {
      sum.setInvalidSum(true);
    }
  }
}
