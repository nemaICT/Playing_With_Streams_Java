package interfaces;

import java.io.IOException;
import java.util.List;

public interface ISortedDishes {

    List<IDish> sortedList() throws IOException, ClassNotFoundException;
}
