package com.horiaconstantin.distanceCalculator.service;

import lombok.NonNull;
import lombok.Value;

/**
 * An valid object representing a distance (the numeric value will always be positive and the unit of measurement will be defined)
 */
@Value
public class Distance {
    private double value;
    private Unit unit;

    public Distance(double value, @NonNull Unit unit) {
        if (value < 0) {
            //TODO consider throwing a more relevant exception
            throw new RuntimeException("Distance with negative value is not accepted");
        }
        this.value = value;
        this.unit = unit;
    }
}
