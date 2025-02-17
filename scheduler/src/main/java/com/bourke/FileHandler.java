package com.bourke;

import javafx.fxml.FXMLLoader;
import java.io.*;

public class FileHandler {

    


    public void SaveObject(Serializable object, String location){
        FileOutputStream file = null;
        ObjectOutputStream out = null;
        try {
            file = new FileOutputStream(location);
            out = new ObjectOutputStream(file);

            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("File Saved");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                file.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public Object LoadObject(String location){
        Object obj = null;
        FileInputStream file = null;
        ObjectInputStream in = null;
        try {
            file = new FileInputStream(location);
            in = new ObjectInputStream(file);

            obj = in.readObject();

            in.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                in.close();
                file.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return obj;

    }


}
