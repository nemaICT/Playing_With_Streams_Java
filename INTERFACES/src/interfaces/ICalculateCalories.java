package interfaces;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

public interface ICalculateCalories {
    Integer getMaximumCalories() throws IOException, ClassNotFoundException;
//    Map<String, Optional<IDish>> mostCaloricByType() throws IOException, ClassNotFoundException;
//      Map<String, IDish> mostCaloricByType() throws IOException, ClassNotFoundException;
//        Map<String, Integer> mostCaloricByType() throws IOException, ClassNotFoundException;
        Map<String, HashSet<String>> caloricLevelsByType() throws IOException, ClassNotFoundException;
}
