package com.davidjlynn.countdownnumbers.service.model.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NumberSo implements OperationSo {

  private int number;

  @Override
  public String getOperationString() {
    return String.valueOf(number);
  }

  @Override
  public int getTotal() {
    return number;
  }
}
