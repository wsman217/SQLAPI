package me.wsman217.sqlapi.connection.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used as an abstract class to allow connections to different databases not natively supported.
 */
public abstract class DatabaseConnector {

    /**
     * The connection represents the actual connection to the database.
     */
    public static Connection connection;

    private String connector = "";
    private String user = "";
    private String password = "";
    private String host = "";
    private String port = "";
    private String database = "";

    private String connectionString = "";

    /**
     * Empty constructor to allow different connections to create their own types of connections with different parameters.
     */
    public DatabaseConnector() {

    }

    /**
     * General constructor based off of MySQL since that seems to be the most prominent.
     * @param connector The connector string MySQL ex. "jdbc:mysql://"
     * @param user The user that will be connected to the database.
     * @param password The password for the user.
     * @param host The host the database is on.
     * @param port The port used to connect to the database.
     * @param database The actual database being connected to.
     */
    public DatabaseConnector(String connector, String user, String password, String host, String port, String database) {
        this.connector = connector;
        this.user = user;
        this.password = password;
        this.host = host;
        this.port = port;
        this.database = database;
    }

    /**
     * Method to enable the connection to the database.
     * @return True if the connection was successful, false otherwise.
     */
    public boolean connect() {
        if (connectionString.length() == 0)
            connectionString = buildConnectionString();
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Method to build the connection string that will be used in {@link #connect()}. Override this method to
     * create custom connection strings ex. {@link SQLiteConnector}.
     * @return The connection string.
     */
    public String buildConnectionString() {
        return connector + host + ":" + port + "/" + database + "?user=" + user + "&password=" + password;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
