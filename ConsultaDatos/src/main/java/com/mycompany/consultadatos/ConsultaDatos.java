
package com.mycompany.consultadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDatos {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/capinteria";
    private static final String usuario = "root";
    private static final String contrasenia = "1111";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, usuario, contrasenia);
    }

    public class DatabaseQuery {
        public List<String> fetchDataFromDatabase() {
            List<String> resultList = new ArrayList<>();

            try (Connection connection = ConsultaDatos.getConnection()) {
                String sqlQuery = "SELECT columna FROM carpinteria";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String result = resultSet.getString("columna");
                    resultList.add(result);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return resultList;
        }
    }

    public static void main(String[] args) {
        ConsultaDatos consultaDatos = new ConsultaDatos();
        DatabaseQuery databaseQuery = consultaDatos.new DatabaseQuery();
        List<String> resultList = databaseQuery.fetchDataFromDatabase();

        for (String result : resultList) {
            System.out.println(result);
        }
    }
}
