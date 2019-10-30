package com.horiaconstantin.distanceConverter.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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