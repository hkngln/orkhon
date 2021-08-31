package org.orkhon.infrastructure;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public class Router {
    private static Animator animatorInstance;

    private Router() {}
    private static Router instance;
    private static final Context context = Context.instance();

    public static Router instance() {
        return instance == null ? new Router() : instance;
    }

    public Router setCurrentStage(Stage currentStage) {
        context.setCurrentStage(currentStage);
        return instance();
    }

    public Router animate(Animator animator) {
        animatorInstance = animator;
        return instance();
    }

    public void navigateTo(String url) {
        try {
            var stylesheet = getClass().getResource("/style/all.css").toExternalForm();
            var loader = new FXMLLoader(getClass().getResource(url));
            Parent parent = loader.load();
            Stage stage = context.getCurrentStage();
            Scene scene = context.getCurrentStage().getScene();
            if (scene == null) {
                scene = new Scene(parent);
                stage.setScene(scene);
//                    stage.setTitle("Sample JavaFX Application");
            } else {
                stage.getScene().setRoot(parent);
            }
            scene.getStylesheets().add(stylesheet);
            stage.show();
            animatorInstance.animate(parent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    static class Context {
        private static Context instance;

        public static Context instance() {
            return instance == null ? new Context() : instance;
        }

        private static final WeakHashMap<String, Object> contextObjects = new WeakHashMap<>();
        private static Stage currentStage;

        public Map<String, ?> getContextObjects() {
            return contextObjects;
        }

        public <T> T getContextObject(String key){
            return (T) contextObjects.get(key);
        }

        public <T> T removeContextObject(String key){
            return (T) contextObjects.remove(key);
        }
        public <T> void addContextObject(String key, T value){
            contextObjects.put(key, value);
        }
        public void clearContextObjects(){
            contextObjects.clear();
        }
        public Stage getCurrentStage() {
            return Objects.requireNonNullElseGet(currentStage, Stage::new);
        }
        public void setCurrentStage(Stage stage) {
            currentStage = stage;
        }
    }
}
