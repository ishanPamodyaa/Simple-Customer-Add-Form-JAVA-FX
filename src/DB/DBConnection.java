package DB;

import Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private List<Customer> customerList;
    private static DBConnection instance;
    private DBConnection(){
        customerList = new ArrayList<>();
    }

    public List<Customer> getConnection(){
        return  customerList;
    }
    public static DBConnection getInstance(){
        return instance==null? instance = new DBConnection(): instance;
    }
}
