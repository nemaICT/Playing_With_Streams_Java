package factory;

import Models.Dish;
import data.LogWriter;
import interfaces.IDish;

import interfaces.IDishCreator;
import java.util.List;

public class DishCreator implements IDishCreator {

    // data members
    private List<IDish> dishes;

    // methods
    @Override
    public List<IDish> getDishes() {return this.dishes;}

    @Override
    public void setDishesList(List<IDish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public void addDish(IDish dish) {
        this.dishes.add(dish);
    }

}
