-- Email -> test@com
-- PassWord -> 00000000

INSERT INTO USERS (
	ID, EMAIL, AVF, NAME, PASSWORD, LOCKED, EXPIRED, EMP_NO, DEPT_CD, POS_CD, PROFILE_IMG 
) VALUES (
	1,'test@com','2021-10-10','初期ユーザー','$2a$10$dYk751tZmAl6uR4LRfcoguKMWncxf/9I.KOnAA4Zwv107yv2KVbHa',0,0,'11111111','0000000','0000',null
);

INSERT INTO USER_ROLES ( 
	USER_ID, ROLE, DELFLG 
) VALUES (
	1,'03','0' 
);