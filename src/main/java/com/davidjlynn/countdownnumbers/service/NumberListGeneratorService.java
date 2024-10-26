package com.davidjlynn.countdownnumbers.service;

import jakarta.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberListGeneratorService {

  public static List<List<Integer>> generateNumberListAllIntegers(
      @NotNull List<Integer> sourceNumbers) {
    if (sourceNumbers.isEmpty()) {
      return Collections.emptyList();
    } else if (sourceNumbers.size() == 1) {
      return List.of(sourceNumbers);
    } else {
      List<List<Integer>> result = new ArrayList<>();
      for (int i = 0; i < sourceNumbers.size(); i++) {
        Integer targetInteger = sourceNumbers.get(i);
        List<Integer> remainingIntegers = new ArrayList<>(sourceNumbers);
        remainingIntegers.remove(i);

        List<List<Integer>> subGenerations = generateNumberListAllIntegers(remainingIntegers);
        subGenerations.forEach(subGeneration -> subGeneration.addFirst(targetInteger));
        result.addAll(subGenerations);
      }
      return result;
    }
  }

  public static Set<List<Integer>> generateNumberListIncludingSubsets(
      @NotNull List<Integer> sourceNumbers) {
    List<List<Integer>> numberList = generateNumberListAllIntegers(sourceNumbers);
    List<List<Integer>> numberListDeepCopy =
        numberList.stream()
            .map(ArrayList::new)
            .map(NumberListGeneratorService::cutDown)
            .flatMap(Collection::stream)
            .toList();

    SequencedSet<List<Integer>> result = new LinkedHashSet<>();
    result.addAll(numberListDeepCopy);
    result.addAll(numberList);

    // Order the set for hopefully simpler results.
    return result.stream()
        .sorted(Comparator.comparing(List::size))
        .collect(Collectors.toCollection(LinkedHashSet::new));
  }

  public static List<List<Integer>> cutDown(List<Integer> list) {
    if (list.size() == 1) {
      return Collections.emptyList();
    }
    return IntStream.rangeClosed(1, list.size() - 1)
        .mapToObj(digits -> list.subList(0, digits))
        .toList();
  }
}
