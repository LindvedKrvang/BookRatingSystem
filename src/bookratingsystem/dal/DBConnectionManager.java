/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author Rasmus
 */
public class DBConnectionManager {

    private static DBConnectionManager mInstance;

    private static final String CONFIG_FILE_NAME = "BookRatingSystemDB.cfg";
    private final SQLServerDataSource ds;

    public static DBConnectionManager getInstance() throws IOException {
        if (mInstance == null) {
            mInstance = new DBConnectionManager();
        }
        return mInstance;
    }

    private DBConnectionManager() throws IOException {
        Properties props = new Properties();
        props.load(new FileReader(CONFIG_FILE_NAME));
        ds = new SQLServerDataSource();
        ds.setServerName(props.getProperty("SERVER"));
        ds.setDatabaseName(props.getProperty("DATABASE"));
        ds.setPortNumber(Integer.parseInt(props.getProperty("PORT")));
        ds.setUser(props.getProperty("USER"));
        ds.setPassword(props.getProperty("PASSWORD"));
    }

    public Connection getConnection() throws SQLServerException {
        return ds.getConnection();
    }
}
