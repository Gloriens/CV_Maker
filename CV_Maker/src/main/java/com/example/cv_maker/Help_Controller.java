package com.example.cv_maker;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class Help_Controller {

   @FXML
    private Button addHelp;

    @FXML
    private Button deletehelp;

    @FXML
    private Button editcvhelp;


    @FXML
    private void initialize() {
        addHelp.setOnAction(actionEvent -> helponadd());
        deletehelp.setOnAction(actionEvent -> helpondelete());
        editcvhelp.setOnAction(actionEvent -> helponEdit());
    }


    @FXML
    void helponadd() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add Button");
        alert.setHeaderText("How can I add CV?");
        alert.setContentText("To add a new CV, firstly, you should fill the blanks. \nThen you have to click the add button. After that, \nyou can see the added CV on the table.");
        alert.show();

    }

    @FXML
    void helpondelete() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Delete Button");
        alert.setHeaderText("How can I delete CV?");
        alert.setContentText("To delete a CV, you should select a row on the table and \nthen click the delete button.");
        alert.show();

    }

    @FXML
    void helponEdit(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Edit Button");
        alert.setHeaderText("How can I edit CV?");
        alert.setContentText("To edit a CV, firstly, you need select a row from the \ntable, once a row selected, the information about that CV \nis printed in the boxes on the bottom. So, you can edit \nthe information in the boxes and then click edit when \nediting is done");
        alert.show();

    }
}
