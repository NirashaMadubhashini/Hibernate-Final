DROP DATABASE IF EXISTS `sipsewana_institute`;
CREATE DATABASE IF NOT EXISTS `sipsewana_institute`;
SHOW DATABASES ;
USE `sipsewana_institute`;

#-------------------
DROP TABLE IF EXISTS Student;
CREATE TABLE IF NOT EXISTS Student(
   NIC VARCHAR(15),
   name VARCHAR(45) NOT NULL DEFAULT 'Unknown',
   birthDay VARCHAR(15),
   address VARCHAR(30),
   age INT,
   mobileNumber VARCHAR(15),
   gender VARCHAR(10),
   date VARCHAR(15),
   time VARCHAR(15),
   CONSTRAINT PRIMARY KEY (NIC)
);
SHOW TABLES ;
DESCRIBE Student;

#------------------------
DROP TABLE IF EXISTS Programes;
CREATE TABLE IF NOT EXISTS Programes(
   programID VARCHAR(15),
   programName VARCHAR(45) NOT NULL DEFAULT 'Unknown',
   duration VARCHAR(30),
   fee DOUBLE DEFAULT 0.00,
   date VARCHAR(15),
   time VARCHAR(15),
   CONSTRAINT PRIMARY KEY (programID)
);
SHOW TABLES ;
DESCRIBE Programes;

#---------------------
DROP TABLE IF EXISTS Registration;
CREATE TABLE IF NOT EXISTS Registration(
   registerID VARCHAR(15),
   NIC VARCHAR(15),
   orderDate VARCHAR(15),
   orderTime VARCHAR(15),
   CONSTRAINT PRIMARY KEY (registerID),
   CONSTRAINT FOREIGN KEY (NIC) REFERENCES Student(NIC) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE Registration;


