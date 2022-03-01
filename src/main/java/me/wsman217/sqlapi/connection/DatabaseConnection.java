package me.wsman217.sqlapi.connection;

import me.wsman217.sqlapi.connection.connectors.DatabaseConnector;

public record DatabaseConnection(DatabaseConnector databaseConnector) {

    public boolean connect() {
        return databaseConnector.connect();
    }
}
