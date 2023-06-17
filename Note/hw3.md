## Database

Use MySQL to build employee and salary table and solve the followings:

```mysql
CREATE DATABASE SSITraining;
USE SSITraining;

CREATE TABLE employee(
    Empid int NOT NULL,
    FullName varchar(20) NOT NULL,
    ManagerId int NOT NULL,
    DateOfJoining date NOT NULL
);

CREATE TABLE Salary(
    EmpId int NOT NULL,
    Project varchar(10) NOT NULL,
    Salary int NOT NULL
);

INSERT INTO Employee(Empid, FullName, ManagerId, DateOfJoining)
VALUES
   (121, 'Jon Snow', 321, '01/31/2014'),
   (321, 'Night King', 986, '2015-01-30'),
   (421, 'Arya Stark', 876, '2016-11-27'),
   (521, 'Sansa Stark', 876, '2017-12-02'),
   (521, 'Sansa Stark', 876, '2017-12-02');

INSERT INTO Salary(Empid, Project, Salary)
VALUES
   (121, 'P1', 8000),
   (321, 'P2', 1000),
   (421, 'P1', 12000),
   (721, 'P3', 6000);
```

1. fetch the count of employees working in project 'P1'.
```mysql
SELECT COUNT(*)
FROM Salary
WHERE project = 'P1';
```
2. fetch employee names having salary greater than or equal to 5000 and less than or equal 10000.
```mysql
SELECT FullName
FROM employee
WHERE EmpId IN(
    SELECT EmpId
    FROM Salary
    WHERE Salary BETWEEN 5000 AND 10000
    );
```
3. fetch project-wise count of employees sorted by project's count in descending order.
```mysql
SELECT Project, COUNT(EmpId) count
FROM Salary
GROUP BY Project
ORDER BY count DESC;
```
4. fetch projects that include more than 1 employees
```mysql
SELECT Project
FROM Salary
GROUP BY Project
HAVING COUNT(EmpId) > 1;
```
5. fetch employee names and salary, if employee does not have salary, show salary as 0.
```mysql
SELECT e.FullName, COALESCE(s.Salary, 0)
FROM employee e
LEFT JOIN salary s ON e.EmpId = s.EmpId;
```
6. fetch all employees whose managers are also in the employee table
```mysql
SELECT *
FROM employee
WHERE ManagerId IN (
    SELECT EmpId
    FROM employee
);
```
7. fetch duplicate employee name in the employee table
```mysql
SELECT FullName 
FROM employee 
GROUP BY FullName
HAVING COUNT(*) > 1;
```
8. fetch employees who do not have salary
```mysql
SELECT *
FROM employee
WHERE EmpId NOT IN (
    SELECT EmpId
    FROM salary );
```
9. fetch current date and current timestamp
```mysql
SELECT CURDATE() date, CURTIME() time;
```
10. fetch employee who joined in year 2016
```mysql
SELECT *
FROM employee
WHERE YEAR(DateOfJoining) = 2016;
```
11. fetch employees and their salary who joined in "January"
```mysql
SELECT e.EmpId, e.FullName, e.ManagerId, e.DateOfJoining, s.salary
FROM employee e
         JOIN salary s on e.EmpId = s.EmpId
WHERE DATE_FORMAT(e.DateOfJoining, '%M') = 'January';
```

## 