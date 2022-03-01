package me.wsman217.sqlapi.connection.connectors;

public class MySQLConnector extends DatabaseConnector{

    public MySQLConnector(String username, String password, String host, String port, String database) {
        super("jdbc:mysql://", username, password, host, port, database);
    }
}
