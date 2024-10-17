package com.davidjlynn.countdownnumbers.service;

import com.davidjlynn.countdownnumbers.service.model.ChallengeSo;
import com.davidjlynn.countdownnumbers.service.model.SumSo;
import com.davidjlynn.countdownnumbers.service.model.operation.NumberSo;
import com.davidjlynn.countdownnumbers.service.model.operation.OperationSo;
import com.davidjlynn.countdownnumbers.service.model.operation.SingleAdditionSo;
import com.davidjlynn.countdownnumbers.service.model.operation.SingleDivisionSo;
import com.davidjlynn.countdownnumbers.service.model.operation.SingleMultiplicationSo;
import com.davidjlynn.countdownnumbers.service.model.operation.SingleSubtractionSo;

import java.util.*;
import java.util.stream.Collectors;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NumbersService {

    public Map<String, List<SumSo>> findNumberCombination(ChallengeSo challenge) {
        List<SumSo> sums = calculateListOfResults(challenge.getAvailableNumbers());

        List<SumSo> validSums =
                sums.stream()
                        .filter(sum -> sum.getTotal().equals(challenge.getTargetNumber()))
                        .toList();

        return validSums.stream()
                .collect(Collectors.groupingBy(sum -> sum.getOperation().getOperationString()));
    }

    protected List<SumSo> calculateListOfResults(List<Integer> numbers) {
        Set<List<Integer>> numberCombinations = NumberListGeneratorService.generateNumberListIncludingSubsets(numbers);
        Set<OperationSo> operationSos = SumGeneratorService.summifySet(numberCombinations);
        return operationSos.stream()
                .map(SumSo::new)
                .peek(this::setTotal)
                .filter(sum -> !sum.getInvalidSum())
                .peek(sum -> log.info(sum.getOperation().getOperationString()))
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
