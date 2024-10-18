package com.davidjlynn.countdownnumbers.service;

import com.davidjlynn.countdownnumbers.service.model.operation.OperationSo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class SumGeneratorServiceTest {

    SumGeneratorService sumGeneratorService = new SumGeneratorService();

    @Test
    public void calculateListOfResults_0() {
        // given:
        List<Integer> input = List.of();

        // when:
        Set<OperationSo> result = sumGeneratorService.summifySingle(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void calculateListOfResults_1() {
        // given:
        List<Integer> input = List.of(1);

        // when:
        Set<OperationSo> result = sumGeneratorService.summifySingle(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void calculateListOfResults_2() {
        // given:
        List<Integer> input = List.of(1, 2);

        // when:
        Set<OperationSo> result = sumGeneratorService.summifySingle(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(4, result.size());
    }

    @Test
    public void calculateListOfResults_3() {
        // given:
        List<Integer> input = List.of(1, 2, 3);

        // when:
        Set<OperationSo> result = sumGeneratorService.summifySingle(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(32, result.size());
    }

    @Test
    public void calculateListOfResults_4() {
        // given:
        List<Integer> input = List.of(1, 2, 3, 4);

        // when:
        Set<OperationSo> result = sumGeneratorService.summifySingle(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(384, result.size());
    }

    @Test
    public void calculateListOfResults_5() {
        // given:
        List<Integer> input = List.of(1, 2, 3, 4, 5);

        // when:
        Set<OperationSo> result = sumGeneratorService.summifySingle(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(6144, result.size());
    }

    @Test
    public void calculateListOfResults_6() {
        // given:
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);

        // when:
        Set<OperationSo> result = sumGeneratorService.summifySingle(input);

        // then:
        Assertions.assertNotNull(result);
        Assertions.assertEquals(122880, result.size());
    }
}
