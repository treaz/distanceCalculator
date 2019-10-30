package com.horiaconstantin.distanceCalculator.web;

import com.horiaconstantin.distanceCalculator.service.Distance;
import com.horiaconstantin.distanceCalculator.service.DistanceCalculatorService;
import com.horiaconstantin.distanceCalculator.service.Unit;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CalculatorController {

    private final DistanceCalculatorService calculator;

    public CalculatorController(DistanceCalculatorService calculator) {
        this.calculator = calculator;
    }

    @PostMapping("/calculate")
    public @ResponseBody
    Distance calculate(
            @RequestParam(value = "distance1Value") double d1,
            @RequestParam(value = "distance1Unit") Unit d1unit,
            @RequestParam(value = "distance2Value") double d2,
            @RequestParam(value = "distance2Unit") Unit d2unit,
            @RequestParam(value = "resultUnit") Unit resultUnit) {
//        TODO use a wrapper object
//TODO the controller should not know of the Distance object
        return calculator.calculateSum(new Distance(d1, d1unit), new Distance(d2, d2unit), resultUnit);
    }

//    TODO I would like to add a generic exception handler so I can throw to the frontend all these exceptions that can get thrown by the backend
//    I don't want to throw the stack traces to the frontend

    @InitBinder
    private void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(Unit.class, new UnitConverter());
    }
}
