package lk.sipsewanainstitute.hibernate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lk.sipsewanainstitute.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;

import java.io.IOException;


public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/dashBoardForm.fxml"))));
        primaryStage.setMaximized(true );
        primaryStage.setTitle("Sipsewana Institute");
        primaryStage.getIcons().add(new Image("lk/sipsewanainstitute/hibernate/assets/img1.jpg"));
        primaryStage.show();

        Session session = FactoryConfiguration.getInstance().getSession();
        session.close();
    }
}
