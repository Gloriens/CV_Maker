package com.example.cv_maker;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class CV_MakerController implements Initializable {

    public CV_MakerController(){
        System.out.println();
    }
    @FXML
    private Button createCVButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button editButton;
    @FXML
    private Button listButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button exitButton;

    @FXML
    private Pane pane;

    public TableView<CV> getCv_table() {
        return cv_table;
    }

    public void setCv_table(TableView<CV> cv_table) {
        this.cv_table = cv_table;
    }

    @FXML
    private TableView<CV> cv_table;
    @FXML
    private TableColumn<CV, String> addressCol;
    @FXML
    private Text address_selected;
    @FXML
    private TextField address_selected_txtf;
    @FXML
    private TableColumn<CV, String> birthdayCol;
    @FXML
    private Text birthday_selected;
    @FXML
    private TextField birthday_selected_txtf;
    @FXML
    private TableColumn<CV, String> departmentCol;
    @FXML
    private Text department_selected;
    @FXML
    private TextField department_selected_txtf;
    @FXML
    private TableColumn<CV, String> educationCol;
    @FXML
    private Text education_selected;
    @FXML
    private TextField education_selected_txtf;
    @FXML
    private TableColumn<CV, String> languagesCol;
    @FXML
    private Text languages_selected;
    @FXML
    private TextField languages_selected_txtf;
    @FXML
    private TableColumn<CV, String> nameCol;
    @FXML
    private Text name_selected;
    @FXML
    private TextField name_selected_txtf;
    @FXML
    private TableColumn<CV, String> personalabCol;
    @FXML
    private Text personalab_selected;
    @FXML
    private TextField personalab_selected_txtf;
    @FXML
    private TableColumn<CV, String> tagCol;
    @FXML
    private Text tag_selected;
    @FXML
    private TextField tag_selected_txtf;
    @FXML
    private TableColumn<CV, String> telnumCol;
    @FXML
    private Text telnum_selected;
    @FXML
    private TextField telnum_selected_txtf;
    @FXML
    private TableColumn<CV, String> idCol;
    @FXML
    private Text id_selected;
    @FXML
    private Button addButton;


    @FXML
    private TextField id_selected_txtf;



    public void initialize(URL location, ResourceBundle resources){
        CV_Database connectNow = new CV_Database();
        Connection connectDB = connectNow.getDBConnection();

        String connectQuery = "SELECT * FROM cvTable";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);


            while (queryOutput.next()){

                String name= queryOutput.getString("name");
                String department = queryOutput.getString("department");
                String education= queryOutput.getString("education");
                String birthday= queryOutput.getString("birthday");
                String languages= queryOutput.getString("languages");
                String phone= queryOutput.getString("phone");
                String address= queryOutput.getString("address");
                String personal_ab= queryOutput.getString("personal_ab");
                String tag= queryOutput.getString("tag");
                String id= queryOutput.getString("id");


                cvs.add(new CV(name, id,  department,education,birthday,languages,personal_ab,
                        address,phone,tag));

            }

            TableCvAdd();


        } catch (Exception e){
            e.printStackTrace();
        }

    }




    @FXML
    private void initialize() {
        createCVButton.setOnAction((actionEvent -> createCV())); //Butonları ilgilendiren action bu şekilde ekleniyor
        listButton.setOnAction(actionEvent -> listCV());
        loadButton.setOnAction(actionEvent -> openLoad());
        helpButton.setOnAction(actionEvent -> getHelp());
        exitButton.setOnAction(actionEvent -> exitApp());
        deleteButton.setOnAction(actionEvent -> deleteCV());
        editButton.setOnAction(actionEvent -> editCV());
        FilterButton.setOnAction(actionEvent -> FilterCV());
        SearchCV.setOnAction(actionEvent -> SearchCV());
        addButton.setOnAction(actionEvent -> addonTable());
    }

    private ObservableList<CV> cvs= FXCollections.observableArrayList();

    public ObservableList<CV> getCvs() {
        return cvs;
    }

    public void setCvs(ObservableList<CV> cvs) {
        this.cvs = cvs;
    }
    @FXML
    public void TableCvAdd(){
        birthdayCol.setCellValueFactory(new PropertyValueFactory<CV, String>("birthday"));
        nameCol.setCellValueFactory(new PropertyValueFactory<CV, String>("name"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<CV, String>("department"));
        addressCol.setCellValueFactory(new PropertyValueFactory<CV, String>("address"));
        educationCol.setCellValueFactory(new PropertyValueFactory<CV, String>("education"));
        idCol.setCellValueFactory(new PropertyValueFactory<CV, String>("id"));
        telnumCol.setCellValueFactory(new PropertyValueFactory<CV, String>("telnum"));
        tagCol.setCellValueFactory(new PropertyValueFactory<CV, String>("tag"));
        personalabCol.setCellValueFactory(new PropertyValueFactory<CV, String>("personalab"));
        languagesCol.setCellValueFactory(new PropertyValueFactory<CV, String>("languages"));

        cv_table.setItems(cvs);
        cv_table.refresh();

    }

    @FXML
    public void addonTable(){
        String name = name_selected_txtf.getText();
        String id = id_selected_txtf.getText();
        String department = department_selected_txtf.getText();
        String education = education_selected_txtf.getText();
        String birthday = birthday_selected_txtf.getText();
        String languages = languages_selected_txtf.getText();
        String personalab = personalab_selected_txtf.getText();
        String address = address_selected_txtf.getText();
        String telnum = telnum_selected_txtf.getText();
        String tag = tag_selected_txtf.getText();

        CV temp = new CV(name,id,department,education,birthday,languages,personalab,address,telnum,tag);
        cvs.add(temp);



    }




    @FXML
    private void createCV() {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreateCV.fxml")));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Create CV");
            stage.setScene(new Scene(parent, 600, 400));
            stage.setMinWidth(605);
            stage.setMinHeight(405);
            stage.setResizable(false);


            stage.show();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("help fail");
            System.out.println("**********************"+e);
            alert.show();
        }
    }

    @FXML
    void deleteCV(){
        int selectedId = cv_table.getSelectionModel().getSelectedIndex();
        cv_table.getItems().remove(selectedId);
    }
    @FXML
    void editCV(){
        ObservableList<CV> currentTableData = cv_table.getItems();
        String currentId = id_selected_txtf.getText();
        for (CV cv : currentTableData){
            if(Objects.equals(cv.getId(), currentId)){
                cv.setAddress(address_selected_txtf.getText());
                cv.setName(name_selected_txtf.getText());
                cv.setId(id_selected_txtf.getText());
                cv.setDepartment(department_selected_txtf.getText());
                cv.setEducation(birthday_selected_txtf.getText());
                cv.setLanguages(languages_selected_txtf.getText());
                cv.setPersonalab(personalab_selected_txtf.getText());
                cv.setTag(tag_selected_txtf.getText());
                cv.setTelnum(telnum_selected_txtf.getText());
                cv.setBirthday(birthday_selected_txtf.getText());
            }
        }
    }
    @FXML
    private void openLoad(){

    }
    @FXML
    private void getHelp(){
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("help.fxml")));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Help");
            stage.setScene(new Scene(parent, 600, 400));
            stage.setMinWidth(605);
            stage.setMinHeight(405);
            stage.setResizable(false);


            stage.show
                    ();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("help fail");
            System.out.println("**********************"+e);

            alert.show();
        }

    }
    @FXML
    private void listCV(){

    }
    @FXML
    private void exitApp(){
        Platform.exit();
    }
    @FXML
    private Button FilterButton;

    @FXML
    private Button SearchCV;

    @FXML
    void rowClicked(MouseEvent event) {
        CV clickedCV = cv_table.getSelectionModel().getSelectedItem();
        address_selected_txtf.setText(String.valueOf(clickedCV.getAddress()));
        birthday_selected_txtf.setText(String.valueOf(clickedCV.getBirthday()));
        department_selected_txtf.setText(String.valueOf(clickedCV.getDepartment()));
        education_selected_txtf.setText(String.valueOf(clickedCV.getEducation()));
        languages_selected_txtf.setText(String.valueOf(clickedCV.getLanguages()));
        name_selected_txtf.setText(String.valueOf(clickedCV.getName()));
        personalab_selected_txtf.setText(String.valueOf(clickedCV.getPersonalab()));
        tag_selected_txtf.setText(String.valueOf(clickedCV.getTag()));
        telnum_selected_txtf.setText(String.valueOf(clickedCV.getTelnum()));
        id_selected_txtf.setText(String.valueOf(clickedCV.getId()));
    }
    @FXML
    private void SearchCV(){
        try {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SearchCV.fxml")));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("SearchCV");
        stage.setScene(new Scene(parent, 872, 592));
        stage.setMinWidth(890);
        stage.setMinHeight(599);
        stage.setResizable(false);


        stage.show();

    } catch (IOException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("help fail");
        System.out.println("**********************"+e);
        alert.show();
    }


        }


    @FXML
    private void FilterCV(){
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FilterCV.fxml")));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Filter CV");
            stage.setScene(new Scene(parent, 731, 489));
            stage.setMinWidth(735);
            stage.setMinHeight(492);
            stage.setResizable(false);


            stage.show();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("help fail");
            System.out.println("**********************"+e);
            alert.show();
        }
    }

}