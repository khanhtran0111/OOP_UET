module com.khanhtran0111.testingjvfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.khanhtran0111.testingjvfx to javafx.fxml;
    exports com.khanhtran0111.testingjvfx;
}