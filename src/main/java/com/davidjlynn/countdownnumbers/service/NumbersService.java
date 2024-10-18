package com.davidjlynn.countdownnumbers.service;

import com.davidjlynn.countdownnumbers.service.model.ChallengeSo;
import com.davidjlynn.countdownnumbers.service.model.SumSo;
import com.davidjlynn.countdownnumbers.service.model.operation.OperationSo;

import java.util.*;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NumbersService {

    public List<SumSo> findNumberCombination(ChallengeSo challenge) {
        return findNumberCombination(challenge.getAvailableNumbers(), challenge.getTargetNumber());
    }

    public List<SumSo> findNumberCombination(List<Integer> numbers, Integer targetNumber) {
        List<SumSo> sums = calculateListOfResults(numbers);

        return sums.stream()
                .filter(sum -> sum.getTotal().equals(targetNumber))
                .toList();
    }

    protected List<SumSo> calculateListOfResults(List<Integer> numbers) {
        Set<List<Integer>> numberCombinations = NumberListGeneratorService.generateNumberListIncludingSubsets(numbers);
        Set<OperationSo> operationSos = SumGeneratorService.summifySet(numberCombinations);
        return operationSos.stream()
                .map(SumSo::new)
                .peek(this::setTotal)
                .filter(sum -> !sum.getInvalidSum())
                .collect(Collectors.toList());
    }

    private void setTotal(SumSo sum) {
        try {
            sum.setTotal(sum.getOperation().getTotal());
        } catch (ArithmeticException e) {
            sum.setInvalidSum(true);
        }
    }
}
