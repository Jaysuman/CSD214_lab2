package com.example.csd214_lab2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class HelloController implements Initializable {
    public TableView<login> login_table;
    public TableColumn<login,Integer> Id;
    public TableColumn <login,String> Name;
    public TableColumn <login,String> Email;
    public TableColumn <login,String> Password;
    public TextField tId;
    public TextField tName;
    public TextField tEmail;
    public TextField tPassword;
    @FXML
    private Label welcomeText;

    ObservableList<login> list = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        fetch();
    }

    @FXML
    private void fetch() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csd_214_lab2_suman";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM login_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int Id = resultSet.getInt("Id");
                String Name = resultSet.getString("Name");
                String Email = resultSet.getString("Email");
                String Password = resultSet.getString("Password");
                login_table.getItems().add(new login(Id, Name, Email, Password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Id.setCellValueFactory(new PropertyValueFactory<login,Integer>("Id"));
        Name.setCellValueFactory(new PropertyValueFactory<login,String>("Name"));
        Email.setCellValueFactory(new PropertyValueFactory<login,String>("Email"));
        Password.setCellValueFactory(new PropertyValueFactory<login,String>("Password"));
        login_table.setItems(list);


    }

    public void insert(ActionEvent actionEvent) {



        String name = tName.getText();
        String email = tEmail.getText();
        String password = tPassword.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/ csd_214_lab2_suman";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `login_table`( `Name`, `Email`, `Password`) VALUES ('"+Name+"','"+Email+"','"+Password+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void update(ActionEvent actionEvent) {
        String Id = tId.getText();
        String Name = tName.getText();
        String Email = tEmail.getText();
        String Password = tPassword.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/ csd_214_lab2_suman";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `login_table` SET `Name`='"+Name+"',`Email`='"+Email+"',`Password`='"+Password+"' WHERE Id='"+Id+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(ActionEvent actionEvent) {

        String Id = tId.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/ csd_214_lab2_suman";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `login_table` WHERE Id='"+Id+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void load(ActionEvent actionEvent) {

        String Id = tId.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/db_csd214_lab2";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM login_table WHERE Id='"+Id+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String Name = resultSet.getString("Name");
                String Email = resultSet.getString("Email");
                String Password = resultSet.getString("Password");

                tName.setText(Name);
                tEmail.setText(Email);
                tPassword.setText(Password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}