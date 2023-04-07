# kel4-BEJ-paymentCRUD
CRUD Using Spring Boot

#Create Database First
command: 
createdb -U postgres BINAR

#Create Table
command: 
CREATE TABLE payment(payment_id serial PRIMARY KEY, 
customer_id int NOT NULL, staff_id int NOT NULL, 
rental_id int NOT NULL, amount float NOT NULL, payment_date date NOT NULL, last_update date NOT NULL);

