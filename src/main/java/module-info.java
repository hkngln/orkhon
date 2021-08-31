module org.orkhon {
    requires javafx.controls;
    requires javafx.fxml;
//    requires javafx.web;

    requires org.controlsfx.controls;
    requires validatorfx;
    requires eu.hansolo.tilesfx;
    requires org.jsoup;
    requires org.mariadb.jdbc;
    requires java.sql;
    requires org.jdbi.v3.core;
    requires org.jdbi.v3.sqlobject;

    opens org.orkhon to javafx.fxml;
    exports org.orkhon.controllers.user.auth;
    exports org.orkhon.controllers;
    exports org.orkhon;
}