package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.util.Date;

/**
 * Created by user on 7/7/2016.
 */
@Table(name = "EMPLOYESS")
public class Employees {
    @Id(name = "Employee_id")
        private long employeeId;
    @Column(name = "first_name")
        private String firstName;
    @Column(name = "last_name")
        private String lastName;
    @Column(name = "email")
        private String email;
    @Column(name = "phone_number")
        private String phoneNumber;
    @Column(name = "hire_date")
        private Date hireDate;
    @Column(name = "job_id")
        private Job jobId;
    @Column(name = "salary")
        private long salary;
    @Column(name = "commission_pct")
        private double commissionPct;
    @Column(name = "manager_id")
        private Employees managerId;
    @Column(name = "department_id")
        private Department departmentId;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Job getJobId() {
        return jobId;
    }

    public void setJobId(Job jobId) {
        this.jobId = jobId;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Employees getManagerId() {
        return managerId;
    }

    public void setManagerId(Employees managerId) {
        this.managerId = managerId;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(double commissionPct) {
        this.commissionPct = commissionPct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employees employees = (Employees) o;

        if (employeeId != employees.employeeId) return false;
        if (salary != employees.salary) return false;
        if (Double.compare(employees.commissionPct, commissionPct) != 0) return false;
        if (firstName != null ? !firstName.equals(employees.firstName) : employees.firstName != null) return false;
        if (!lastName.equals(employees.lastName)) return false;
        if (!email.equals(employees.email)) return false;
        if (phoneNumber != null ? !phoneNumber.equals(employees.phoneNumber) : employees.phoneNumber != null)
            return false;
        if (!hireDate.equals(employees.hireDate)) return false;
        if (!jobId.equals(employees.jobId)) return false;
        if (managerId != null ? !managerId.equals(employees.managerId) : employees.managerId != null) return false;
        return departmentId != null ? departmentId.equals(employees.departmentId) : employees.departmentId == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (employeeId ^ (employeeId >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + hireDate.hashCode();
        result = 31 * result + jobId.hashCode();
        result = 31 * result + (int) (salary ^ (salary >>> 32));
        temp = Double.doubleToLongBits(commissionPct);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", jobId=" + jobId +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", managerId=" + managerId +
                ", departmentId=" + departmentId +
                '}';
    }
}
