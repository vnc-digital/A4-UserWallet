DROP TABLE IF EXISTS user;
 
CREATE TABLE user (
user_id VARCHAR(250) PRIMARY KEY,
user_name VARCHAR(250) NOT NULL,
name VARCHAR(250) NOT NULL,
email VARCHAR(250) NOT NULL,
mobile_no INT NOT NULL,
password VARCHAR(250) NOT NULL,
address VARCHAR(250) NOT NULL,
wallet_amount FLOAT DEFAULT NULL,
created_date DATE,
updated_date DATE,
active_status  VARCHAR(250),
deleted_date DATE
);

DROP TABLE IF EXISTS wallet;
 
CREATE TABLE wallet (
  transaction_id VARCHAR(250) PRIMARY KEY,
  transaction_type VARCHAR(250) DEFAULT NULL,
  transaction_amount FLOAT DEFAULT NULL,
  transaction_date DATE,
  purpose VARCHAR(250) DEFAULT NULL,
  user_id VARCHAR(250) ,
  FOREIGN KEY (user_id) REFERENCES user (user_id)
);
