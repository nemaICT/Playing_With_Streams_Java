package Models;

import interfaces.IAverageCalories;
import interfaces.IDish;
import interfaces.IObjectReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import interfaces.ISortedDishes;

import static java.util.stream.Collectors.averagingInt;

public class SortedDishes implements ISortedDishes, IAverageCalories {

    @Override
    public List<IDish> sortedList() throws IOException, ClassNotFoundException {

        IObjectReader reader = new Reader();
        List<IDish> dishes = new ArrayList<>(reader.getList());

        return dishes.stream().sorted(Comparator.comparing(IDish::getName)).collect(Collectors.toList());

    }

    @Override
    public double getAverageCalorie() throws IOException, ClassNotFoundException {
        List<IDish> dishes = new ArrayList<>();
        IObjectReader reader = new Reader();
        dishes.addAll(reader.getList());

        double avgCalories;
        return avgCalories = (double) dishes.stream().collect(averagingInt(IDish::getCalories));
    }
}
