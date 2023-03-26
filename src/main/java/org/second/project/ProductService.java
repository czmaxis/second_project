package org.second.project;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProductService {
    static Connection connection;
    public ProductService() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/items",
                "second-project-user",
                "Database123"
        );
    }

    private static Product extractProductData(ResultSet resultSet) throws SQLException {
        return new Product(
                resultSet.getLong("id"),
                resultSet.getString("partNo"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getBoolean("isForSale"),
                resultSet.getBigDecimal("price")
        );
    }

        public static List<Product> getAllProducts() throws SQLException {
            Statement statement =connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM item");

            List<Product> resultList = new ArrayList<>();

            while (resultSet.next()) {
                Product product = extractProductData(resultSet);

                resultList.add(product);
            }

            return resultList;
        }

    public static Product loadProductById(Long itemId) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM item WHERE id = " + itemId);

        if (resultSet.next()) {
            return extractProductData(resultSet);
        }
        return null;
    }

    public static Product saveItem(Product product) throws SQLException{
        Statement statement = connection.createStatement();

        statement.executeUpdate(
                "INSERT INTO item(partNo, name, description, isForSale, price)"+" VALUES('"
                        + product.getPartNo() +"', '"
                        + product.getName() + "', '"
                        + product.getDescription()+"',"
                        + product.getIsForSale()+","
                        + product.getPrice()+ ")",
                Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        product.setId(generatedKeys.getLong(1));

        return product;
    }

    public static void updatePriceById(Long id, BigDecimal price) throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE item SET price = "+ price + " WHERE id = " + id);

    }
    public static void deleteOutOfSaleItems() throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM item WHERE isForSale = false");
    }



}
