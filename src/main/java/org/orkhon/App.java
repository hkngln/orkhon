package org.orkhon;

import javafx.application.Application;
import javafx.stage.Stage;
import org.orkhon.infrastructure.FadeInAnimator;
import org.orkhon.infrastructure.RouteUrl;
import org.orkhon.infrastructure.Router;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Orhun v1.0.0");
        stage.setMinWidth(700);
        stage.setMinHeight(500);
        //Context.instance().setCurrentStage(stage);
        Router.instance()
                .setCurrentStage(stage)
                .animate(new FadeInAnimator())
                .navigateTo(RouteUrl.LOGIN_VIEW);
    }

    public static void main(String[] args) {
        launch();
    }
}

//import javafx.application.Application;
//import javafx.beans.binding.Bindings;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//
//import java.util.Arrays;
//
//public class App extends Application {
//
//    private final TableView<Person> table = new TableView<Person>();
//    private final ObservableList<Person> data =
//            FXCollections.observableArrayList(
//                    new Person("Jacob", "Smith", "jacob.smith@example.com"),
//                    new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
//                    new Person("Ethan", "Williams", "ethan.williams@example.com"),
//                    new Person("Emma", "Jones", "emma.jones@example.com"),
//                    new Person("Michael", "Brown", "michael.brown@example.com")
//            );
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage stage) {
//        Scene scene = new Scene(new Group());
//        stage.setTitle("Table View Sample");
//        stage.setWidth(450);
//        stage.setHeight(500);
//
//        final Label label = new Label("Address Book");
//        label.setFont(new Font("Arial", 20));
//
//        table.setEditable(true);
//
//        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
//        firstNameCol.setMinWidth(100);
//        firstNameCol.setCellValueFactory(
//                new PropertyValueFactory<>("firstName"));
//
//        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
//        lastNameCol.setMinWidth(100);
//        lastNameCol.setCellValueFactory(
//                new PropertyValueFactory<>("lastName"));
//
//        TableColumn<Person, String> emailCol = new TableColumn<>("Email");
//        emailCol.setMinWidth(200);
//        emailCol.setCellValueFactory(
//                new PropertyValueFactory<>("email"));
//
//        table.setItems(data);
//        table.getColumns().addAll(Arrays.asList(firstNameCol, lastNameCol, emailCol));
//
//        table.setRowFactory(tableView -> {
//            final TableRow<Person> row = new TableRow<>();
//            final ContextMenu contextMenu = new ContextMenu();
//            final MenuItem removeMenuItem = new MenuItem("Remove");
//            removeMenuItem.setOnAction(event -> table.getItems().remove(row.getItem()));
//            contextMenu.getItems().add(removeMenuItem);
//            // Set context menu on row, but use a binding to make it only show for non-empty rows:
//            row.contextMenuProperty().bind(
//                    Bindings.when(row.emptyProperty())
//                            .then((ContextMenu) null)
//                            .otherwise(contextMenu)
//            );
//            return row;
//        });
//
//        final VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(label, table);
//
//        ((Group) scene.getRoot()).getChildren().addAll(vbox);
//
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static class Person {
//
//        private final SimpleStringProperty firstName;
//        private final SimpleStringProperty lastName;
//        private final SimpleStringProperty email;
//
//        private Person(String fName, String lName, String email) {
//            this.firstName = new SimpleStringProperty(fName);
//            this.lastName = new SimpleStringProperty(lName);
//            this.email = new SimpleStringProperty(email);
//        }
//
//        public String getFirstName() {
//            return firstName.get();
//        }
//
//        public void setFirstName(String fName) {
//            firstName.set(fName);
//        }
//
//        public String getLastName() {
//            return lastName.get();
//        }
//
//        public void setLastName(String fName) {
//            lastName.set(fName);
//        }
//
//        public String getEmail() {
//            return email.get();
//        }
//
//        public void setEmail(String fName) {
//            email.set(fName);
//        }
//    }
//}