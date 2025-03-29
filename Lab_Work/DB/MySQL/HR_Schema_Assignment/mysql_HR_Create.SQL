Create database HR_SCHEMA;
use HR_SCHEMA;
CREATE TABLE regions
    ( region_id      int 
	, region_name    VARCHAR(25) 
    );

CREATE UNIQUE INDEX reg_id_pk
ON regions (region_id);

ALTER TABLE regions
ADD ( CONSTRAINT reg_id_pk PRIMARY KEY (region_id)
    ) ;


CREATE TABLE countries 
    ( country_id      CHAR(2)  NOT NULL ,
     country_name    VARCHAR(40) 
    , region_id       int 
    , CONSTRAINT     country_c_id_pk 
        	     PRIMARY KEY (country_id) 
    ); 
   
ALTER TABLE countries
ADD ( CONSTRAINT countr_reg_fk
        	 FOREIGN KEY (region_id)
          	  REFERENCES regions(region_id) 
    ) ;

CREATE TABLE locations
    ( location_id    int
    , street_address VARCHAR(40)
    , postal_code    VARCHAR(12)
    , city       VARCHAR(30)  NOT NULL
    , state_province VARCHAR(25)
    , country_id     CHAR(2)
    ) ;

ALTER TABLE locations
ADD ( CONSTRAINT loc_id_pk
       		 PRIMARY KEY (location_id)
    , CONSTRAINT loc_c_id_fk
       		 FOREIGN KEY (country_id)
        	  REFERENCES countries(country_id) 
    ) ;

CREATE TABLE departments
    ( department_id    int
    , department_name  VARCHAR(30)  NOT NULL
    , manager_id       int
    , location_id      int
    ) ;

ALTER TABLE departments
ADD ( CONSTRAINT dept_id_pk
       		 PRIMARY KEY (department_id)
    , CONSTRAINT dept_loc_fk
       		 FOREIGN KEY (location_id)
        	  REFERENCES locations (location_id)
     ) ;

CREATE TABLE jobs
    ( job_id         VARCHAR(10)
    , job_title      VARCHAR(35)
	  NOT NULL
    , min_salary     int
    , max_salary    int
    ) ;

ALTER TABLE jobs
ADD ( CONSTRAINT job_id_pk
      		 PRIMARY KEY(job_id)
    ) ;
CREATE TABLE employees
    ( employee_id    int
    , first_name     VARCHAR(20)
    , last_name      VARCHAR(25) NOT NULL
    , email          VARCHAR(25) NOT NULL
    , phone_number   VARCHAR(20)
    , hire_date      DATE  NOT NULL
    , job_id         VARCHAR(10)  NOT NULL
    , salary         decimal(8,2)
    , commission_pct decimal(2,2)
    , manager_id     int
    , department_id  int
    , CONSTRAINT     emp_salary_min
                     CHECK (salary > 0) 
    , CONSTRAINT     emp_email_uk
                     UNIQUE (email)
    ) ;

ALTER TABLE employees
ADD ( CONSTRAINT     emp_emp_id_pk
                     PRIMARY KEY (employee_id)
    , CONSTRAINT     emp_dept_fk FOREIGN KEY (department_id) REFERENCES departments(department_id)
    , CONSTRAINT     emp_job_fk
                     FOREIGN KEY (job_id)
                      REFERENCES jobs (job_id)
    ) ;

ALTER TABLE departments
ADD ( CONSTRAINT dept_mgr_fk
      		 FOREIGN KEY (manager_id)
      		  REFERENCES employees (employee_id)
    ) ;

CREATE TABLE job_history
    ( employee_id   int nOT NULL
    , start_date    DATE NOT NULL
    , end_date      DATE NOT NULL
    , job_id        VARCHAR(10) NOT NULL
    , department_id INT
    , CONSTRAINT    jhist_date_interval
                    CHECK (end_date > start_date)
    ) ;    
ALTER TABLE job_history
ADD ( CONSTRAINT jhist_emp_id_st_date_pk
      PRIMARY KEY (employee_id, start_date)
    , CONSTRAINT     jhist_job_fk
                     FOREIGN KEY (job_id)
                     REFERENCES jobs(job_id)
    , CONSTRAINT     jhist_emp_fk
                     FOREIGN KEY (employee_id)
                     REFERENCES employees(employee_id)
    , CONSTRAINT     jhist_dept_fk
                     FOREIGN KEY (department_id)
                     REFERENCES departments(department_id)
    ) ;

COMMIT;
