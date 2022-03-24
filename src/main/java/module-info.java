module nl.oopd.peach {
    requires javafx.controls;
    requires javafx.fxml;
    requires hanyaeger;

    opens audio;
    opens images;
    exports nl.oopd.peach;
}