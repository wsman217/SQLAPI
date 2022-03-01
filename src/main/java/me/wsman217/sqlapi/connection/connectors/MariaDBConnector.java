package me.wsman217.sqlapi.connection.connectors;

public class MariaDBConnector extends DatabaseConnector {

    public MariaDBConnector(String username, String password, String host, String port, String database) {
        super("jdbc:mariadb://", username, password, host, port, database);
    }
}
