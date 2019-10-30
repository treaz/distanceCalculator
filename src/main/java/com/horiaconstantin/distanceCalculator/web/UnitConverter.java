package com.horiaconstantin.distanceCalculator.web;

import com.horiaconstantin.distanceCalculator.service.Unit;

import java.beans.PropertyEditorSupport;

public class UnitConverter extends PropertyEditorSupport {

    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(Unit.fromValue(text));
    }

}
