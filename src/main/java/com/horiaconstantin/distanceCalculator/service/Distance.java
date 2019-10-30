package com.horiaconstantin.distanceCalculator.service;

import lombok.NonNull;
import lombok.Value;

/**
 * An object representing a distance.
 * Constaints: the value must be positive and the unit of measurement must be defined
 */
@Value
class Distance {
    private double value;
    private Unit unit;

}
