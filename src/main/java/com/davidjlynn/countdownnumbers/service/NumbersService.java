package com.davidjlynn.countdownnumbers.service;

import com.davidjlynn.countdownnumbers.service.model.ChallengeSo;
import com.davidjlynn.countdownnumbers.service.model.SumSo;
import com.davidjlynn.countdownnumbers.service.model.operation.NumberSo;
import com.davidjlynn.countdownnumbers.service.model.operation.OperationSo;
import com.davidjlynn.countdownnumbers.service.model.operation.SingleAdditionSo;
import com.davidjlynn.countdownnumbers.service.model.operation.SingleDivisionSo;
import com.davidjlynn.countdownnumbers.service.model.operation.SingleMultiplicationSo;
import com.davidjlynn.countdownnumbers.service.model.operation.SingleSubtractionSo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class NumbersService {

  public Map<String, List<SumSo>> findNumberCombination(ChallengeSo challenge) {
    List<SumSo> sums = calculateListOfResults(challenge.getAvailableNumbers());

    List<SumSo> validSums =
        sums.stream().filter(sum -> sum.getTotal().equals(challenge.getTargetNumber())).toList();

    return validSums.stream()
        .collect(Collectors.groupingBy(sum -> sum.getOperation().getOperationString()));
  }

  private List<SumSo> calculateListOfResults(List<Integer> numbers) {
    return createOperations(numbers).stream()
        .map(SumSo::new)
        .peek(this::setTotal)
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
      generatedAdditions.add(new SingleAdditionSo(numbers.get(0), numbers.get(1)));
      generatedAdditions.add(new SingleSubtractionSo(numbers.get(0), numbers.get(1)));
      generatedAdditions.add(new SingleMultiplicationSo(numbers.get(0), numbers.get(1)));
      generatedAdditions.add(new SingleDivisionSo(numbers.get(0), numbers.get(1)));
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
            subAddition -> generatedAdditions.add(new SingleAdditionSo(number, subAddition)));
        subAdditions.forEach(
            subAddition -> generatedAdditions.add(new SingleSubtractionSo(number, subAddition)));
        subAdditions.forEach(
            subAddition -> generatedAdditions.add(new SingleMultiplicationSo(number, subAddition)));
        subAdditions.forEach(
            subAddition -> generatedAdditions.add(new SingleDivisionSo(number, subAddition)));
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

  //  private void simplifySum(SumSo sum){
  //    Stack<OperationSo> jis = new Stack<>();
  //
  //    OperationSo op = sum.getOperation();
  //    while (op != null) {
  //      if (op instanceof SingleOperationSo singleOperationSo) {
  //        jis.add(op);
  //        op = singleOperationSo.getNumber2();
  //      } else{
  //        op = null;
  //      }
  //    }
  //
  //
  //  }

}
