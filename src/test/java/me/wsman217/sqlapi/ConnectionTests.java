package me.wsman217.sqlapi;

import me.wsman217.sqlapi.connection.DatabaseConnection;
import me.wsman217.sqlapi.connection.connectors.MariaDBConnector;
import me.wsman217.sqlapi.connection.connectors.MySQLConnector;
import me.wsman217.sqlapi.connection.connectors.SQLiteConnector;
import org.junit.jupiter.api.Test;

public class ConnectionTests {

    @Test
    public void testMySQLConnection() {
        DatabaseConnection connection = new DatabaseConnection(new MySQLConnector("username", "password", "ip", "3306", "database"));
        assert connection.connect();
    }

    @Test
    public void testMariaDBConnection() {
        DatabaseConnection connection = new DatabaseConnection(new MariaDBConnector("username", "password", "ip", "3306", "database"));
        assert connection.connect();
    }

    @Test
    public void testSQLiteConnection() {
        DatabaseConnection connection = new DatabaseConnection(new SQLiteConnector("filePath"));
        assert connection.connect();
    }
}
