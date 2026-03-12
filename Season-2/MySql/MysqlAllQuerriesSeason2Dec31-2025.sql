CREATE TABLE Employee1 (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50)
);

CREATE TABLE Salary (
    emp_id INT,
    month VARCHAR(20),
    salary_amount DECIMAL(10,2)
);


INSERT INTO Employee1 VALUES
(1, 'Alice'),
(2, 'Bob'),
(3, 'Charlie'),
(4, 'David');

INSERT INTO Salary VALUES
(1, 'January', 5000),
(2, 'January', 6000),
(3, 'January', 5500),
(1, 'February', 5200),
(2, 'February', 5800),
(4, 'February', 7000),
(3, 'March', 6500),
(4, 'March', 6800),
(1, 'March', 6000);

-- write an SQL query to find the highest salaried employee for each month along with the month name and salary.

SELECT 
    month,
    emp_name,
    salary_amount
FROM (
    SELECT 
        s.month,
        e.emp_name,
        s.salary_amount,
        ROW_NUMBER() OVER (PARTITION BY s.month ORDER BY s.salary_amount DESC) AS rn
    FROM Salary s
    JOIN Employee e ON s.emp_id = e.emp_id
) as ranked
WHERE rn = 1;

-- Find highest salary per department?
SELECT *
FROM (
  SELECT *, 
  RANK() OVER (PARTITION BY department ORDER BY salary DESC) rnk
  FROM employee
) t
WHERE rnk = 1;


CREATE TABLE employee (
  emp_id INT PRIMARY KEY,
  emp_name VARCHAR(50),
  department VARCHAR(50),
  manager_id INT,
  salary INT
);

INSERT INTO employee VALUES
(1, 'A', 'IT', NULL, 90000),
(2, 'B', 'IT', 1, 60000),
(3, 'C', 'HR', 1, 50000),
(4, 'D', 'HR', 3, 40000),
(5, 'E', 'IT', 2, 60000);

-- Find employees earning more than department average
SELECT *
FROM employee e
WHERE salary >
(
  SELECT AVG(salary)
  FROM employee
  WHERE department = e.department
);
-- Find employee name and manager name(sub querry /self join)
SELECT e.emp_name, (SELECT emp_name as managerName from employee  where emp_id = e.manager_id) from employee as e;
SELECT e.emp_name AS employee, m.emp_name AS manager
FROM employee e
LEFT JOIN employee m
ON e.manager_id = m.emp_id;
-- Find 2nd highest salary department wise
SELECT emp_name, salary,department
FROM employee e1
WHERE salary = (
    SELECT DISTINCT salary
    FROM employee e2
    WHERE e1.department = e2.department
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
);
-- Second highest salary
SELECT DISTINCT salary
FROM employee
ORDER BY salary DESC
LIMIT 1 OFFSET 1;

SELECT MAX(salary)
FROM employee
WHERE salary < (SELECT MAX(salary) FROM employee);



