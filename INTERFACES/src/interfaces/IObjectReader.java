package interfaces;

import java.io.IOException;
import java.util.List;

public interface IObjectReader {
    List<IDish> getList() throws IOException, ClassNotFoundException;


}
