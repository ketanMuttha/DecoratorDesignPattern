package com.decorator.pattern.breaverage;

public class Chocolate implements Beverage{

    @Override
    public float getCost() {
        return 1.5f;
    }

    @Override
    public String getDescription() {
        return "Created chocolate";
    }
}
