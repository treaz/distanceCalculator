package com.horiaconstantin.distanceCalculator.service;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

/**
 * Class that converts yards to meters and meters to yards.
 * The current implementation offers precision up to 2 decimals
 */
@UtilityClass
class DistanceConverter {

    /**
     * Convers distance expressed in yards to meters
     * @param distance when unit is unknown, defaults to meters
     * @return a distance measured in meters
     */
    Distance toMeters(@NonNull Distance distance){
        var valueInMeters = distance.getValue();
        if (Unit.YARDS == distance.getUnit()) {
            valueInMeters = distance.getValue() / 1.0936;
        }
        return new Distance(valueInMeters, Unit.METERS);
    }
}
