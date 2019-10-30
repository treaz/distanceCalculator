package com.horiaconstantin.distanceCalculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DistanceTest {


    @Test
    void negativeDistanceThrowsRuntime() {
        assertThrows(RuntimeException.class, () -> new Distance(-1, Unit.YARDS));
    }

    @Test
    void negativeDistanceThrowsNull() {
        assertThrows(NullPointerException.class, () -> new Distance(1.0, null));
    }
}