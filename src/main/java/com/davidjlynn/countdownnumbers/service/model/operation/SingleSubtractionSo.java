package com.davidjlynn.countdownnumbers.service.model.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SingleSubtractionSo implements SingleOperationSo {

  private final OperationSo number1;
  private final OperationSo number2;

  public SingleSubtractionSo(Integer number1, OperationSo operation2) {
    this(new NumberSo(number1), operation2);
  }

  public SingleSubtractionSo(Integer number1, Integer number2) {
    this(new NumberSo(number1), new NumberSo(number2));
  }

  @Override
  public String getOperationString() {
    return String.format("( %s - %s )", number1.getOperationString(), number2.getOperationString());
  }

  @Override
  public Integer getTotal() {
    return number1.getTotal() - number2.getTotal();
  }
}
