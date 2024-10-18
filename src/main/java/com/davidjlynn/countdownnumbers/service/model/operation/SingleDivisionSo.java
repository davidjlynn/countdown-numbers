package com.davidjlynn.countdownnumbers.service.model.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SingleDivisionSo implements SingleOperationSo {

  private final OperationSo number1;
  private final OperationSo number2;

  @Override
  public String getOperationString() {
    return String.format("( %s / %s )", number1.getOperationString(), number2.getOperationString());
  }

  @Override
  public int getTotal() {
    if (number1.getTotal() % number2.getTotal() != 0) {
      throw new ArithmeticException("Decimals not tolerated.");
    }
    return number1.getTotal() / number2.getTotal();
  }
}
