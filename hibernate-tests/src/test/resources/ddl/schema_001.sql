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

-- skill
DROP TABLE IF EXISTS skill;
DROP SEQUENCE IF EXISTS skill_seq;
CREATE SEQUENCE skill_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE skill (
  id_skill    NUMBER PRIMARY KEY,
  title       VARCHAR(20) NOT NULL,
  years       NUMBER      NOT NULL DEFAULT 1,
  id_employee NUMBER(19)  NOT NULL,
  CONSTRAINT fk_skill_employee FOREIGN KEY (id_employee)
  REFERENCES employee (id_employee),
  CONSTRAINT skill_title_uq UNIQUE (id_employee, title)
);

-- task
DROP TABLE IF EXISTS task;
DROP SEQUENCE IF EXISTS task_seq;
CREATE SEQUENCE task_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE task (
  id_task       NUMBER(19) PRIMARY KEY,
  description   VARCHAR(255) NOT NULL,
  estimate      NUMBER,
  high_priority NUMBER(1)    NOT NULL DEFAULT 0,
  create_date   DATE         NOT NULL,
  modify_date   DATE,
  id_employee   NUMBER(19),
  CONSTRAINT fk_task_employee FOREIGN KEY (id_employee)
  REFERENCES employee (id_employee)
);