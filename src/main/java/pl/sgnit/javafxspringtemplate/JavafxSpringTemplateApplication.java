package pl.sgnit.javafxspringtemplate;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavafxSpringTemplateApplication extends Application {

    public static ConfigurableApplicationContext applicationContext;
    private FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        fxmlLoader.setLocation(getClass().getResource("/MainView.fxml"));

        Parent root = fxmlLoader.load();

        stage.setTitle("JavaFX - Spring Boot Template");
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        applicationContext = SpringApplication.run(JavafxSpringTemplateApplication.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(applicationContext::getBean);
    }

    @Override
    public void stop() throws Exception {
        applicationContext.stop();
        Platform.exit();
    }
}
