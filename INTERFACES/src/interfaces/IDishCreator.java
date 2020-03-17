package interfaces;

import java.util.List;

public interface IDishCreator {

    List<IDish> getDishes();
    void setDishesList(List<IDish> dishes);
    void addDish(IDish dish);
}
