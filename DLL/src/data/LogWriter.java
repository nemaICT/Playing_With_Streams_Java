package data;

import interfaces.IDish;
import interfaces.ILogWriter;

import java.io.*;
import java.util.List;


public class LogWriter implements ILogWriter {
    // data members
    private String dir = System.getProperty("user.dir");
    private String filePath = "\\DLL\\src\\repository\\dishesTest.ser";
    private String fileLocation = dir + filePath;



    @Override
    public void WriteObjectToFile(List<IDish> dishes) {
        //serialize the List
        try (
                OutputStream file = new FileOutputStream(fileLocation, true);
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer);
        ){
            output.writeObject(dishes);
        }
        catch(IOException ex){
           ex.printStackTrace();
        }
    }

}
