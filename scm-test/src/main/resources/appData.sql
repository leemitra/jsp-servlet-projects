insert into user_role(id,role_name, role_description) values (1,'ADMIN', 'Admin role' );
insert into user_role(id,role_name, role_description) values (2,'USER', 'User role' );
insert into user_login (user_name, user_pass, email, phone, full_name,role_id) values ('admin','admin', 'admin@gmail.com ', '99009090900','Admin',1);
insert into user_login (user_name, user_pass, email, phone, full_name,role_id) values ('ajay','12345', 'ajay@gmail.com ', '9988998765','Ajay',2);
insert into user_login (user_name, user_pass, email, phone, full_name,role_id) values ('john','123456', 'john@gmail.com ', '9900998778','John',2);
