package com.decorator.pattern.breaverage.decorator;

import com.decorator.pattern.breaverage.Beverage;

public class SugarDecorator extends BeverageDecorator {

    Beverage beverage;

    public SugarDecorator(Beverage beverage) {
        super(beverage);
        this.beverage = beverage;
    }

    @Override
    public float getCost() {
        return this.beverage.getCost() + 1;
    }

    @Override
    public String getDescription() {
        return this.getDescription() + "chocolate Added ";
    }
}
