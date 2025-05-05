package com.davidjlynn.countdownnumbers.service;

import jakarta.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberListGeneratorService {

  public static SequencedSet<List<Integer>> generateNumberListIncludingSubsets(
      @NotNull List<Integer> sourceNumbers) {
    SequencedSet<List<Integer>> numberList = generateNumberListAllIntegers(sourceNumbers);
    SequencedSet<List<Integer>> numberListDeepCopy =
        numberList.stream()
            .map(ArrayList::new)
            .map(NumberListGeneratorService::cutDown)
            .flatMap(Collection::stream)
            .collect(Collectors.toCollection(LinkedHashSet::new));

    SequencedSet<List<Integer>> result = new LinkedHashSet<>();
    result.addAll(numberListDeepCopy);
    result.addAll(numberList);

    // Order the set for hopefully simpler results.
    return result.stream()
        .sorted(Comparator.comparing(List::size))
        .collect(Collectors.toCollection(LinkedHashSet::new));
  }

  public static SequencedSet<List<Integer>> generateNumberListAllIntegers(
      @NotNull List<Integer> sourceNumbers) {
    if (sourceNumbers.isEmpty()) {
      return new LinkedHashSet<>();
    } else if (sourceNumbers.size() == 1) {
      SequencedSet<List<Integer>> result = new LinkedHashSet<>();
      result.add(sourceNumbers);
      return result;
    } else {
      SequencedSet<List<Integer>> result = new LinkedHashSet<>();
      for (int i = 0; i < sourceNumbers.size(); i++) {
        Integer targetInteger = sourceNumbers.get(i);
        List<Integer> remainingIntegers = new ArrayList<>(sourceNumbers);
        remainingIntegers.remove(i);

        SequencedSet<List<Integer>> subGenerations =
            generateNumberListAllIntegers(remainingIntegers);
        subGenerations.forEach(subGeneration -> subGeneration.addFirst(targetInteger));
        result.addAll(subGenerations);
      }
      return result;
    }
  }

  public static SequencedSet<List<Integer>> cutDown(List<Integer> list) {
    if (list.size() == 1) {
      return new LinkedHashSet<>();
    }
    return IntStream.rangeClosed(1, list.size() - 1)
        .mapToObj(digits -> list.subList(0, digits))
        .collect(Collectors.toCollection(LinkedHashSet::new));
  }
}
