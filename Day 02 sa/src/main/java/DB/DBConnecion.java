package DB;

import Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnecion {

    private  List<Customer> customerlist;
    private static DBConnecion instance;

    private DBConnecion(){
        customerlist = new ArrayList<>();
    }

    public List<Customer> getConnection(){
        return  customerlist;
    }
    public static DBConnecion getInstance(){

        return instance==null? instance=new DBConnecion():instance;
    }

}
