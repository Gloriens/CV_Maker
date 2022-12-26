 
package deneme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

 

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateCVController {
    @FXML
    private Button saveButton;
    @FXML
    private TextField nameText;
    @FXML
    private TextField idText;
    @FXML
    private TextField departmentText;
    @FXML
    private TextField educationText;
    @FXML
    private TextField birthText;
    @FXML
    private TextField langueText;
    @FXML
    private TextField personalAText;
    @FXML
    private TextField addressText;
    @FXML
    private TextField telnumText;
    @FXML
    private TextField tagText;

    @FXML
    private void addCV(){
        saveButton.setOnAction(actionEvent -> {
            try {
                saveTextField();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    
     //veri tabanı bağlantısı
        Connection conn = null;
    
    public void saveTextField()throws IOException {
        String name = nameText.getText();
        String id = idText.getText();
        String department = departmentText.getText();
        String education = educationText.getText();
        String birthday = birthText.getText();
        String languages = langueText.getText();
        String personalab = personalAText.getText();
        String address = addressText.getText();
        String telnum = telnumText.getText();
        String tag = tagText.getText();

        //yukarda alınan bilgiler bir sql tablosu oluşturularak insert into x x x x diye tabloya eklenicek.
        //sql metodu buraya yazılmalı

        //tablo oluşturacak string 
        final String createTableWORKString
                = "create table if not exists works"
                + "("
                + "    id int primary key auto_increment,"
                + "    name varchar(40)   not null,"
                + "    department varchar(40),"
                + "    education date default null,"
                + "    languages varchar(50),"
                + "    personalab varchar(100),"
                + "    address varchar(150),"
                + "    telnum varchar(10),"
                + "    tag varchar(100)"
                + ")";

        //veri tabanı bağlantısı için değişkenler 
        final String password = "1234";                                 // şifre
        String username = "admin";                                   //kullanıcı adı
        final String dbname = "cvlist";                               //veritabanı adı
        final String dburl = "jdbc:sqlite:C://";

       
        try {
            conn = DriverManager.getConnection(dburl + dbname, username, password);
        } catch (SQLException ex) {
            System.out.println("veri tabanına bağlanılamadı");
        }

        //tabloyu fiziksel olarak oluştur
        try {
            PreparedStatement pst = conn.prepareStatement(createTableWORKString);
            pst.execute();
        } catch (SQLException ex) {
            System.out.println("tablo oluşturulamadı : " + ex.getMessage());
        }

        //insert sorgusu
        try {
            PreparedStatement pstExt = conn.prepareStatement
        ("insert into works (name,department,education,birthday,languages,personalab,address,telnum,tag)"
                            + "values(?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pstExt.setString(1, name);
            pstExt.setString(2, department);
            pstExt.setString(3, education);
            pstExt.setString(4, birthday);
            pstExt.setString(5, languages);
            pstExt.setString(6, personalab);
            pstExt.setString(7, address);
            pstExt.setString(8, telnum);
            pstExt.setString(9, tag);
            
        } catch (SQLException ex) {
            System.out.println("kayıt yapılamadı "+ ex.getMessage());
        }


        File cv = new File("saved_cv.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cv, true))) {

            writer.write(name + "|" +id+ "|" +department+ "|" +education+ "|" +birthday+ "|" +languages+ "|" +personalab+ "|"
                    +address+ "|" +telnum+ "|" +tag+ "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

