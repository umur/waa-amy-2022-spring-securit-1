-- DELETE FROM users;
INSERT INTO users (email,password,firstname,lastname)
VALUES('vulputate.mauris@yahoo.org',1958,'Hope','Parsons'),
    ('libero@yahoo.ca',1142,'Ethan','Hoffman'),
    ('gravida.sagittis@google.ca',1766,'Gabriel','Stone'),
    ('venenatis.vel@protonmail.org',1825,'Bianca','Alvarez'),
    ('sit.amet.nulla@icloud.edu',1502,'Geoffrey','Thompson'),
    ('purus.in.molestie@icloud.edu',1551,'Lacota','Foreman'),
    ('sit.amet@outlook.ca',1346,'Calvin','Slater'),
    ('nulla.cras@aol.ca',1122,'Xaviera','Robbins'),
    ('quam@outlook.net',1512,'Denton','Hess'),
    ('lectus.justo@outlook.net',1986,'Charity','Mccullough');


-- DELETE FROM address;
INSERT INTO address (street,zip,user_id)
VALUES
    ('9220 Sodales Rd.','2575',1),
    ('Ap #238-4482 Vestibulum Av.','76328',2),
    ('982-1060 Lectus. Ave','72845',3),
    ('995-4769 Tellus. Ave','43789',4),
    ('299-3445 Enim Road','85451',5),
    ('9285 Vivamus Rd.','65354-577',6),
    ('Ap #447-393 Lectus, Rd.','432882',7),
    ('Ap #273-7528 Luctus Street','520425',8),
    ('3551 Pellentesque Av.','6619',9),
    ('8373 Imperdiet St.','390895',10);


-- DELETE FROM review;
INSERT INTO review (comment,user_id)
VALUES
    ('semper tellus id nunc interdum feugiat.',1),
    ('cursus et, magna. Praesent interdum ligula eu enim. Etiam imperdiet',2),
    ('enim. Mauris quis turpis vitae purus',3),
    ('ornare, facilisis eget, ipsum. Donec sollicitudin adipiscing ligula. Aenean',4),
    ('ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed',2),
    ('consequat, lectus sit',4),
    ('Integer vitae nibh. Donec est mauris, rhoncus id, mollis nec,',5),
    ('dictum mi, ac mattis',6),
    ('ultrices iaculis odio. Nam interdum',10),
    ('dignissim magna a tortor. Nunc',10);
INSERT INTO review (comment,user_id)
VALUES
    ('consequat purus.',10),
    ('molestie tellus. Aenean egestas hendrerit neque.',10),
    ('diam luctus lobortis. Class aptent taciti sociosqu ad litora',1),
    ('felis, adipiscing fringilla, porttitor vulputate, posuere vulputate,',8),
    ('Quisque',10),
    ('elit pede, malesuada vel, venenatis',2),
    ('mi lorem, vehicula et, rutrum',1),
    ('dictum cursus. Nunc mauris elit, dictum eu,',3),
    ('Donec porttitor tellus non magna. Nam',5),
    ('nisl. Maecenas malesuada fringilla est. Mauris',1);
INSERT INTO review (comment,user_id)
VALUES
    ('aliquet',10),
    ('Nulla facilisi. Sed neque. Sed eget lacus. Mauris non',4),
    ('posuere cubilia Curae Donec tincidunt. Donec',1),
    ('dictum eu, placerat eget, venenatis a, magna. Lorem ipsum',3),
    ('dictum magna.',6),
    ('accumsan convallis, ante lectus convallis est, vitae sodales',7),
    ('Aenean gravida nunc',8),
    ('risus. Donec nibh',4),
    ('egestas. Duis',4),
    ('Phasellus fermentum convallis ligula. Donec',5);


INSERT INTO category (name)
VALUES
    ('Services'),
    ('Goods'),
    ('Shopping'),
    ('Experiences'),
    ('Convenience');

INSERT INTO product (name,price,rating,category_id,user_id)
VALUES
    ('erat','49.06',2,1,1),
    ('amet','14.32',2,5,2),
    ('per inceptos','68.06',2,2,3),
    ('in molestie','10.56',5,1,4),
    ('neque.','7.39',3,4,5),
    ('vitae','81.64',4,4,5),
    ('ultricies ligula.','24.97',4,3,4),
    ('nec tempus','42.53',2,4,3),
    ('Quisque purus','87.03',5,4,2),
    ('Proin vel','43.32',1,3,1);

-- INSERT INTO product (name,price,rating,category_id, user_id)
-- VALUES
--     ('diam. Proin','82.65',4,5),
--     ('eu,','67.40',2,3),
--     ('sagittis.','95.58',2,4),
--     ('fringilla euismod','33.24',5,4),
--     ('volutpat','82.86',5,3),
--     ('magna. Nam','33.41',2,5),
--     ('non,','2.26',4,3),
--     ('ultrices,','23.86',2,5),
--     ('a, arcu.','41.69',4,4),
--     ('non, sollicitudin','13.22',5,5);
-- INSERT INTO product (name,price,rating,category_id)
-- VALUES
--     ('mus. Donec','18.99',3,4),
--     ('Duis dignissim','30.86',3,1),
--     ('quis,','0.90',1,4),
--     ('hendrerit','79.94',3,3),
--     ('Sed','24.94',4,4),
--     ('vel','65.79',3,4),
--     ('ligula. Aenean','13.69',5,3),
--     ('consectetuer','68.47',3,2),
--     ('arcu','56.78',5,4),
--     ('ante. Nunc','55.87',2,2);




INSERT INTO role (role) VALUES ('ADMIN'), ('USER');

INSERT INTO users_roles(user_id, roles_id) VALUES (1, 1), (2, 1), (3, 1), (4, 1), (5, 1), (6, 2), (7, 2), (8, 2), (9, 2), (10, 2);