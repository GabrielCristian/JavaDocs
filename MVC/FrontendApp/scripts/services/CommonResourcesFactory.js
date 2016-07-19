'use strict';

hrApp.factory('CommonResourcesFactory', function() {
        var baseUrl = "http://localhost:9090/app/mvc/";
        return {
            findAllDepartmentsUrl: baseUrl + "departments",
            findAllEmployeesUrl: baseUrl + "employees/all",
            findAllJobsUrl: baseUrl + "jobs/all",
            findAllLocationsUrl: baseUrl + "locations",
            findOneDepartmentUrl: baseUrl + "departments/",
            findOneEmployeeUrl: baseUrl + "employees/one",
            findOneJobUrl: baseUrl + "jobs/one",
            findOneLocationUrl: baseUrl + "locations/",
            deleteDepartmentUrl: baseUrl + "departments",
            deleteEmployeeUrl: baseUrl + "employees/one",
            deleteJobUrl: baseUrl + "jobs",
            deleteLocationUrl: baseUrl + "locations",
            addDepartmentUrl: baseUrl + "departments",
            addEmployeeUrl: baseUrl + "employees",
            addJobUrl: baseUrl + "jobs",
            addLocationUrl: baseUrl + "locations",
            editDepartmentUrl: baseUrl + "departments",
            editEmployeeUrl: baseUrl + "employees",
            editJobUrl: baseUrl + "jobs",
            editLocationUrl: baseUrl + "locations"
        };
    }
);