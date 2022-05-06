INSERT INTO users (id, email, name, password)
VALUES (1, 'test@gmail.com', 'test', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');
INSERT INTO users (id, email, name, password)
VALUES (2, 'sai@gmail.com', 'sai', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'CLIENT');

INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 2);

INSERT INTO product (id, name, price)
VALUES (1, 'iPhone', 120);
INSERT INTO product (id, name, price)
VALUES (2, 'iPad', 90);
INSERT INTO product (id, name, price)
VALUES (3, 'Mac', 5);