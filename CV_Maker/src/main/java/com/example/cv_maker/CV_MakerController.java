package com.example.cv_maker;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CV_MakerController {

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
    private Button exitButton; //buton burada fxml dosyasına bağlanıyor, scenebuilder da butonun üstüne tıklayıp sağ taraftan
    //code kısmına geldiğinizde butonların id si ve eventlerinin bağdaştırılacağı yeri görüceksiniz, oraya yazarsanız scenebuilder
    //otomatik olarak fxml dosyasına bağlıyor.
    @FXML
    private Pane pane;
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
    private TextField id_selected_txtf;
    @FXML
    private void initialize() {
        createCVButton.setOnAction((actionEvent -> createCV())); //Butonları ilgilendiren action bu şekilde ekleniyor
        listButton.setOnAction(actionEvent -> listCV());
        loadButton.setOnAction(actionEvent -> openLoad());
        helpButton.setOnAction(actionEvent -> getHelp());
        exitButton.setOnAction(actionEvent -> exitApp());
        deleteButton.setOnAction(actionEvent -> deleteCV());
        editButton.setOnAction(actionEvent -> editCV());
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
            if(cv.getId() == currentId){
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

    }
    @FXML
    private void listCV(){

    }
    @FXML
    private void exitApp(){
        Platform.exit();
    }

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
}