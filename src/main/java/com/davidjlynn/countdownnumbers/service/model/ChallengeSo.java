package com.davidjlynn.countdownnumbers.service.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChallengeSo {

  private Integer targetNumber;

  private List<Integer> availableNumbers;
}
