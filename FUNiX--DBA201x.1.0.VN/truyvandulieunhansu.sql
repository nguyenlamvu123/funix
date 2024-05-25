1. select first_name, last_name, job_id, salary from employees where first_name like "s%";

2. select employee_id, first_name, last_name, job_id, salary from employees where salary =
(select max(salary) from employees);

3. select employee_id, first_name, last_name, job_id, salary from employees where salary =
(select max(salary) from
(select salary from employees where salary < 
(select max(salary) from employees
)) as a);

4. select employee_id, first_name, last_name, job_id, salary from employees where salary =
(select max(salary) from
(select salary from employees where salary <
(select max(salary) from
(select salary from employees where salary < 
(select max(salary) from employees
)) as aa)) as a);

5. select concat(employees.first_name, " ", employees.last_name) as employee, employees.salary as emp_sal, sssss.manname, sssss.mansa from employees join (select employee_id as manid, concat(first_name, " ", last_name) as manname, salary as mansa from employees) as sssss on manager_id = manid order by employee;

6. select sssss.manid, count(employees.employee_id) as number_of_reported, sssss.manname from employees join(select employee_id as manid, concat(first_name, " ", last_name) as manname, salary as mansa from employees) as sssss on employees.manager_id = sssss.manid group by employees.manager_id order by number_of_reported asc;

7. select count(employees.employee_id) as emp_count, departments.department_name from employees join departments on departments.department_id = employees.department_id group by employees.department_id order by emp_count desc;

8. select year(hire_date) as year, count(employee_id) as ce from employees group by year order by ce desc;

9. select max(salary), min(salary), round(avg(salary)) from employees;

10. select concat(employees.first_name, " ", employees.last_name) as employee, salary, case when 2000 <= salary and salary < 5000 then "low" when 5000 <= salary and salary < 10000 then "mid" else "high" end as sal_level from employees;

select concat(employees.first_name, " ", employees.last_name) as employee, phone_number from employees;

#select concat(employees.first_name, " ", employees.last_name) as employee, concat(substring(phone_number, 1, 3),"-", substring(phone_number, 5, 7), "-", substring(phone_number, 9, 12)) from employees;
11. select concat(employees.first_name, " ", employees.last_name) as employee, replace(phone_number, ".", "-") from employees;

12. select concat(employees.first_name, " ", employees.last_name) as employee, hire_date from employees where month(hire_date) = 8 and year(hire_date) = 1994;

13. SELECT concat(employees.first_name, " ", employees.last_name) as name, employees.salary, employees.department_id, de.department_name FROM employees  join departments as de on de.department_id = employees.department_id WHERE salary > (SELECT AVG(salary) FROM employees) order by department_id;

14. select emp.department_id, dep.department_name, max(emp.salary) from employees as emp join departments as dep on dep.department_id = emp.department_id group by emp.department_id order by emp.department_id;

15. select concat(employees.first_name, " ", employees.last_name) as employee, salary from employees order by salary limit 5;

16. select lower(first_name) as name, reverse(lower(first_name)) as rever_name from employees;

17. select concat(employees.first_name, " ", employees.last_name) as employee, hire_date from employees where day(hire_date) > 15;

18. select employees.department_id, concat(employees.first_name, " ", employees.last_name) as employee, sssss.mandep, sssss.manname from employees join(select employee_id as manid, concat(first_name, " ", last_name) as manname, department_id as mandep from employees) as sssss on manager_id = manid where not employees.department_id = sssss.mandep order by sssss.manname;
