package com.davidjlynn.countdownnumbers.shell;

import com.davidjlynn.countdownnumbers.service.NumbersService;
import com.davidjlynn.countdownnumbers.service.model.SumSo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.shell.command.CommandRegistration.OptionArity;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.stereotype.Component;

@Command
@Component
@AllArgsConstructor
public class Commands {

  private NumbersService numbersService;

  @Command(command = "calculate-numbers")
  public String calculateNumbers(
      @Option(arity = OptionArity.EXACTLY_ONE) Integer target,
      @Option(arityMin = 1, arityMax = 6) List<Integer> numbers) {
    List<SumSo> sums = numbersService.findNumberCombination(numbers, target);
    StringBuilder stringBuilder = new StringBuilder();
    if (sums.isEmpty()) {
      stringBuilder.append("No matching results were found");
    } else {
      stringBuilder
          .append(sums.size())
          .append(" matching results was found")
          .append(System.lineSeparator())
          .append(System.lineSeparator());

      sums.forEach(
          sum ->
              stringBuilder
                  .append(sum.getOperation().getOperationString())
                  .append(System.lineSeparator()));

      stringBuilder
          .append(System.lineSeparator())
          .append(System.lineSeparator())
          .append(sums.size())
          .append(" matching results was found");
    }

    return stringBuilder.toString();
  }

  @Command(command = "calculate-first-numbers")
  public String calculateFirstNumbers(
      @Option(arity = OptionArity.EXACTLY_ONE) Integer target,
      @Option(arityMin = 1, arityMax = 6) List<Integer> numbers) {
    SumSo sum = numbersService.calculateFirstResult(numbers, target);
    StringBuilder stringBuilder = new StringBuilder();
    if (sum == null) {
      stringBuilder.append("No matching results were found");
    } else {
      stringBuilder
          .append("A matching result was found")
          .append(System.lineSeparator())
          .append(System.lineSeparator());

      stringBuilder.append(sum.getOperation().getOperationString());
    }

    return stringBuilder.toString();
  }
}
