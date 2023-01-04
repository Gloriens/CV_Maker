
package com.example.cv_maker;

import java.sql.Connection;
import java.sql.DriverManager;

public class CV_Database {
    public Connection databaselink;

    public Connection getDBConnection() {
        String url = "jdbc:sqlite:C:\\Users\\ak_an\\OneDrive\\Masaüstü\\umuta son attığım\\CV_Maker\\CV_db/cv_db.db";

        try {
            databaselink = DriverManager.getConnection(url);
            System.out.println("SQLite is connected.");

        } catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();

        }

        return databaselink;

    }
}

