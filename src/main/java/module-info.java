module JavaFX.Maven.Template {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;


    // This one does not seem necessary, but I have seen it been used in other projects, so I am keeping it here just in case I need it later
    //opens presentation to javafx.fxml;
    exports presentation;
}