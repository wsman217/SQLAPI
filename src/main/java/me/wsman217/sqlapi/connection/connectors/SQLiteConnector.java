package me.wsman217.sqlapi.connection.connectors;

public class SQLiteConnector extends DatabaseConnector {

    private final String filepath;

    public SQLiteConnector(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public String buildConnectionString() {
        return "jdbc:sqlite:" + filepath;
    }
}
