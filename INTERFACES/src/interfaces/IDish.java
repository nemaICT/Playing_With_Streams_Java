package interfaces;

public interface IDish {
    void setName(String name);
    void setVegetarian(boolean vegetarian);
    void setCalories(int calories);
    void setType(String type);
    String getType();
    String getName();
    boolean isVegetarian();
    int getCalories();


}
