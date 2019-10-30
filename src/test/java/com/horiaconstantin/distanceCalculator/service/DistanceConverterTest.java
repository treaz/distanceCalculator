package com.horiaconstantin.distanceCalculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DistanceConverterTest {
    public static final double PRECISION = 1e-2;

    @Test
    void toMeters_nullNotAllowed() {
        assertThrows(NullPointerException.class, () -> DistanceConverter.toMeters(null));
    }

    @Test
    void toMeters_metersStayTheSame() {
        var distance = new Distance(100, Unit.METERS);

        var actual = DistanceConverter.toMeters(distance);

        assertEquals(distance, actual);
    }

    @Test
    void toMeters_convertDistanceInYards() {
        var distance = new Distance(100, Unit.YARDS);

        var actual = DistanceConverter.toMeters(distance);

        assertEquals(91.44, actual.getValue(), PRECISION);
    }

    @Test
    void toMeters_convertDoubleMAX() {
        var distance = new Distance(Double.MAX_VALUE, Unit.YARDS);

        var actual = DistanceConverter.toMeters(distance);

        assertEquals(Double.MAX_VALUE / 1.0936, actual.getValue(), PRECISION);
    }

    @Test
    void toYards_nullNotAllowed() {
        assertThrows(NullPointerException.class, () -> DistanceConverter.toYards(null));
    }

    @Test
    void toYards_yardsStayTheSame() {
        var distance = new Distance(100, Unit.YARDS);

        var actual = DistanceConverter.toYards(distance);

        assertEquals(distance, actual);
    }

    @Test
    void toYards_convertDistanceInMeters() {
        var distance = new Distance(100, Unit.METERS);

        var actual = DistanceConverter.toYards(distance);

        assertEquals(109.35, actual.getValue(), PRECISION);
    }

    @Test
    void toYards_convertDoubleMAX() {
        var distance = new Distance(Double.MAX_VALUE, Unit.METERS);

        assertThrows(ArithmeticException.class, () -> DistanceConverter.toYards(distance));
    }
}