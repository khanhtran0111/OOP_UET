module com.khanhtran0111.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.khanhtran0111.demo to javafx.fxml;
    exports com.khanhtran0111.demo;
}