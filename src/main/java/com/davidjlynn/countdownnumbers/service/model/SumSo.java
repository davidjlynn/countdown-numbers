package com.davidjlynn.countdownnumbers.service.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SumSo {

  private final OperationSo operation;

  private Integer total;

  // Divide by zero for example.
  private Boolean invalidSum = false;
}
