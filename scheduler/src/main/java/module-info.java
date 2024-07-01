module com.bourke {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.bourke to javafx.fxml;
    exports com.bourke;
}
