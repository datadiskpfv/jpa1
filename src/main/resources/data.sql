-- INSERT INTO NATIONAL_INSURANCE_NUMBERS (id, nat_number) VALUES (8000, 'NP111111C');
-- INSERT INTO NATIONAL_INSURANCE_NUMBERS (id, nat_number) VALUES (8001, 'NP222222C');
-- INSERT INTO NATIONAL_INSURANCE_NUMBERS (id, nat_number) VALUES (8002, 'NP333333C');
-- INSERT INTO NATIONAL_INSURANCE_NUMBERS (id, nat_number) VALUES (8003, 'NP444444C');
--
-- INSERT INTO USERS (id, username, email, gender, date_created, description, nat_id) VALUES (1000, 'whay', 'will.hay@example.com', 'MALE', sysdate(), 'Hello', 8000);
-- INSERT INTO USERS (id, username, email, gender, date_created, description, nat_id) VALUES (1001, 'gmoffatt', 'graham.moffatt@example.com', 'MALE', sysdate(), 'Hello', 8001);
-- INSERT INTO USERS (id, username, email, gender, date_created, description, nat_id) VALUES (1002, 'mmarriott', 'moore.marriott@example.com', 'MALE', sysdate(), 'Hello', 8002);
-- INSERT INTO USERS (id, username, email, gender, date_created, description, nat_id) VALUES (1003, 'glorimer', 'glennis.lorimer@example.com', 'FEMALE', sysdate(), 'Hello', 8003);


INSERT INTO USERS (id, username, email, gender, date_created, description) VALUES (1000, 'whay', 'will.hay@example.com', 'MALE', sysdate(), 'Hello');
INSERT INTO USERS (id, username, email, gender, date_created, description) VALUES (1001, 'gmoffatt', 'graham.moffatt@example.com', 'MALE', sysdate(), 'Hello');
INSERT INTO USERS (id, username, email, gender, date_created, description) VALUES (1002, 'mmarriott', 'moore.marriott@example.com', 'MALE', sysdate(), 'Hello');
INSERT INTO USERS (id, username, email, gender, date_created, description) VALUES (1003, 'glorimer', 'glennis.lorimer@example.com', 'FEMALE', sysdate(), 'Hello');

INSERT INTO NATIONAL_INSURANCE_NUMBERS (user_id, nat_number) VALUES (1000, 'NP111111C');
INSERT INTO NATIONAL_INSURANCE_NUMBERS (user_id, nat_number) VALUES (1001, 'NP222222C');
INSERT INTO NATIONAL_INSURANCE_NUMBERS (user_id, nat_number) VALUES (1002, 'NP333333C');
INSERT INTO NATIONAL_INSURANCE_NUMBERS (user_id, nat_number) VALUES (1003, 'NP444444C');
