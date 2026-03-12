CREATE TABLE department3 (
  dept_id INT PRIMARY KEY,
  dept_name VARCHAR(30)
);

CREATE TABLE employee3 (
  emp_id INT PRIMARY KEY,
  emp_name VARCHAR(50),
  salary INT,
  dept_id INT,
  FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);
INSERT INTO department3 VALUES
(1,'IT'), (2,'HR'), (3,'FIN');

INSERT INTO employee3 VALUES
(1,'A',90000,1),
(2,'B',60000,1),
(3,'C',70000,2),
(4,'D',50000,2),
(5,'E',80000,3);
-- Display each department name with total number of employees
-- Display department name and average salary
-- Find highest paid employee in each department

SELECT d.dept_name, e.emp_name, e.salary
FROM (
    SELECT emp_id, emp_name, salary, dept_id,
           ROW_NUMBER() OVER (PARTITION BY dept_id ORDER BY salary DESC) AS rnk
    FROM employee3
) e
JOIN department3 d
ON d.dept_id = e.dept_id
WHERE e.rnk = 1;

SELECT dept_name, emp_name, salary
FROM (
  SELECT d.dept_name, e.emp_name, e.salary,
  RANK() OVER (PARTITION BY d.dept_name ORDER BY e.salary DESC) rnk
  FROM department d
  JOIN employee e ON d.dept_id = e.dept_id
) t
WHERE rnk = 1;


SELECT d.dept_name, e.emp_name, e.salary
FROM employee3 e
JOIN department3 d ON e.dept_id = d.dept_id
WHERE (e.dept_id, e.salary) IN (
    SELECT dept_id, MAX(salary)
    FROM employee3
    GROUP BY dept_id
);
-- Second highest salary per department
-- Employees earning more than department average
 SELECT e.emp_name, d.dept_name, e.salary FROM employee e JOIN department d ON e.dept_id = d.dept_id 
 WHERE e.salary > ( SELECT AVG(salary) FROM employee WHERE dept_id = e.dept_id );



