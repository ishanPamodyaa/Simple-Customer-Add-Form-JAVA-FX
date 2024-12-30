package Controller;

import DB.DBConnecion;
import Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    @FXML
    private ComboBox cmbTitle;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSalary;

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

//  List<Customer customerList =  new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        loadCmb();
    }
    @FXML
    void btnAddCustomerOnAction(ActionEvent event) {
//        DBConnecion.getInstance().getConnection().add(new Customer(
//                txtId.getText(),
//                cmbTitle.getValue().toString(),
//                cmbTitle.getValue().toString()+txtName.getText(),
//                txtDOB.getValue(),
//                txtAddress.getText(),
//                Double.parseDouble(txtSalary.getText())));

        loadTable();
}

    private void loadCmb(){

     ObservableList<String> titleList =FXCollections.observableArrayList();
        titleList.add("Mr. ");
        titleList.add("Mrs. ");
        titleList.add("Miss. ");

        cmbTitle.setItems(titleList);
    }

    private  void loadTable(){
       ObservableList<Customer> customerObservableList  = FXCollections.observableArrayList();

       DBConnecion.getInstance().getConnection().forEach(customer ->{

        customerObservableList.add(customer);
       });

        tblCutomerView.setItems(customerObservableList);
    }

    public void btnViewAllOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/viewController.fxml"))) );
        stage.show();
    }
}
