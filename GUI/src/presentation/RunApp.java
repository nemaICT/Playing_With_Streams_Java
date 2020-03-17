package presentation;

import Models.Dish;
import Models.DishLog;
import Models.Reader;
import Models.SortedDishes;
import factory.DishCreator;
import interfaces.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class RunApp  {

    private IDishCreator dishCreator;
    private List<IDish> menu;
    private Scanner input;
    private boolean exit;
    private List<IDish> dishes;

    public RunApp() {
        this.input = new Scanner(in);
        this.menu = new ArrayList<>();
        this.dishes = new ArrayList<>();
    }

    public void appMenu() throws Exception {

         int choice;

        do {
            out.print("\nChoose:  ");
            out.print("\n0 - Close Application\n1 - Create dish\n2 - Save dishes\n3 - Display dishes\n4 - Display sorted dishes\n5 - " +
                    "Display average calories among dishes:\n6 - Display max calories among dishes\n7 - Display dishes name's" +
                    "\n8 - Display Average amount of calories among dishes\n9 - Display dishes by group " +
                "\n10 - Display dishes categorized by calories\n11 - Display counts and types: " +
                    "\n12 - Display most caloric by type\n13 - Vegetarian dishes\n14 - List of non Vegetarian dishes\n15 - Count of non veggie dishes");

            choice = input.nextInt();
            menuSelection(choice);
        } while (choice != 0);

    }

    private void menuSelection(int choice) throws Exception {
        switch (choice) {
            case 0:
                out.println("Thank you for adding dishes to our book. You are logged out");
                exit(0);
                // create new dish
            case 1:
                createDishMenu();
                break;
            case 2:
                writeToLog();
               break;
            case 3:
                displayDishes();
                break;
            case 4:
                displaySortedDishes();
                break;
            case 5:
                getAverageCalorie();
                break;
            case 6:
                getMaxDishCalories();
                break;
            case 7:
                displayDishesNames();
                break;
            case 8:
                displayAverageNumberOfCaloriesAmongDishes();
                break;
            case 9:
               displayDishesByGrouping();
                break;
            case 10:
               displayDishesCategorizedCalories();
                break;
            case 11:
                displayCountsAndTypes();
                break;
            case 12:
               displayDishesByTypeAndCalories();
                break;
            case 13:
              vegetarianDishes();
                break;
            case 14:
                nonVegetarianDishes();
                break;
            case 15:
                countDishes();
                break;
              default:
                break;
        }
    }

    private void displaySortedDishes() throws IOException, ClassNotFoundException {

        ISortedDishes dishes = new SortedDishes();
        List<IDish> sortedList = new ArrayList<>(dishes.sortedList());
        out.println();
        sortedList.forEach(out::println);

    }

    private void displayDishes() throws IOException, ClassNotFoundException {
        IObjectReader dishes = new Reader();
        List<IDish> list = new ArrayList<>(dishes.getList());
        out.println();
        list.forEach(out::println);
    }

    private void createDishMenu()
    {
        out.print("Give name of the dish: ");
        String name = input.next();
        out.print("Is dish vegetarian? ");
        boolean veggie = input.nextBoolean();
        out.print("Number of calories: ");
        int calories = input.nextInt();
        out.print("Give type of the dish: ");
        String type = input.next();

        IDish dish = new Dish(name, veggie, calories, type);

        dishCreator = new DishCreator();
        dishCreator.setDishesList(dishes);
        dishCreator.addDish(dish);

    }

    private void writeToLog() {
        IDishLog writeLog = new DishLog();
        writeLog.setDishes(dishes);
        writeLog.write();
        out.println("List has been created!");
        }

    private void getAverageCalorie() throws IOException, ClassNotFoundException {

        IAverageCalories sortedDishes = new SortedDishes();
        String result = "The average calories among the dishes is: " +sortedDishes.getAverageCalorie() + " calories.";

        for(int i=0; i <= result.length() / 2; i++)
        {
            out.print("+-");
        }

        out.println("\n"+result);

        for(int i=0; i <= result.length() / 2; i++)
        {
            out.print("+-");
        }
        out.println("");
    }

    private void getMaxDishCalories() throws IOException, ClassNotFoundException {

        ICalculateCalories maxCalories = new Reader();
        int calories = maxCalories.getMaximumCalories();
        String result = "Maximum calories of the dishes is: " + calories;

        for(int i = 0; i <= result.length() / 2; i++)
        {
            out.print("+-");
        }
        out.println("\n" + result);
        for(int i = 0; i <= result.length() / 2; i++)
        {
            out.print("+-");
        }
    }

    private void displayDishesNames() throws IOException, ClassNotFoundException {
        IStream intStream = new Reader();

        for(int i = 0; i <= intStream.getNamesOfDishesOnTheMenu().length(); i++)
        {
            out.print("-");
        }
        out.println("\n" + intStream.getNamesOfDishesOnTheMenu());
        for(int i = 0; i <= intStream.getNamesOfDishesOnTheMenu().length(); i++)
        {
            out.print("-");
        }
    }

    private void displayAverageNumberOfCaloriesAmongDishes() throws IOException, ClassNotFoundException {
        IStream intStream = new Reader();
        double avg = intStream.getAverageCalories();
        String message = "Average calories among the dishes is: " + avg + " calories";

        for(int i = 0; i <= message.length(); i++)
        {
            out.print("-");
        }

        out.println("\n" + message);

        for(int i = 0; i <= message.length(); i++)
        {
            out.print("-");
        }
    }

    private void displayDishesByGrouping() throws IOException, ClassNotFoundException {
        IStream intStream = new Reader();
        out.println("\n"+ intStream.displayDishesByGroup());
    }

    private void displayDishesCategorizedCalories() throws IOException, ClassNotFoundException {
        IStream intStream = new Reader();
        out.println("\n" + intStream.filterDishesOnCalories());
    }

    private void displayCountsAndTypes() throws IOException, ClassNotFoundException {

        IStream intStream = new Reader();

        for(int i = 0; i <= intStream.getNamesOfDishesOnTheMenu().length() / 2; i++)
        {
            out.print("-+");;
        }
        out.println("\n" + intStream.displayDishesTypesAndCount());
        for(int i = 0; i <= intStream.getNamesOfDishesOnTheMenu().length() / 2; i++)
        {
            out.print("-+");;
        }
    }

    private void displayDishesByTypeAndCalories() throws IOException, ClassNotFoundException {
        ICalculateCalories dishesByCaloriesAndType = new Reader();
        out.println("\n" +dishesByCaloriesAndType.caloricLevelsByType());
    }

    private void vegetarianDishes() throws IOException, ClassNotFoundException {
        IVegetarian iVegetarian = new Reader();
        out.println("\n" + iVegetarian.vegetarianDishes());
    }

    private void nonVegetarianDishes
            () throws IOException, ClassNotFoundException {
        IVegetarian iVegetarian = new Reader();
        out.println("\n" + iVegetarian.nonVegetarianDishes());
    }

    private void countDishes () throws IOException, ClassNotFoundException {
        IVegetarian isVegetarian = new Reader();

        out.println("\nNumber of non vegetarians dishes:\n" + isVegetarian.countDishes().get(false));
    }
}

