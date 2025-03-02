CREATE DATABASE IF NOT EXISTS bc;

USE bc;

CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `number_id` varchar(20) DEFAULT NULL,
  `mobile_number` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_unique` (`number_id`),
  UNIQUE KEY `user_unique_1` (`email`)
);

CREATE TABLE `role`` (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);

CREATE TABLE `user_role`` (
    user_id INT,
    role_id INT,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);

CREATE TABLE `vehicle_type`` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50) NOT NULL
);

CREATE TABLE `vehicle`` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    number INT NOT NULL,
    user_associate_id INT NOT NULL,
    model VARCHAR(100),
    serial VARCHAR(100),
    marca VARCHAR(100),
    company VARCHAR(100),
    UNIQUE KEY `vehicle_unique` (number)
);

CREATE TABLE `payment_type`` (
    payment_type_id INT AUTO_INCREMENT PRIMARY KEY,
    payment_type_name VARCHAR(50) NOT NULL
);

CREATE TABLE `daily_payment`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    vehicle_id INT,
    daily_date DATE,
    payment_type_id INT,
    kilometer_start INT,
    kilometer_end INT,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id),
    FOREIGN KEY (payment_type_id) REFERENCES payment_type(payment_type_id)
);

CREATE TABLE `daily_payment_type`` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    daily_payment_type_id INT,
    amount DECIMAL(10, 2),
    FOREIGN KEY (daily_payment_type_id) REFERENCES daily_payment(id)
);

CREATE TABLE `discount_config`` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    amount DECIMAL(10, 2),
);

CREATE TABLE `expense_category` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE `expense_type`` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    expenses_category_id INT,
    FOREIGN KEY (expenses_category_id) REFERENCES expenses_category(id)
);

CREATE TABLE `expense` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    expense_type_id INT,
    vehicle_id INT,
    expense_date DATE,
    description VARCHAR(300),
    kilometer INT,
    amount DECIMAL(10,2),
    labour DECIMAL(10,2),
    workshop_id INT,
    FOREIGN KEY (workshop_id) REFERENCES workshop(id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(id),
    FOREIGN KEY (expense_type_id) REFERENCES expense_type(id)
);

CREATE TABLE `workshop`` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    direction VARCHAR(100),
    mobile_number VARCHAR(20)
);

INSERT INTO `role` (role_name) VALUES
	 ('ADMIN'),
	 ('OPERADOR'),
	 ('COLECTOR');

INSERT INTO `user` (first_name,last_name,number_id,mobile_number,email,created_at,password) VALUES
	 ('Richard','Rojas','14447876','2710698','richardroj@gmail.com','2024-10-06 14:12:21','$2a$10$P7nbymUqL/IbvX5NzpU/xeQ2jCAk0lzGeDAPnQ/6mNcl/NJCq6eR2'),
	 ('Alfredo','Flores','12777981','26345854','alfredoflores@gmail.com','2024-10-06 14:12:21','$2a$10$P7nbymUqL/IbvX5NzpU/xeQ2jCAk0lzGeDAPnQ/6mNcl/NJCq6eR2');

INSERT INTO `role` (role_name) VALUES
	 ('ADMIN');






