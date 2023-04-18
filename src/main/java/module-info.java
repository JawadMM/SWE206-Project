module swe206 {
    requires javafx.controls;
    requires javafx.fxml;

    opens swe206 to javafx.fxml;
    exports swe206;
}
