package ro.teamnet.zth.appl.service.impl;

import ro.teamnet.zth.api.annotations.MyService;
import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.service.EmployeeService;

import java.util.List;

/**
 * Created by user on 7/15/2016.
 */
@MyService
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao emp = new EmployeeDao();

    @Override
    public List<Employee> findAllEmployees() {

        return  emp.getAllEmployees();
    }

    @Override
    public Employee findOneEmployee(Long id) {
        return emp.getEmployeeById(id);
    }

    @Override
    public void deleteOneEmploye(Long id) {
        emp.deleteEmployee(emp.getEmployeeById(id));
    }


}
