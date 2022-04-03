module nl.oopd.peach {
    requires javafx.controls;
    requires javafx.fxml;
    requires hanyaeger;

    opens audio;
    opens images;
    exports nl.oopd.peach;
    exports nl.oopd.peach.entities.Gameobjects.Tiles.Tilemap;
}