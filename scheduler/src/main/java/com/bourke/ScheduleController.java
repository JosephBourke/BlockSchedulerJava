package com.bourke;


import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;



public class ScheduleController {
    private ArrayList<String> data= new ArrayList<>();

    @FXML
    private GridPane gp;


    @FXML
    public ArrayList<String> getScheduleData() throws IOException {
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
        return data;
    }


    


}
