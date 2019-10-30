package com.horiaconstantin.distanceCalculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DistanceConverterTest {

    @Test
    void nullNotAllowed() {
        assertThrows(NullPointerException.class, () -> DistanceConverter.toMeters(null));
    }

    @Test
    void distanceInMetersIsNotConverted() {
        var distance = new Distance(100, Unit.METERS);

        var actual = DistanceConverter.toMeters(distance);

        assertEquals(distance, actual);
    }
}