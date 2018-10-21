package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {

	Connection connection = null;

	public ResultSet find(String query) throws SQLException {
		ConnectionManager connectionManager = new ConnectionManager();

		ResultSet resultset = null;
		Statement statement =null;
		try {
			connection = connectionManager.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultset;

	}

    public void save(String query) {
        ConnectionManager connectionManager = new ConnectionManager();
        connection = connectionManager.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
