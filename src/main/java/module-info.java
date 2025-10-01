module com.escape {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens com.escape to javafx.fxml;
    exports com.escape;

    opens com.model to javafx.fxml;
    exports com.model;
}
