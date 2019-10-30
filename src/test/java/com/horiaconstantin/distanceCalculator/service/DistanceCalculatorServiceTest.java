package com.horiaconstantin.distanceCalculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.horiaconstantin.distanceCalculator.service.DistanceConverterTest.PRECISION;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceCalculatorServiceTest {

    private static final Distance ZERO_METERS = new Distance(0, Unit.METERS);
    public static final Distance TEN_METERS = new Distance(10, Unit.METERS);
    public static final Distance TEN_YARDS = new Distance(10, Unit.YARDS);
    private DistanceCalculatorService distanceCalculator;

    @BeforeEach
    void setup() {
        distanceCalculator = new DistanceCalculatorService();
    }

    @Test
    void sumOfZeros() {
        var actual = distanceCalculator.calculateSum(ZERO_METERS, ZERO_METERS, Unit.METERS);

        assertEquals(ZERO_METERS, actual);
    }

    @Test
    void sumOfMixedInMeters() {
        var actual1 = distanceCalculator.calculateSum(TEN_METERS, TEN_YARDS, Unit.METERS);
        var actual2 = distanceCalculator.calculateSum(TEN_YARDS, TEN_METERS, Unit.METERS);

        assertEquals(actual1, actual2);
        assertEquals(10 + 9.144, actual1.getValue(), PRECISION);
    }

    @Test
    void sumOfMixedInYards() {
        var actual1 = distanceCalculator.calculateSum(TEN_METERS, TEN_YARDS, Unit.YARDS);
        var actual2 = distanceCalculator.calculateSum(TEN_YARDS, TEN_METERS, Unit.YARDS);

        assertEquals(actual1, actual2);
        assertEquals(10 + DistanceConverter.toYards(TEN_METERS).getValue(), actual1.getValue(), PRECISION);
    }

    @Test
    void sumOfMetersInYards() {
        var actual1 = distanceCalculator.calculateSum(TEN_METERS, TEN_METERS, Unit.YARDS);

        assertEquals(DistanceConverter.toYards(new Distance(20, Unit.METERS)).getValue(), actual1.getValue(), PRECISION);
    }

    @Test
    void sumOfYardsToMeters() {
        var actual1 = distanceCalculator.calculateSum(TEN_YARDS, TEN_YARDS, Unit.METERS);

        assertEquals(DistanceConverter.toMeters(new Distance(20, Unit.YARDS)).getValue(), actual1.getValue(), PRECISION);
    }


}