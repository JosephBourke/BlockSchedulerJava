package com.bourke;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;



public class ScheduleController implements Initializable {
    private ArrayList<String> data= new ArrayList<>();

    @FXML
    private GridPane gp;


    @FXML
    public void saveScheduleData() {
        data = new ArrayList<>();
        ObservableList<Node> list = gp.getChildren();


        for (Node node : list) {
            if(node instanceof TextArea){
                TextArea ta = (TextArea) node;
                data.add(ta.getText());                
            }
        }

        FileHandler fh = new FileHandler();
        fh.SaveObject(data, Constants.saveLocation);
        System.out.println(data);
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        FileHandler fh = new FileHandler();
        ArrayList<String> slist = (ArrayList<String>)fh.LoadObject(Constants.saveLocation);

        ObservableList<Node> nlist = gp.getChildren();

        int index = 0;
        for (Node node : nlist) {
            if(node instanceof TextArea){
                TextArea ta = (TextArea) node;
                ta.setText(slist.get(index));
                index++;
            }
        }

    }


    
    


}
