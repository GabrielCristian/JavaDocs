package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;

/**
 * Created by user on 7/14/2016.
 */
@MyController(urlPath = "/employees")
public class EmployeeController {
    @MyRequestMethod(urlPath = "/one")
    public String getOneEmployee() {
        return "oneEmp";
    }
    @MyRequestMethod(urlPath = "/all")
    public String getAllEmployees() {
//        String allEmployees ="ceva ";
//        allEmployees += new EmployeeDao().getAllEmployees().size();
//        allEmployees +=" e";
        return "allEmp";
    }
//
//    private String toString(List<Employee> employeeList) {
//        String str = "";
//        for (Employee employee : employeeList) {
//            str += employee.getFirstName() + " " + employee.getLastName();
//        }
//
//        return str;
//    }
}
