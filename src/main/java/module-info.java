module com.typingtest.typingtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.typingtest.typingtest to javafx.fxml;
    exports com.typingtest.typingtest;
}