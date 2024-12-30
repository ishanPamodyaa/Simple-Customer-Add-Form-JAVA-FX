package Controller;

import DB.DBConnecion;
import Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class ViewCustomerController {

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn colDOB;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colSalary;

    @FXML
    private TableView tblCutomerView;

    @FXML
    void btnReLoadOnAction(ActionEvent event) {

        loadCustomerTable();
    }

    private void loadCustomerTable(){

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade","root","root");
            Statement statetment = connection.createStatement();
            ResultSet resultSet= statetment.executeQuery("SELECT * FROM Customer");

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));

                DBConnecion.getInstance().getConnection().add(
                        new Customer(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getDouble(4)
                        ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

        DBConnecion.getInstance().getConnection().forEach(customer ->{
            customerObservableList.add(customer);
        });
        tblCutomerView.setItems(customerObservableList);
    }
}
