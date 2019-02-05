-- INSERT INTO NATIONAL_INSURANCE_NUMBERS (id, nat_number) VALUES (8000, 'NP111111C');
-- INSERT INTO NATIONAL_INSURANCE_NUMBERS (id, nat_number) VALUES (8001, 'NP222222C');
-- INSERT INTO NATIONAL_INSURANCE_NUMBERS (id, nat_number) VALUES (8002, 'NP333333C');
-- INSERT INTO NATIONAL_INSURANCE_NUMBERS (id, nat_number) VALUES (8003, 'NP444444C');
--
-- INSERT INTO USERS (id, username, email, gender, date_created, description, nat_id) VALUES (1000, 'whay', 'will.hay@example.com', 'MALE', sysdate(), 'Hello', 8000);
-- INSERT INTO USERS (id, username, email, gender, date_created, description, nat_id) VALUES (1001, 'gmoffatt', 'graham.moffatt@example.com', 'MALE', sysdate(), 'Hello', 8001);
-- INSERT INTO USERS (id, username, email, gender, date_created, description, nat_id) VALUES (1002, 'mmarriott', 'moore.marriott@example.com', 'MALE', sysdate(), 'Hello', 8002);
-- INSERT INTO USERS (id, username, email, gender, date_created, description, nat_id) VALUES (1003, 'glorimer', 'glennis.lorimer@example.com', 'FEMALE', sysdate(), 'Hello', 8003);

INSERT INTO ADDRESS (id, street1, city) VALUES ( 9000, 'One Java Lane', 'Milton Keynes');
INSERT INTO ADDRESS (id, street1, city) VALUES ( 9001, 'One Python Lane', 'London');
INSERT INTO ADDRESS (id, street1, city) VALUES ( 9002, 'One C++ Lane', 'Liverpool');
INSERT INTO ADDRESS (id, street1, city) VALUES ( 9003, 'One Javascript Lane', 'Birmingham');

INSERT INTO USERS (id, username, email, gender, date_created, description, address_id) VALUES (1000, 'whay', 'will.hay@example.com', 'MALE', sysdate(), 'Hello', 9000);
INSERT INTO USERS (id, username, email, gender, date_created, description, address_id) VALUES (1001, 'gmoffatt', 'graham.moffatt@example.com', 'MALE', sysdate(), 'Hello', 9001);
INSERT INTO USERS (id, username, email, gender, date_created, description, address_id) VALUES (1002, 'mmarriott', 'moore.marriott@example.com', 'MALE', sysdate(), 'Hello', 9002);
INSERT INTO USERS (id, username, email, gender, date_created, description, address_id) VALUES (1003, 'glorimer', 'glennis.lorimer@example.com', 'FEMALE', sysdate(), 'Hello', 9003);

INSERT INTO NATIONAL_INSURANCE_NUMBERS (id, nat_number) VALUES (1000, 'NP111111C');
INSERT INTO NATIONAL_INSURANCE_NUMBERS (id, nat_number) VALUES (1001, 'NP222222C');
INSERT INTO NATIONAL_INSURANCE_NUMBERS (id, nat_number) VALUES (1002, 'NP333333C');
INSERT INTO NATIONAL_INSURANCE_NUMBERS (id, nat_number) VALUES (1003, 'NP444444C');

INSERT INTO ROLES (id, role_name) VALUES (5000, 'ADMIN');
INSERT INTO ROLES (id, role_name) VALUES (5001, 'USER');
INSERT INTO ROLES (id, role_name) VALUES (5002, 'DATALOADER');

INSERT INTO USER_ROLE (user_id, role_id) VALUES ( 1000, 5000 );
INSERT INTO USER_ROLE (user_id, role_id) VALUES ( 1000, 5001 );
INSERT INTO USER_ROLE (user_id, role_id) VALUES ( 1001, 5001 );
INSERT INTO USER_ROLE (user_id, role_id) VALUES ( 1002, 5001 );
INSERT INTO USER_ROLE (user_id, role_id) VALUES ( 1003, 5001 );
INSERT INTO USER_ROLE (user_id, role_id) VALUES ( 1003, 5002 );

