package Models;
import data.LogWriter;
import factory.DishCreator;
import interfaces.IDish;
import interfaces.IDishCreator;
import interfaces.ILogWriter;
import interfaces.IDishLog;

import java.util.ArrayList;
import java.util.List;

public class DishLog implements IDishLog {

    private List<IDish> dishes;

    @Override
    public void setDishes(List<IDish> dishes) {
        this.dishes = new ArrayList<>();
        this.dishes = dishes;
    }

    @Override
    public void write() {
        ILogWriter writeToLog = new LogWriter();
        writeToLog.WriteObjectToFile(this.dishes);
    }
}
