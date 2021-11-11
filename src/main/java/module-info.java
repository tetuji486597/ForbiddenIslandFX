module game.forbiddenislandfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.jfxtras.styles.jmetro;

    opens game.forbiddenislandfx to javafx.fxml;
    exports game.forbiddenislandfx;
}