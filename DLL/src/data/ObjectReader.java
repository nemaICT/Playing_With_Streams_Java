package data;

import interfaces.IDish;

import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import interfaces.IObjectReader;

public class ObjectReader implements IObjectReader {

    // data members
    private List<IDish> listOfDishes;
    private IDish dish;
    private String inputPath = "\\DLL\\src\\repository\\dishesTest.ser";
    private String dir = System.getProperty("user.dir");
    private String fileLocation = dir + inputPath;

    /**
     * this method returns a list of clients from a textfile
     *
     * @return
     */
    @Override
    public List<IDish> getList() {

        //deserialize the quarks.ser file
        try(
                InputStream file = new FileInputStream(fileLocation);
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput objectInput = new ObjectInputStream (buffer);
        ){
            //deserialize the List
            listOfDishes = (List<IDish>) objectInput.readObject();
          }
        catch(ClassNotFoundException | IOException ex){
           ex.printStackTrace();
        }

        return listOfDishes;
    }
}


