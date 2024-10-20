package com.davidjlynn.countdownnumbers.service;

import com.davidjlynn.countdownnumbers.service.model.SumSo;
import com.davidjlynn.countdownnumbers.service.model.operation.OperationSo;

import java.util.*;
import java.util.stream.Collectors;

import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NumbersService {

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
                .peek(SumSo::calculateTotal)
                .filter(sum -> !sum.getInvalidSum())
                .collect(Collectors.toList());
    }

    public @Nullable SumSo calculateFirstResult(List<Integer> numbers, Integer targetNumber) {
        Set<List<Integer>> numberCombinations = NumberListGeneratorService.generateNumberListIncludingSubsets(numbers);
        return SumGeneratorService.summifyFirst(numberCombinations, targetNumber);
    }
}
