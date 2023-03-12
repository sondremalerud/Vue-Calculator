DELETE FROM USERS WHERE username='sondre';
DELETE FROM USERS WHERE username='malerud';
DELETE FROM USERS WHERE username='test';
DELETE FROM EQUATIONS WHERE username='sondre';

INSERT INTO USERS (username) VALUES ('sondre');
INSERT INTO USERS (username) VALUES ('malerud');
INSERT INTO USERS (username) VALUES ('test');
INSERT INTO EQUATIONS (username, expression, answer) VALUES ('sondre', '1+1', '2');