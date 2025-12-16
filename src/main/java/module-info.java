module cvv.project.foodlog {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jakarta.persistence;


    opens cvv.project.foodlog to javafx.fxml;
    exports cvv.project.foodlog;
}