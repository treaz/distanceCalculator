package com.horiaconstantin.distanceCalculator.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class DistanceCalculatorService {

    public Distance calculateSum(@NonNull Distance d1, @NonNull Distance d2, @NonNull Unit resultUnit) {
        Distance result;
        if (resultUnit == Unit.YARDS) {
            Distance d1inY = DistanceConverter.toYards(d1);
            Distance d2iny = DistanceConverter.toYards(d2);
            result = new Distance(d1inY.getValue() + d2iny.getValue(), Unit.YARDS);
        } else {
            Distance d1inM = DistanceConverter.toMeters(d1);
            Distance d2inM = DistanceConverter.toMeters(d2);
            result = new Distance(d1inM.getValue() + d2inM.getValue(), Unit.METERS);
        }
        return result;
    }

}
