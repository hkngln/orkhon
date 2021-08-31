package org.orkhon.controllers.user.auth;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.orkhon.infrastructure.RouteUrl;
import org.orkhon.infrastructure.Router;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {

    @FXML
    public Button btnLogin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnLogin.setOnMouseClicked(mouseEvent -> {
            Router.instance()
                    .navigateTo(RouteUrl.MAIN_VIEW);
        });
    }
}
