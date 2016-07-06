
--drop sequence tab_departments_seq;
--drop sequence tab_employees_seq;
--drop sequence zth_seq;
--drop table locations;
--drop table employees;
--drop table jobs;
--drop table departments;


CREATE TABLE LOCATIONS (
  LOCATION_ID    NUMBER PRIMARY KEY,
  STREET_ADDRESS VARCHAR2(40),
  POSTAL_CODE    VARCHAR2(12),
  CITY           VARCHAR2(30) NOT NULL,
  STATE_PROVINCE  VARCHAR2(25)
);


CREATE TABLE DEPARTMENTS (
  DEPARTMENT_ID    NUMBER PRIMARY KEY,
  DEPARTMENT_NAME VARCHAR2(30),
  LOCATION_ID    NUMBER
);

CREATE TABLE JOBS (
  JOB_ID VARCHAR2(30) PRIMARY KEY,
  JOB_TITLE VARCHAR2(35),
  MIN_SALARY NUMBER,
  MAX_SALARY NUMBER
);

CREATE TABLE EMPLOYEES (
  EMPLOYEE_ID NUMBER PRIMARY KEY,
  FIRST_NAME VARCHAR2(20),
  LAST_NAME VARCHAR2(25) NOT NULL ,
  EMAIL VARCHAR2(25) NOT NULL,
  PHONE_NUMBER VARCHAR2(20),
  HIRE_DATE DATE NOT NULL ,
  JOB_ID VARCHAR2(30) NOT NULL ,
  SALARY NUMBER(8,2),
  COMMISSION_PCT NUMBER(2,2),
  MANAGER_ID NUMBER,
  DEPARTMENT_ID NUMBER
);

CREATE SEQUENCE TAB_DEPARTMENTS_SEQ
 START WITH     1
 INCREMENT BY   1;
CREATE SEQUENCE TAB_EMPLOYEES_SEQ
 START WITH     1
 INCREMENT BY   1;
CREATE SEQUENCE ZTH_SEQ
 START WITH     406
 INCREMENT BY   1;


ALTER TABLE EMPLOYEES ADD FOREIGN KEY (MANAGER_ID) REFERENCES EMPLOYEES (EMPLOYEE_ID);
ALTER TABLE EMPLOYEES ADD FOREIGN KEY (JOB_ID) REFERENCES JOBS(JOB_ID);
ALTER TABLE EMPLOYEES ADD FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENTS(DEPARTMENT_ID);
ALTER TABLE DEPARTMENTS ADD FOREIGN KEY (LOCATION_ID) REFERENCES LOCATIONS(LOCATION_ID);

COMMIT;


select * from departments;
select * from jobs;
select * from locations;
select first_name, last_name from employees;

select * from employees 
where department_id=50;

update employees
set salary = salary * 1.3
where department_id = 50;

update employees
set manager_id = null
where manager_id = 101;

delete from employees
where employee_id = 101;

select * from employees
where job_id = 'IT_PROG'
order by first_name;

select count(employee_id) from employees emp 
where emp.JOB_ID = 'IT_PROG';

select * from employees emp
join departments dep on emp.DEPARTMENT_ID = dep.DEPARTMENT_ID
where emp.department_id = 50;

select * from employees emp
join departments dep on emp.DEPARTMENT_ID = dep.DEPARTMENT_ID
where dep.location_id = '1700';

create view show_view as
select emp.employee_id, emp.first_name, dep.department_name 
from employees emp, departments dep
where emp.department_id = dep.department_id;

select sysdate from dual;
select to_char(sysdate, 'dd-MM-yyyy') from dual;
select to_date ('25-11-2014', 'dd-MM-yyyy') from dual;

select Upper(first_name), lower(email) as email from employees ;
select 'first name:' || first_name as name, lower(email) as email from employees ;

select count(*) from employees;

select count(*) from employees
where JOB_ID = 'IT_PROG';

select count(*),department_id from employees
group by department_id;

select avg(salary) from employees
where department_id = 50;

select max(salary), min(salary) from employees emp
join departments dep on emp.DEPARTMENT_ID = dep.DEPARTMENT_ID
where dep.location_id = '1700';

select max(emp.salary), min(emp.salary) from employees emp, departments dep, locations loc
  where dep.location_id = loc.location_id 
  and loc.city = 'Seattle' 
  and emp.department_id = dep.department_id;
