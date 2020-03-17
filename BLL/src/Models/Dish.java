package Models;

import interfaces.IDish;

import java.io.Serializable;

public class Dish implements IDish, Serializable {

    // Data Members
    private  String name;
    private  boolean vegetarian;
    private  int calories;
    private  String type;

    // constructor

    public Dish(){}
    public Dish(String name, boolean vegetarian, int calories, String type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    @Override
    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish name: " + getName() + "\nIsVegetarian? " + isVegetarian() + "\nCaloric value: " + getCalories() + "\nType of dish: " + getType();
    }


}
