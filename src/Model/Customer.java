package Model;

import java.time.LocalDate;

public class Customer {

    private  String id;
    private  String name;
    private String title;
    private String address;
    private LocalDate dob;
    private  Double salary;

    public Customer(String id, String name, String title, String address, LocalDate dob, Double salary) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.address = address;
        this.dob = dob;
        this.salary = salary;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", salary=" + salary +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
