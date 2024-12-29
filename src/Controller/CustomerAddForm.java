package Controller;

import Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerAddForm implements Initializable {

    @FXML
    private ComboBox cmbTitle;

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
    private TextField txtAddress;

    @FXML
    private DatePicker txtDOB;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSalary;

    List<Customer> customerList = new ArrayList<>();

    @FXML
    void btnAddCustomerOnAction(ActionEvent event) {
        String id = txtId.getText();
        String title = cmbTitle.getValue().toString();
        String name =title + txtName.getText();
        LocalDate dateOfBirth = txtDOB.getValue();
        String address = txtAddress.getText();
        Double salary = Double.parseDouble(txtSalary.getText());

//        System.out.println(id + name + title + dateOfBirth + address + salary);
        Customer customer = new Customer(id, name, title, address, dateOfBirth, salary);

        customerList.add(customer);

        loadTable();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCmb();
    }

    private void loadCmb() {
        ObservableList<String> titleList = FXCollections.observableArrayList();
        titleList.add("MR.");
        titleList.add("MRS.");
        titleList.add("MISS. ");

        cmbTitle.setItems(titleList);


    }

    private void loadTable(){

        ObservableList<Customer> cutomerObserverList =   FXCollections.observableArrayList();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory((new PropertyValueFactory<>("salary")));

        customerList.forEach(obj ->{

            cutomerObserverList.add(obj);
        });
        tblCutomerView.setItems(cutomerObserverList);


    }




}
