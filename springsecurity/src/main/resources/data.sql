delete from users_roles;
delete  from role;
delete  from product;
delete  from users;

INSERT INTO users (id, email, firstname, lastname, password)
VALUES (1, 'admin@miu.edu', 'umur', 'inan', '123'); --123
INSERT INTO users (id, email, firstname, lastname, password)
VALUES (2, 'user@miu.edu', 'john', 'doe', '123'); --123

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'USER');

INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 2);

INSERT INTO product (id, name, price, id_user)
VALUES (1, 'iPhone', 1200, 1);
INSERT INTO product (id, name, price, id_user)
VALUES (2, 'iPad', 900, 1);
INSERT INTO product (id, name, price, id_user)
VALUES (3, 'Pen', 5, 1);

