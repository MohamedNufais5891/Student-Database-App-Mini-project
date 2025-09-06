-- Create Database
CREATE DATABASE IF NOT EXISTS studentdb;

-- Use Database
USE studentdb;

-- Create Students Table
CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    grade VARCHAR(10) NOT NULL
);

-- Insert Sample Data
INSERT INTO students (name, age, grade) VALUES
('Alice', 20, 'A'),
('Bob', 22, 'B'),
('Charlie', 19, 'A');
