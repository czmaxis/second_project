package org.second.project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    Connection connection;

    public ProductService() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/items",
                "second-project-user",
                "Database123"
        );
    }
        public List<Product> getAllProducts() throws SQLException {
            Statement statement =connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM item");

            List<Product> resultList = new ArrayList<>();

            while (resultSet.next()) {
                Product product = extractProductData(resultSet);

                resultList.add(product);
            }

            return resultList;
        }

        //upravit a dodělat
    private Product extractProductData(ResultSet resultSet) throws SQLException {
        return new Product(
                resultSet.getLong("id"),
                resultSet.getString("partNo"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getBoolean("isForSale"),
                resultSet.getBigDecimal("price")
        );
    }

    public Product loadAllAvailabelItems() throws SQLException {
        Statement statement= connection.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM item");

        while (results.next()){
            return extractProductData(results);
        }
        return null;
    }


    public Product loadProductById(Long itemId) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM item WHERE id = " + itemId);

        if (resultSet.next()) {
            return extractProductData(resultSet);
        }
        return null;
    }

    public long saveItem(Product newProduct) throws SQLException{
        Statement statement = connection.createStatement();

        statement.executeUpdate(
                "INSERT INTO item(partNo, name, description, isForSale, price) VALUES (" +
                        "'"+ newProduct.getPartNo() +"', "
                        +newProduct.getName() + ", "
                        + newProduct.getDescription()+", "
                        + newProduct.getForSale()+", "
                        + newProduct.getPrice()+ ")",
                    Statement.RETURN_GENERATED_KEYS);

        return statement.getGeneratedKeys().getLong("id");
    }

    public void updatePriceById(Long id) throws SQLException{
        Statement statement = connection.createStatement();

        statement.executeUpdate("UPDATE item  ");

    }





}
