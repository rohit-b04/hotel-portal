SQL Commands to run:

This file contains information on creating a database for the Hotel Management System project. 
It's assumed that this process is performed at MySQL command line.

Tasks:
1. Create Database
SQL Command: 
create database hms;

2. Switch to the hms database just created
SQL Command:
use hms;

3. Create login table
SQL Command:
create table login (
    username varchar(255),
    password varchar(255)
);

4. Insert values into login table 
insert into login
values ('admin', '12345');

5. Create customer table
SQL Command:
create table customer (
    id varchar(255),
    number varchar(255),
    name varchar(255),
    gender varchar(255),
    country varchar(255),
    room_number varchar(255),
    status varchar(255),
    deposit varchar(255)
);

6. Create room table
SQL Command:
create table room (
    room_number varchar(255),
    availability varchar(255),
    clean_status varchar(255),
    price varchar(255),
    bed_type varchar(255)
);

7. Create employee table
SQL Command:
create table employee (
    name varchar(255),
    age varchar(255),
    gender varchar(255),
    job varchar(255),
    salary varchar(255),
    phone varchar(255),
    aadhar varchar(255),
    email varchar(225)
);

8. Create driver table
SQL Command:
create table driver (
    name varchar(255),
    age varchar(255),
    gender varchar(255),
    company varchar(255),
    brand varchar(255),
    available varchar(255),
    location varchar(255)
);
