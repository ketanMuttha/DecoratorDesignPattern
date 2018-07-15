package com.decorator.pattern.breaverage;

public class Espresso implements Beverage {

    @Override
    public float getCost() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "Create espresso";
    }
}
