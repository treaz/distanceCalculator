package com.horiaconstantin.distanceCalculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DistanceConverterTest {

    @Test
    void toMeters_nullNotAllowed() {
        assertThrows(NullPointerException.class, () -> DistanceConverter.toMeters(null));
    }

    @Test
    void toMeters_distanceInMetersIsNotConverted() {
        var distance = new Distance(100, Unit.METERS);

        var actual = DistanceConverter.toMeters(distance);

        assertEquals(distance, actual);
    }

    @Test
    void toMeters_convertDistanceInYards() {
        var distance = new Distance(100, Unit.YARDS);

        var actual = DistanceConverter.toMeters(distance);

        assertEquals(91.44, actual.getValue(), 0.009);
    }

    @Test
    void toMeters_nullUnit() {
        var distance = new Distance(111, null);

        var actual = DistanceConverter.toMeters(distance);

        assertEquals(111, actual.getValue());
    }

    @Test
    void toMeters_convertDoubleMAX() {
        var distance = new Distance(Double.MAX_VALUE, Unit.YARDS);

        var actual = DistanceConverter.toMeters(distance);

        assertEquals(Double.MAX_VALUE / 1.0936, actual.getValue(), 0.009);
    }

    @Test
    void toMeters_convertDoubleMIN() {
        var distance = new Distance(Double.MIN_VALUE, Unit.YARDS);

        var actual = DistanceConverter.toMeters(distance);

        assertEquals(Double.MAX_VALUE / 1.0936, actual.getValue(), 0.009);
    }
}