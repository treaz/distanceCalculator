package com.horiaconstantin.distanceCalculator.service;

import java.util.Arrays;

public enum Unit {
    METERS("meters"),
    YARDS("yards");


    private String value;

    Unit(String value) {
        this.value = value;
    }

    public static Unit fromValue(String value) {
        for (Unit category : values()) {
            if (category.value.equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }
}
