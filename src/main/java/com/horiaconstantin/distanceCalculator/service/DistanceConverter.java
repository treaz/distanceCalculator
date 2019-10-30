package com.horiaconstantin.distanceCalculator.service;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

/**
 * Class that converts yards to meters and meters to yards.
 * The current implementation offers precision up to 2 decimals.
 * NOTE: The implementation uses double, therefore it's going to imprecise at big distance values
 */
@UtilityClass
class DistanceConverter {

    /**
     * Converts a distance expressed in yards to meters
     * @return a distance measured in meters
     */
    Distance toMeters(@NonNull Distance distance){
        var valueInMeters = distance.getValue();
        if (Unit.YARDS == distance.getUnit()) {
            valueInMeters = distance.getValue() / 1.0936;
        }

        return new Distance(valueInMeters, Unit.METERS);
    }

    /**
     * Converts a distance expressed in meters to yards
     *
     * @return a distance measured in yards
     * @throws ArithmeticException when converting the yards to meters exceeds Double.MAX_VALUE
     */
    Distance toYards(@NonNull Distance distance) {
        var valueInYards = distance.getValue();
        if (Unit.METERS == distance.getUnit()) {
            valueInYards = distance.getValue() * 1.0936;
        }

        checkNumericOverflow(valueInYards);
        return new Distance(valueInYards, Unit.YARDS);
    }

    private static void checkNumericOverflow(Double value) {
        if (value == Double.POSITIVE_INFINITY) {
            throw new ArithmeticException("Conversion of " + value + " to desired unit failed because it cause a " +
                    "numeric overflow");
        }
    }
}
