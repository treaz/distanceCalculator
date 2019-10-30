package com.horiaconstantin.distanceCalculator.web;

import com.horiaconstantin.distanceCalculator.service.Distance;
import com.horiaconstantin.distanceCalculator.service.Unit;

public class DistanceCalculatorInputs {
    public double distance1Value;
    public Unit distance1Unit;
    public double distance2Value;
    public Unit distance2Unit;
    public Unit resultUnit;

    public Distance getDistance1() {
        return new Distance(distance1Value, distance1Unit);
    }

    public Distance getDistance2() {
        return new Distance(distance2Value, distance2Unit);
    }
}
