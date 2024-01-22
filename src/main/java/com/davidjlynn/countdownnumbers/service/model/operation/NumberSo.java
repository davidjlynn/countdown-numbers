package com.davidjlynn.countdownnumbers.service.model.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NumberSo implements OperationSo {

  private Integer number;

  @Override
  public String getOperationString() {
    return number.toString();
  }

  @Override
  public Integer getTotal() {
    return number;
  }
}
