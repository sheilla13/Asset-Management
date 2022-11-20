USE db_asset;

-- category 
CREATE TABLE category(
	id int(11) NOT NULL PRIMARY KEY auto_increment,
    name varchar(50) NOT NULL
);

-- asset
CREATE TABLE asset(
	id int(11) NOT NULL PRIMARY KEY auto_increment,
    name varchar(50) NOT NULL,
    serial_number varchar(50) NOT NULL UNIQUE
);

-- CREATE TABLE loan_master(
-- 	id int(11) NOT NULL PRIMARY KEY auto_increment,
--     status enum('pending', 'success', 'reject'),
--     submit_date datetime NOT NULL
-- );

CREATE TABLE user(
	id int(11) NOT NULL PRIMARY KEY auto_increment,
    full_name varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    password varchar(255) NOT NULL
);

-- CREATE TABLE loan_detail(
-- 	loan_master_id int(11) NOT NULL,
--     user_id int(11) NOT NULL,
--     asset_id int(11) NOT NULL,
--     FOREIGN KEY (loan_master_id) REFERENCES loan_master(id),
--     FOREIGN KEY (user_id) REFERENCES user(id),
--     FOREIGN KEY (asset_id) REFERENCES asset(id)
-- );

CREATE TABLE loan(
    id int(11) NOT NULL PRIMARY KEY auto_increment,
    user_id int(11),
    asset_id int(11) NOT NULL,
    status enum('pending', 'success', 'reject'),
    submit_date datetime NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (asset_id) REFERENCES asset(id)
);

INSERT INTO user (id, full_name, email, password) VALUES (1, 'sheilla', 'sheilla@gmail.com', 'Bismillah');
INSERT INTO user (id, full_name, email, password) VALUES (2, 'rizki', 'rizki@gmail.com', 'Bismillah');

SELECT * FROM user;

INSERT INTO category (id, name) VALUES (1, 'electronics');
INSERT INTO category (id, name) VALUES (2, 'vehicles');

SELECT * FROM category;

INSERT INTO asset (id, name, serial_number) VALUES (1, 'laptop asus', 'ASUS-1072009');
INSERT INTO asset (id, name, serial_number) VALUES (2, 'laptop hp', 'HP-1060200');
INSERT INTO asset (id, name, serial_number) VALUES (3, 'motor vario', 'VARIO-1050320');

SELECT * FROM asset;

ALTER TABLE loan_master ADD submit_date datetime NOT NULL;

INSERT INTO loan_master (id, status, submit_date) VALUES (1, 'success', '2022-11-03 09:15:57');
INSERT INTO loan_master (id, status, submit_date) VALUES (2, 'pending', '2022-11-04 11:25:02');
INSERT INTO loan_master (id, status, submit_date) VALUES (3, 'reject', '2022-11-05 07:30:32');

SELECT * FROM loan_master;

INSERT INTO loan_detail (loan_master_id, user_id, asset_id) VALUES (1, 1, 3);
INSERT INTO loan_detail (loan_master_id, user_id, asset_id) VALUES (2, 2, 1);
INSERT INTO loan_detail (loan_master_id, user_id, asset_id) VALUES (3, 2, 2);