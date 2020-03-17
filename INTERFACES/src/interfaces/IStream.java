package interfaces;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public interface IStream {
    String getNamesOfDishesOnTheMenu() throws IOException, ClassNotFoundException;
    double getAverageCalories() throws IOException, ClassNotFoundException;
    Map<String, List<IDish>> displayDishesByGroup() throws IOException, ClassNotFoundException;
    Map<String, List<IDish>> filterDishesOnCalories() throws IOException, ClassNotFoundException;
    Map<String, Long> displayDishesTypesAndCount() throws IOException, ClassNotFoundException;
}
