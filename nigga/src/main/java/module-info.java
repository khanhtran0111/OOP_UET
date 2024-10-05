module com.khanhtran0111 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.khanhtran0111 to javafx.fxml;
    exports com.khanhtran0111;
}