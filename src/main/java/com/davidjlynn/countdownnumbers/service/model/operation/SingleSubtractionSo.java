package com.davidjlynn.countdownnumbers.service.model.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SingleSubtractionSo implements SingleOperationSo {

    private final OperationSo subOperation1;
    private final OperationSo subOperation2;

    @Override
    public String getOperationSymbol() {
        return "-";
    }

    @Override
    public int getTotal() {
        return subOperation1.getTotal() - subOperation2.getTotal();
    }
}
