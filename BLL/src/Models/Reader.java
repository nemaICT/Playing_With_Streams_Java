package Models;

import data.FileReader;
import data.ObjectReader;
import interfaces.*;

import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.*;

public class Reader implements IFileReader, IObjectReader, ICalculateCalories, IStream, IVegetarian{

    private IFileReader readFile;

    @Override
    public String readTextFile() {
        readFile = new FileReader();
       return readFile.readTextFile();
    }

    @Override
    public List<IDish> getList() throws IOException, ClassNotFoundException {
        IObjectReader objectReader = new ObjectReader();
        List<IDish> dishes = new ArrayList<>(objectReader.getList());
        // uses constructor injection
        return new ArrayList<>(dishes);
    }

    public Integer getMaximumCalories() throws IOException, ClassNotFoundException {

        IObjectReader objectReader = new ObjectReader();
        List<IDish> dishes = new ArrayList<>(objectReader.getList());

        // get the sum of calories among the dishe's using the mapToInt and sum method from the stream class
        return dishes.stream().mapToInt(IDish::getCalories).sum();

    }

    public String getNamesOfDishesOnTheMenu() throws IOException, ClassNotFoundException {

        IObjectReader objectReader = new ObjectReader();
        List<IDish> dishes = new ArrayList<>(objectReader.getList());

        // Return a string representation on the dishe's name's using the joining method from the collectors class setting a delimiter between each name
        return dishes.stream().map(IDish::getName).collect(joining(", "));
    }

    @Override
    public double getAverageCalories() throws IOException, ClassNotFoundException {
        IObjectReader objectReader = new ObjectReader();
        List<IDish> dishes = new ArrayList<>(objectReader.getList());

        // Calculate the average calories among the dishes using the averagingInt method in the Collectors class
       return  (double) dishes.stream().collect(averagingInt(IDish::getCalories));

    }

    public Map<String, List<IDish>> displayDishesByGroup() throws IOException, ClassNotFoundException {

        IObjectReader objectReader = new ObjectReader();
        List<IDish> dishes = new ArrayList<>(objectReader.getList());

        /*
         * The result of this grouping operation is a Map having as
         * map key the value returned by the classification function and as corresponding map value a list
         * of all the items in the stream having that classified value. In the menu-classification example a
         * key is the type of dish, and its value is a list containing all the dishes of that type.
         */
//        Map<String , List<IDish>> dishesByType =
         return  dishes.stream().collect(groupingBy(IDish::getType));

//        return  dishesByType;
    }

    @Override
    public Map<String, List<IDish>> filterDishesOnCalories() throws IOException, ClassNotFoundException {
        IObjectReader objectReader = new ObjectReader();
        List<IDish> dishes = new ArrayList<>(objectReader.getList());

        Map<String, List<IDish>> dishesByCaloricLevel = dishes.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return dish.getName();
                    else if (dish.getCalories() <= 700) return dish.getName();
                    else return dish.getName();
                } ));
        return dishesByCaloricLevel;
    }

    @Override
    public Map<String, Long> displayDishesTypesAndCount() throws IOException, ClassNotFoundException {

        IObjectReader objectReader = new ObjectReader();
        List<IDish> dishes = new ArrayList<>(objectReader.getList());
        return dishes.stream().collect(
                groupingBy(IDish::getType, counting()));

    }

    @Override
//    public Map<String, IDish> mostCaloricByType() throws IOException, ClassNotFoundException{
//      public Map<String, Integer> mostCaloricByType() throws IOException, ClassNotFoundException{
      public Map<String, HashSet<String>> caloricLevelsByType() throws IOException, ClassNotFoundException {

        IObjectReader objectReader = new ObjectReader();
        List<IDish> dishes = new ArrayList<>(objectReader.getList());

        /*
        * This factory method takes two arguments, the collector to be adapted and a transformation
            function, and returns another collector. This additional collector acts as a wrapper for the old
            one and maps the value it returns using the transformation function as the last step of the collect
            operation. In this case, the wrapped collector is the one created with maxBy, and the
            transformation function, Optional::get, extracts the value contained in the Optional returned. As
            we’ve said, here this is safe because the reducing collector will never return an Optional.empty().
        * */
//        return dishes.stream().collect(groupingBy(IDish::getType,collectingAndThen(maxBy(comparingInt(IDish::getCalories)), Optional::get)));
//        return  dishes.stream().collect(groupingBy(IDish::getType,summingInt(IDish::getCalories)));
       return dishes.stream().collect(
                groupingBy(IDish::getType, mapping(
                        dish -> { if (dish.getCalories() <= 400) return "Low Calories";
                        else if (dish.getCalories() <= 700) return "Normal Calories";
                        else return "Lots of calories"; },
                        toCollection(HashSet::new) )));
    }


    @Override
//    public  Map<Boolean, List<IDish>> vegetarianDishes()throws IOException, ClassNotFoundException {
    public List<IDish> vegetarianDishes()throws IOException, ClassNotFoundException
    {
        IObjectReader objectReader = new ObjectReader();
        List<IDish> dishes = new ArrayList<>(objectReader.getList());

        /* Here we return all the dishes available classifying which one is vegetarian or not returning a true or false value*/
        Map<Boolean, List<IDish>> partitionedMenu = dishes.stream().collect(partitioningBy(IDish::isVegetarian));
        return partitionedMenu.get(true);

        /*
        * here we filter the result returning only the vegetarian meals
        * */
       // return dishes.stream().filter(IDish::isVegetarian).collect(toList());

    }

    @Override
    public List<IDish> nonVegetarianDishes() throws IOException, ClassNotFoundException {

        IObjectReader objectReader = new ObjectReader();
        List<IDish> dishes = new ArrayList<>(objectReader.getList());

        /* Here we return all the dishes available classifying which one is vegetarian or not returning a true or false value*/
        Map<Boolean, List<IDish>> partitionedMenu = dishes.stream().collect(partitioningBy(IDish::isVegetarian));
        return partitionedMenu.get(false);
    }

    // this method return the count of veggie dishes inside the list
    @Override
    public Map<Boolean, Long> countDishes() throws IOException, ClassNotFoundException {

        IObjectReader objectReader = new ObjectReader();
        List<IDish> dishes = new ArrayList<>(objectReader.getList());

       return dishes.stream().collect(partitioningBy(IDish::isVegetarian,counting()));
    }
}
