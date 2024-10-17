//package com.davidjlynn.countdownnumbers.service.model.operation;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//
//@Getter
//@AllArgsConstructor
//public class MultipleAdditionSo implements MultipleOperationSo {
//
//  private final Set<OperationSo> numbers;
//
//  @Override
//  public String getOperationString() {
//    return String.format(
//        "( %s )",
//        numbers.stream().map(OperationSo::getOperationString).collect(Collectors.joining(" + ")));
//  }
//
//  @Override
//  public Integer getTotal() {
//    return numbers.stream().map(OperationSo::getTotal).reduce(0, Integer::sum);
//  }
//}
