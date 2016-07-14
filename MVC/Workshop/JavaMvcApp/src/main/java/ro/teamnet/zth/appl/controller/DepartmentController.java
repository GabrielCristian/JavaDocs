package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.dao.DepartmentDao;

/**
 * Created by user on 7/14/2016.
 */
@MyController(urlPath = "/departments")
public class DepartmentController {
    @MyRequestMethod(urlPath = "/one")
    public String getOneDepartment() {
        return "oneDep";
    }
    @MyRequestMethod(urlPath = "/all")
    public String getAllDepartments() {
        String allDepartments = new String();
        //allDepartments = new DepartmentDao().findAllDepartments().toString();
        return "allDep";
    }
}
