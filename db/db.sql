


create table tbl_clients(id int primary key auto_increment, name varchar(100),email varchar(100),
contact_no varchar(100), website varchar(100), address varchar(100),
created_date timestamp default current_timestamp, modified_date timestamp null, status boolean default true);






create table tbl_projects(id int primary key auto_increment,
 name varchar(100),description text,
client_id int, deadline date,budget int,
created_date timestamp default current_timestamp, 
modified_date timestamp null);

alter table tbl_projects add FOREIGN key(client_id) REFERENCES tbl_clients(id);



create table mst_project_status(id int primary key auto_increment,
 name varchar(100),color varchar(100),
created_date timestamp default current_timestamp, 
modified_date timestamp null);

create table tbl_eployees(id int primary key auto_increment,
 first_name varchar(100),last_name varchar(100),
email varchar(100), contact_no varchar(100), pan_no varchar(100),
created_date timestamp default current_timestamp, 
modified_date timestamp null,status boolean default true);
  
create table tbl_project_status(id int primary key auto_increment,
 project_id int,status_id int,
created_date timestamp default current_timestamp, 
modified_date timestamp null,remarks text);

alter table tbl_project_status add FOREIGN key(project_id) REFERENCES tbl_projects(id);

alter table tbl_project_status add FOREIGN key(status_id) REFERENCES mst_project_status(id);


create table tbl_project_employees(id int primary key auto_increment,
 project_id int,employee_id int,
created_date timestamp default current_timestamp
);


alter table tbl_project_employees add FOREIGN key(project_id) REFERENCES tbl_projects(id);
alter table tbl_project_employees add FOREIGN key(employee_id) REFERENCES tbl_eployees(id);

