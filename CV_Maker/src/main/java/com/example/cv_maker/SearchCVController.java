package com.example.cv_maker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;
import java.sql.*;

public class SearchCVController extends CV_MakerController{
        @FXML
        private Button SearchCV;

        @FXML
        private TextField TELNUMtext;

        @FXML
        private TableColumn<CV, String> addressCol;

        @FXML
        private Text address_selected;

        @FXML
        private TextField adressText;

        @FXML
        private TableColumn<CV, String> birthdayCol;

        @FXML
        private TextField birthdayText;

        @FXML
        private Text birthday_selected;

        @FXML
        private TableView<CV> Searchcv_table;

        @FXML
        private TableColumn<CV, String> departmentCol;

        @FXML
        private TextField departmentText;

        @FXML
        private Text department_selected;

        @FXML
        private TextField education;

        @FXML
        private TableColumn<CV, String> educationCol;

        @FXML
        private Text education_selected;

        @FXML
        private TableColumn<CV, String> idCol;

        @FXML
        private TextField idText;

        @FXML
        private Text id_selected;

        @FXML
        private TextField languageText;

        @FXML
        private TableColumn<CV, String> languagesCol;

        @FXML
        private Text languages_selected;

        @FXML
        private TableColumn<CV, String> nameCol;

        @FXML
        private TextField nameText;

        @FXML
        private Text name_selected;

        @FXML
        private Pane pane;

        @FXML
        private TableColumn<CV, String> personalabCol;

        @FXML
        private TextField personalabText;

        @FXML
        private Text personalab_selected;

        @FXML
        private TableColumn<CV, String> tagCol;

        @FXML
        private TextField tagText;

        @FXML
        private Text tag_selected;

        @FXML
        private TableColumn<CV, String> telnumCol;

        @FXML
        private Text telnum_selected;

        private ObservableList<CV> Searchcvs= FXCollections.observableArrayList();



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


                                Searchcvs.add(new CV(name, id,  department,education,birthday,languages,personal_ab,
                                        address,phone,tag));

                        }

                        TableCvAdd();


                } catch (Exception e){
                        e.printStackTrace();
                }

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

                Searchcv_table.setItems(Searchcvs);
                Searchcv_table.refresh();

        }




        @FXML
        private void initialize() {  //kullan覺lam覺yor olabilir .
                SearchCV.setOnAction((actionEvent -> SearchCV()));

        }

                @FXML
                private void SearchCV(){
                        ObservableList<CV> CVsearch= FXCollections.observableArrayList();
                        ObservableList<CV> currentTableData = Searchcv_table.getItems();
                        Iterator<CV> it = currentTableData.iterator();
                        List<CV> Target = new List<CV>() {
                                @Override
                                public int size() {
                                        return 0;
                                }

                                @Override
                                public boolean isEmpty() {
                                        return false;
                                }

                                @Override
                                public boolean contains(Object o) {
                                        return false;
                                }

                                @Override
                                public Iterator<CV> iterator() {
                                        return null;
                                }

                                @Override
                                public Object[] toArray() {
                                        return new Object[0];
                                }

                                @Override
                                public <T> T[] toArray(T[] a) {
                                        return null;
                                }

                                @Override
                                public boolean add(CV cv) {
                                        return false;
                                }

                                @Override
                                public boolean remove(Object o) {
                                        return false;
                                }

                                @Override
                                public boolean containsAll(Collection<?> c) {
                                        return false;
                                }

                                @Override
                                public boolean addAll(Collection<? extends CV> c) {
                                        return false;
                                }

                                @Override
                                public boolean addAll(int index, Collection<? extends CV> c) {
                                        return false;
                                }

                                @Override
                                public boolean removeAll(Collection<?> c) {
                                        return false;
                                }

                                @Override
                                public boolean retainAll(Collection<?> c) {
                                        return false;
                                }

                                @Override
                                public void clear() {

                                }

                                @Override
                                public CV get(int index) {
                                        return null;
                                }

                                @Override
                                public CV set(int index, CV element) {
                                        return null;
                                }

                                @Override
                                public void add(int index, CV element) {

                                }

                                @Override
                                public CV remove(int index) {
                                        return null;
                                }

                                @Override
                                public int indexOf(Object o) {
                                        return 0;
                                }

                                @Override
                                public int lastIndexOf(Object o) {
                                        return 0;
                                }

                                @Override
                                public ListIterator<CV> listIterator() {
                                        return null;
                                }

                                @Override
                                public ListIterator<CV> listIterator(int index) {
                                        return null;
                                }

                                @Override
                                public List<CV> subList(int fromIndex, int toIndex) {
                                        return null;
                                }
                        };
                        while (it.hasNext()) {

                                CV target = it.next();
                                if(nameText.getText()!=""){
                                        Target = currentTableData.stream()
                                                .filter(CV-> CV.getName().equals(nameText.getText()))
                                                .collect(Collectors.toList());
                                }
                                if(departmentText.getText()!=""){
                                        Target = currentTableData.stream()
                                                .filter(CV-> CV.getDepartment().equals(departmentText.getText()))
                                                .collect(Collectors.toList());}
                                if(idText.getText()!=""){
                                        Target = currentTableData.stream()
                                                .filter(CV-> CV.getId().equals(idText.getText()))
                                                .collect(Collectors.toList());}
                                if(adressText.getText()!=""){
                                        Target = currentTableData.stream()
                                                .filter(CV-> CV.getAddress().equals(adressText.getText()))
                                                .collect(Collectors.toList());}
                                if(birthdayText.getText()!=""){
                                        Target = currentTableData.stream()
                                                .filter(CV-> CV.getBirthday().equals(birthdayText.getText()))
                                                .collect(Collectors.toList());}
                                if(languageText.getText()!=""){
                                        Target = currentTableData.stream()
                                                .filter(CV-> CV.getLanguages().equals(languageText.getText()))
                                                .collect(Collectors.toList());}
                                if(personalabText.getText()!=""){
                                        Target = currentTableData.stream()
                                                .filter(CV-> CV.getPersonalab().equals(personalabText.getText()))
                                                .collect(Collectors.toList());}
                                if(tagText.getText()!=""){
                                        Target = currentTableData.stream()
                                                .filter(CV-> CV.getTag().equals(tagText.getText()))
                                                .collect(Collectors.toList());}
                                if(TELNUMtext.getText()!=""){
                                        Target = currentTableData.stream()
                                                .filter(CV-> CV.getTelnum().equals(TELNUMtext.getText()))
                                                .collect(Collectors.toList());}
                                if(birthdayText.getText()!=""){
                                        Target = currentTableData.stream()
                                                .filter(CV-> CV.getBirthday().equals(birthdayText.getText()))
                                                .collect(Collectors.toList());}
                                for(int i=0;i<Target.size();i++) {
                                        Searchcvs.add(Target.get(i));
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

                                        Searchcv_table.setItems(Searchcvs);
                                        Searchcv_table.refresh();
                                }


                        }

                }
        }

