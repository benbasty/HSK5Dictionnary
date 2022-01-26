package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PracticeApp extends Application {
    private Dictionary dictionary;

    public void init() throws Exception {
        this.dictionary = new Dictionary();
    }

    public void start(Stage stage) throws Exception {
        PracticeView practiceView = new PracticeView(dictionary);
        EnteringNewWords enteringNewWords = new EnteringNewWords(dictionary);

        BorderPane layout = new BorderPane();
        HBox menu = new HBox();
        menu.setPadding(new Insets(20,20,20,20));
        menu.setSpacing(10);

        Button enterButton = new Button("Enter new HSK words");
        Button practiceButton = new Button("Practice Your HSK");

        menu.getChildren().addAll(enterButton, practiceButton);
        layout.setTop(menu);

        enterButton.setOnAction((event) -> {
            layout.setCenter(enteringNewWords.getView());
        });

        practiceButton.setOnAction((event) -> {
            layout.setCenter(practiceView.getView());
        });

        layout.setCenter(enteringNewWords.getView());

        Scene view = new Scene(layout,400,300);
        stage.setScene(view);
        stage.show();




    }
    public static void main(String[] args) {
        launch(PracticeApp.class);
    }









}
