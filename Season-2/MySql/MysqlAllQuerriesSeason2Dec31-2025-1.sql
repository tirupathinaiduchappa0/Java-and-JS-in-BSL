CREATE TABLE department2 (
    depId INT PRIMARY KEY,
    name VARCHAR(50)
);
CREATE TABLE employee2 (
    eid INT,
    ename VARCHAR(50),
    esalary DECIMAL(10,2),
    depId INT
);
INSERT INTO department2 VALUES (10,'IT'), (20,'HR'), (30,'Sales');
INSERT INTO employee2 VALUES
(1,'Alice',80000,10),
(2,'Bob',90000,10),
(3,'Charlie',70000,20),
(4,'David',95000,20),
(5,'Eve',85000,10),
(6,'Frank',75000,30);
-- How to get department-wise highest salaried employee (name, salary, dept)?

SELECT d.name, sub.ename, sub.esalary
FROM (
    SELECT ename, esalary, depId,
           ROW_NUMBER() OVER (PARTITION BY depId ORDER BY esalary DESC) rn
    FROM employee2
) sub
JOIN department2 d ON sub.depId = d.depId
WHERE rn = 1;

-- self join manager name and employee name
-- Count employees under each manager
SELECT manager_id, COUNT(*)
FROM employee
WHERE manager_id IS NOT NULL
GROUP BY manager_id;

-- Managers earning less than employees
SELECT e.emp_name
FROM employee e
JOIN employee m
ON e.manager_id = m.emp_id
WHERE e.salary > m.salary;