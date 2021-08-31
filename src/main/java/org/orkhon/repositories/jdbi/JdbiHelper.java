package org.orkhon.repositories.jdbi;

//import com.zaxxer.hikari.HikariDataSource;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.mariadb.jdbc.MariaDbDataSource;
import org.mariadb.jdbc.MariaDbPoolDataSource;

import java.io.*;
import java.sql.SQLException;
import java.util.Properties;

public class JdbiHelper {
    private static Jdbi jdbi;
    private JdbiHelper() {}

    private static void create() throws IOException, SQLException {
        if(jdbi == null) {
            var input = new FileInputStream("./config.properties");
            var prop = new Properties();
            prop.load(input);
            var ds = new MariaDbPoolDataSource(prop.getProperty("db.url"));
            ds.setMinPoolSize(2);
            ds.setMaxPoolSize(10);
            jdbi = Jdbi.create(ds);
            jdbi.installPlugin(new SqlObjectPlugin());
        }
    }

    public static Jdbi jdbi() throws IOException, SQLException {
        create();
        return jdbi;
    }

    public static Handle handle() throws IOException, SQLException {
        return jdbi().open();
    }

    public static <T extends Class<T>> T createDao(T dao) throws IOException, SQLException {
        return handle().attach(dao);
    }
}
