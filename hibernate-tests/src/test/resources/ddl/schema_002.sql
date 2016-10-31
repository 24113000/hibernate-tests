-- NOTE:
-- sequence should be created START WITH 1 INCREMENT BY allocationSize (50 by default)

-- employee
DROP TABLE IF EXISTS employee;
DROP SEQUENCE IF EXISTS employee_seq;
CREATE SEQUENCE employee_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE employee (
  id_employee NUMBER(19) PRIMARY KEY,
  name        VARCHAR(100) NOT NULL,
  salary      NUMBER,
  experience  NUMBER       NOT NULL DEFAULT 1
);

-- address
DROP TABLE IF EXISTS address;
DROP SEQUENCE IF EXISTS address_seq;
CREATE SEQUENCE address_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE address (
  id_address NUMBER(19) PRIMARY KEY,
  city       VARCHAR(100) NOT NULL,
  street     VARCHAR(100) NOT NULL
);

-- employee-address
DROP TABLE IF EXISTS employee_address;

CREATE TABLE employee_address (
  id_employee NUMBER(19) PRIMARY KEY,
  id_address  NUMBER(19) NOT NULL,
  CONSTRAINT fk_employee FOREIGN KEY (id_employee)
  REFERENCES employee (id_employee),
  CONSTRAINT fk_address FOREIGN KEY (id_address)
  REFERENCES address (id_address),
  CONSTRAINT unique_address UNIQUE (id_address)
);