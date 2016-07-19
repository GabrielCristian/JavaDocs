package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.service.EmployeeService;
import ro.teamnet.zth.appl.service.impl.EmployeeServiceImpl;

import java.util.List;

/**
 * Created by user on 7/14/2016.
 */
@MyController(urlPath = "/employees")
public class EmployeeController {

//    private final EmployeeService employeeService;
//
//    public EmployeeController (EmployeeService employeeService) {
//
//        this.employeeService = employeeService;
//    }

    @MyRequestMethod(urlPath = "/one", methodType = "GET")
    public Employee getOneEmployee(@MyRequestParam(name="id") Long id) {
        EmployeeDao emp = new EmployeeDao();

        return emp.getEmployeeById(id);
    }

    @MyRequestMethod(urlPath = "/one", methodType = "DELETE")
    public String deleteOneEmployee(@MyRequestParam(name="id") Long id) {
        EmployeeDao emp = new EmployeeDao();
        emp.deleteEmployee(new EmployeeDao().getEmployeeById(id));
        return "Deleted";
    }

    @MyRequestMethod(urlPath = "/add")
    public String addOneEmployee(@MyRequestParam(name="id") Long id) {
        EmployeeDao emp = new EmployeeDao();
        emp.deleteEmployee(new EmployeeDao().getEmployeeById(id));
        return "Deleted";
    }


    @MyRequestMethod(urlPath = "/all")
    public List<Employee> getAllEmployees() {
        EmployeeService service = new EmployeeServiceImpl();
        return service.findAllEmployees();
//        String allEmployees ="test->";
//        allEmployees += toString(new EmployeeDao().getAllEmployees());
//        return allEmployees;
    }

//    private String toString(List<Employee> employeeList) {
//        String str = "";
//        for (Employee employee : employeeList) {
//            str += employee.getFirstName() + " " + employee.getLastName();
//        }
//
//        return str;
//    }
}
