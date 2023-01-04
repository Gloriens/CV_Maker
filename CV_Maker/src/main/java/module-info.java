module com.example.cv_maker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.cv_maker to javafx.fxml;
    exports com.example.cv_maker;
}