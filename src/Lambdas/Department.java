package Lambdas;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employees> employeesList;

    public Department(String name) {
        this.name = name;
        this.employeesList = new ArrayList<>();
    }

    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void addEmployee(Employees employees){this.employeesList.add(employees);}
}
