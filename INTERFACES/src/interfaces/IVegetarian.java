package interfaces;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IVegetarian {
    //Map<Boolean, List<IDish>> vegetarianDishes() throws IOException, ClassNotFoundException;
    List<IDish> vegetarianDishes()throws IOException, ClassNotFoundException;
    List<IDish> nonVegetarianDishes()throws IOException, ClassNotFoundException;
//    List<IDish> dishesWithCaloriesAbove500() throws IOException, ClassNotFoundException;
    Map<Boolean, Long> countDishes() throws IOException, ClassNotFoundException;
}
