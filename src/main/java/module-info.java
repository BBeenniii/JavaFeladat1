module com.example.feladat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.feladat to javafx.fxml;
    exports com.example.feladat;
}