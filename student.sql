CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE student (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  course VARCHAR(50),
  fee DOUBLE
);
