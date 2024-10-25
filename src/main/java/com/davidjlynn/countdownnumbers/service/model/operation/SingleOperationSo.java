package com.davidjlynn.countdownnumbers.service.model.operation;

public interface SingleOperationSo extends OperationSo {

    OperationSo getSubOperation1();

    OperationSo getSubOperation2();

    String getOperationSymbol();

    @Override
    default String getOperationString() {
        return String.format(
                "( %s %s %s )",
                getSubOperation1().getOperationString(),
                getOperationSymbol(),
                getSubOperation2().getOperationString());
    }
}
