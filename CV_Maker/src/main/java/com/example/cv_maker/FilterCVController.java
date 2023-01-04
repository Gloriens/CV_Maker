package com.example.cv_maker;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Collections;
import java.util.Comparator;

public class FilterCVController {

    @FXML
    private TableColumn<CV, String> addressCol;

    @FXML
    private TableColumn<CV, String> birthdayCol;

    @FXML
    private TableView<CV> cv_table;

    @FXML
    private TableColumn<CV, String> departmentCol;

    @FXML
    private TableColumn<CV, String> educationCol;

    @FXML
    private Button filteraddress;

    @FXML
    private Button filterbirthday;

    @FXML
    private Button filterdepartment;

    @FXML
    private Button filtereducation;

    @FXML
    private Button filterlanguages;

    @FXML
    private Button filtername;

    @FXML
    private Button filterpersonalab;

    @FXML
    private Button filterphone;

    @FXML
    private Button filtertag;

    @FXML
    private Button filterid;

    @FXML
    private TableColumn<CV, String> idCol;

    @FXML
    private TableColumn<CV, String> languagesCol;

    @FXML
    private TableColumn<CV, String> nameCol;

    @FXML
    private TableColumn<CV, String> personalabCol;

    @FXML
    private TableColumn<CV, String> tagCol;

    @FXML
    private TableColumn<CV, String> telnumCol;

    @FXML
    private void initialize() {  //kullan覺lam覺yor olabilir .
        filtername.setOnAction((actionEvent -> FilterName()));
        filterdepartment.setOnAction(actionEvent -> FilterDepartment());
        filtereducation.setOnAction(actionEvent -> FilterEducation());
        filterbirthday.setOnAction(actionEvent -> FilterBirthday());
        filterlanguages.setOnAction(actionEvent -> FilterLanguage());
        filterphone.setOnAction(actionEvent -> FilterPhone());
        filterid.setOnAction(actionEvent -> FilterID());
        filtertag.setOnAction(actionEvent -> FilterTag());
        filterpersonalab.setOnAction(actionEvent -> FilterPersonalab());
        filteraddress.setOnAction(actionEvent -> FilterAdress());
    }

    private void FilterAdress() {
        ObservableList<CV> currentTableData = cv_table.getItems();
        Collections.sort(currentTableData, new Comparator<CV>() {
            @Override
            public int compare(CV cv1, CV cv2) {
                return cv1.getAddress().compareTo( cv2.getAddress());}});
    }

    private void FilterPersonalab() {
        ObservableList<CV> currentTableData = cv_table.getItems();
        Collections.sort(currentTableData, new Comparator<CV>() {
            @Override
            public int compare(CV cv1, CV cv2) {
                return cv1.getPersonalab().compareTo( cv2.getPersonalab());}});
    }

    private void FilterTag() {
        ObservableList<CV> currentTableData = cv_table.getItems();
        Collections.sort(currentTableData, new Comparator<CV>() {
            @Override
            public int compare(CV cv1, CV cv2) {
                return cv1.getTag().compareTo( cv2.getTag());}});
    }

    private void FilterID() {
        ObservableList<CV> currentTableData = cv_table.getItems();
        Collections.sort(currentTableData, new Comparator<CV>() {
            @Override
            public int compare(CV cv1, CV cv2) {
                return cv1.getId().compareTo( cv2.getId());}});
    }

    private void FilterPhone() {
        ObservableList<CV> currentTableData = cv_table.getItems();
        Collections.sort(currentTableData, new Comparator<CV>() {
            @Override
            public int compare(CV cv1, CV cv2) {
                return cv1.getTelnum().compareTo( cv2.getTelnum());}});
    }

    private void FilterLanguage() {
        ObservableList<CV> currentTableData = cv_table.getItems();
        Collections.sort(currentTableData, new Comparator<CV>() {
            @Override
            public int compare(CV cv1, CV cv2) {
                return cv1.getLanguages().compareTo( cv2.getLanguages());}});
    }

    private void FilterBirthday() {
        ObservableList<CV> currentTableData = cv_table.getItems();
        Collections.sort(currentTableData, new Comparator<CV>() {
            @Override
            public int compare(CV cv1, CV cv2) {
                return cv1.getBirthday().compareTo( cv2.getBirthday());}});
    }

    private void FilterEducation() {
        ObservableList<CV> currentTableData = cv_table.getItems();
        Collections.sort(currentTableData, new Comparator<CV>() {
            @Override
            public int compare(CV cv1, CV cv2) {
                return cv1.getEducation().compareTo( cv2.getEducation());}});
    }

    private void FilterDepartment() {
        ObservableList<CV> currentTableData = cv_table.getItems();
        Collections.sort(currentTableData, new Comparator<CV>() {
            @Override
            public int compare(CV cv1, CV cv2) {
                return cv1.getDepartment().compareTo( cv2.getDepartment());}});
    }

    private void FilterName() {
        ObservableList<CV> currentTableData = cv_table.getItems();
        Collections.sort(currentTableData, new Comparator<CV>() {
            @Override
            public int compare(CV cv1, CV cv2) {
                return cv1.getName().compareTo( cv2.getName());}});






    }


}