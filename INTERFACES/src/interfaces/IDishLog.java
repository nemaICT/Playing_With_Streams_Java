package interfaces;

import java.util.List;

public interface IDishLog {
    void write();
    void setDishes(List<IDish> dishes);
}
