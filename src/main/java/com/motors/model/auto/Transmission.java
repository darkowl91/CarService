package com.motors.model.auto;

public enum Transmission {

    AUTO("Автомат"),
    MANUAL("Механическая"),
    COMBINED("Комбинированная");

    private String value;

    private Transmission(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
