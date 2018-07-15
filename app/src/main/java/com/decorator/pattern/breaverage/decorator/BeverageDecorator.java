package com.decorator.pattern.breaverage.decorator;

import com.decorator.pattern.breaverage.Beverage;

public abstract class BeverageDecorator implements Beverage{

    Beverage beverage;
    float basePrice=1;
    String description=" Thanks for your business with us!!";

    public BeverageDecorator(Beverage beverage){
        this.beverage=beverage;
    }

    @Override
    public float getCost() {
        return this.beverage.getCost()+basePrice;
    }

    @Override
    public String getDescription() {
        return this.getDescription()+ description;
    }
}
