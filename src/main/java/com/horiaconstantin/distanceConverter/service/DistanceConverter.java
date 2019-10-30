package com.horiaconstantin.distanceConverter.service;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
class DistanceConverter {

    /**
     * Convers distance expressed in yards to meters
     * @return a distance measured in meters
     */
    Distance toMeters(@NonNull Distance distance){
        return distance;
    }
}
