CREATE DATABASE banking_system;

USE banking_system;

CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    balance DOUBLE DEFAULT 0
);

CREATE TABLE transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    type VARCHAR(20),
    amount DOUBLE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
