insert into roles (name) value ('CUSTOMER');
insert into roles (name) value ('MANAGER');

insert into users (email, first_name, password, last_name, age) VALUES ('adminTravel_agency@gmail.com','admin','$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG', 'admin', 23);
insert into user_roles (user_id, role_id) values (1,2);
