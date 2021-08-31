package org.orkhon.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController  implements Initializable {

    @FXML
    public Button btnLogin;

    @FXML
    public TextArea textArea;

    @FXML
    public TextField txtBookId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnLogin.setOnMouseClicked(mouseEvent -> {
//            Router.instance().navigateTo(RouteUrl.LOGIN_VIEW);
            try {
                Document document = Jsoup.connect("https://www.kitapyurdu.com/kitap/-/" + txtBookId.getText() +".html").get();
                var info = document.getElementsByClass("info__text").first();
                var name = document.getElementsByClass("pr_header__heading").first();
                var author = document.select("div.pr_producers__manufacturer>div>a>span").first();
                var publisher = document.select("div.pr_producers__publisher>div>a>span").first();
                var translator = document.select("div.attributes>table>tbody>tr>td:last-child")
                        .stream()
                        .map(Element::text)
                        .reduce((e, a)-> e + "\n" + a);
                var publishDate = document.select("div.attributes>table>tbody>tr>td:last-child").first();

//                textArea.setText(publishDate.text() + "/"+ author.text() + " / " + publisher.text() + " / " + translator.text());
                translator.ifPresent(s ->textArea.setText(s));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
