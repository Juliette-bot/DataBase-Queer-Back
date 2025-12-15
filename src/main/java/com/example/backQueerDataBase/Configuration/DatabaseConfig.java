package com.example.backQueerDataBase.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DatabaseConfig {

    private static DataSource dataSource;

    @Autowired
    public DatabaseConfig(DataSource dataSource) {
        DatabaseConfig.dataSource = dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}