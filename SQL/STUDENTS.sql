/* I. CREATE TABLES */

-- faculty (Khoa trong tr�?ng)
create table faculty (
	id number primary key,
	name nvarchar2(30) not null
);

-- subject (M�n h?c)
create table subject(
	id number primary key,
	name nvarchar2(100) not null,
	lesson_quantity number(2,0) not null -- t?ng s? ti?t h?c
);

-- student (Sinh vi�n)
create table student (
	id number primary key,
	name nvarchar2(30) not null,
	gender nvarchar2(10) not null, -- gi?i t�nh
	birthday date not null,
	hometown nvarchar2(100) not null, -- qu� qu�n
	scholarship number, -- h?c b?ng
	faculty_id number not null constraint faculty_id references faculty(id) -- m? khoa
);

-- exam management (B?ng �i?m)
create table exam_management(
	id number primary key,
	student_id number not null constraint student_id references student(id),
	subject_id number not null constraint subject_id references subject(id),
	number_of_exam_taking number not null, -- s? l?n thi (thi tr�n 1 l?n ��?c g?i l� thi l?i) 
	mark number(4,2) not null -- �i?m
);



/*================================================*/

/* II. INSERT SAMPLE DATA */

-- subject
insert into subject (id, name, lesson_quantity) values (1, 'C� s? d? li?u', 45);
insert into subject values (2, 'Tr� tu? nh�n t?o', 45);
insert into subject values (3, 'Truy?n tin', 45);
insert into subject values (4, '�? h?a', 60);
insert into subject values (5, 'V�n ph?m', 45);


-- faculty
insert into faculty values (1, 'Anh - V�n');
insert into faculty values (2, 'Tin h?c');
insert into faculty values (3, 'Tri?t h?c');
insert into faculty values (4, 'V?t l?');


-- student
insert into student values (1, 'Nguy?n Th? H?i', 'N?', to_date('19900223', 'YYYYMMDD'), 'H� N?i', 130000, 2);
insert into student values (2, 'Tr?n V�n Ch�nh', 'Nam', to_date('19921224', 'YYYYMMDD'), 'B?nh �?nh', 150000, 4);
insert into student values (3, 'L� Thu Y?n', 'N?', to_date('19900221', 'YYYYMMDD'), 'TP HCM', 150000, 2);
insert into student values (4, 'L� Thu Y?n', 'N?', to_date('19900221', 'YYYYMMDD'), 'TP HCM', 170000, 2);
insert into student values (5, 'Tr?n Anh Tu?n', 'Nam', to_date('19901220', 'YYYYMMDD'), 'H� N?i', 180000, 1);
insert into student values (6, 'Tr?n Thanh Mai', 'N?', to_date('19910812', 'YYYYMMDD'), 'H?i Ph?ng', null, 3);
insert into student values (7, 'Tr?n Th? Thu Th?y', 'N?', to_date('19910102', 'YYYYMMDD'), 'H?i Ph?ng', 10000, 1);


-- exam_management
insert into exam_management values (1, 1, 1, 1, 3);
insert into exam_management values (2, 1, 1, 2, 6);
insert into exam_management values (3, 1, 2, 2, 6);
insert into exam_management values (4, 1, 3, 1, 5);
insert into exam_management values (5, 2, 1, 1, 4.5);
insert into exam_management values (6, 2, 1, 2, 7);
insert into exam_management values (7, 2, 3, 1, 10);
insert into exam_management values (8, 2, 5, 1, 9);
insert into exam_management values (9, 3, 1, 1, 2);
insert into exam_management values (10, 3, 1, 2, 5);
insert into exam_management values (11, 3, 3, 1, 2.5);
insert into exam_management values (12, 3, 3, 2, 4);
insert into exam_management values (13, 4, 5, 2, 10);
insert into exam_management values (14, 5, 1, 1, 7);
insert into exam_management values (15, 5, 3, 1, 2.5);
insert into exam_management values (16, 5, 3, 2, 5);
insert into exam_management values (17, 6, 2, 1, 6);
insert into exam_management values (18, 6, 4, 1, 10);



/*================================================*/

/* III. QUERY */


 /********* A. BASIC QUERY *********/

-- 1. Li?t k� danh s�ch sinh vi�n s?p x?p theo th? t?:
--      a. id t�ng d?n

SELECT id 
FROM student 
ORDER BY id ASC

--      b. gi?i t�nh

SELECT student.gender 
FROM student 
ORDER BY gender DESC

--      c. ng�y sinh T�NG D?N v� h?c b?ng GI?M D?N

SELECT student.birthday , student.scholarship
FROM student
ORDER BY birthday ASC , scholarship DESC


-- 2. M�n h?c c� t�n b?t �?u b?ng ch? 'T'

SELECT *
FROM subject 
WHERE name LIKE 'T%'

-- 3. Sinh vi�n c� ch? c�i cu?i c�ng trong t�n l� 'i'

SELECT *
FROM student 
WHERE name LIKE '%i'

-- 4. Nh?ng khoa c� k? t? th? hai c?a t�n khoa c� ch?a ch? 'n'

SELECT *
FROM faculty
WHERE name LIKE '_n'

-- 5. Sinh vi�n trong t�n c� t? 'Th?'

SELECT *
FROM student 
WHERE name LIKE '%Th?%'

-- 6. Sinh vi�n c� k? t? �?u ti�n c?a t�n n?m trong kho?ng t? 'a' �?n 'm', s?p x?p theo h? t�n sinh vi�n

SELECT student.name 
FROM student 
WHERE student.name BETWEEN 'A' AND 'M' 
GROUP BY student.name; 

-- 7. Sinh vi�n c� h?c b?ng l?n h�n 100000, s?p x?p theo m? khoa gi?m d?n

SELECT student.scholarship 
FROM student 
WHERE student.scholarship > 100000 
ORDER BY faculty_id DESC;

-- 8. Sinh vi�n c� h?c b?ng t? 150000 tr? l�n v� sinh ? H� N?i

SELECT student.scholarship,student.hometown 
FROM student 
Where student.scholarship > 150000 AND hometown = 'H� N?i';

-- 9. Nh?ng sinh vi�n c� ng�y sinh t? ng�y 01/01/1991 �?n ng�y 05/06/1992

SELECT * 
FROM student 
WHERE student.birthday BETWEEN TO_DATE('01/01/1991','DD/MM/YYYY') AND TO_DATE('05/06/1992','DD/MM/YYYY');

-- 10. Nh?ng sinh vi�n c� h?c b?ng t? 80000 �?n 150000

SELECT * 
FROM student 
WHERE student.scholarship BETWEEN 80000 AND 150000;

-- 11. Nh?ng m�n h?c c� s? ti?t l?n h�n 30 v� nh? h�n 45


SELECT * 
FROM subject 
WHERE lesson_quantity > 30 AND lesson_quantity < 45;

-------------------------------------------------------------------

/********* B. CALCULATION QUERY *********/

-- 1. Cho bi?t th�ng tin v? m?c h?c b?ng c?a c�c sinh vi�n, g?m: M? sinh vi�n, Gi?i t�nh, M? 
		-- khoa, M?c h?c b?ng. Trong ��, m?c h?c b?ng s? hi?n th? l� �H?c b?ng cao� n?u gi� tr? 
		-- c?a h?c b?ng l?n h�n 500,000 v� ng�?c l?i hi?n th? l� �M?c trung b?nh�.
        
SELECT id, gender, faculty_id,CASE WHEN scholarship > 500000 THEN 'H?c b?ng cao' ELSE 'M?c trung b?nh' END scholarship
FROM student
WHERE scholarship > 0;
		
-- 2. T�nh t?ng s? sinh vi�n c?a to�n tr�?ng

SELECT COUNT(id) AS student_total 
FROM student; 

-- 3. T�nh t?ng s? sinh vi�n nam v� t?ng s? sinh vi�n n?.

SELECT gender, COUNT(id) 
FROM student 
GROUP BY student.gender;

-- 4. T�nh t?ng s? sinh vi�n t?ng khoa (ch�a c?n JOIN)

SELECT faculty_id , COUNT(faculty_id) AS Total_Student FROM student
GROUP BY faculty_id
ORDER BY faculty_id

-- 5. T�nh t?ng s? sinh vi�n c?a t?ng m�n h?c

SELECT subject.id, subject.name, COUNT(exam_management.student_id) AS total 
FROM subject 
LEFT JOIN exam_management ON subject.id = exam_management.subject_id
GROUP BY subject.id,  subject.name
ORDER BY subject.id ASC

-- 6. T�nh s? l�?ng m�n h?c m� sinh vi�n �? h?c

SELECT student.name, COUNT(*) AS quantity
FROM student, exam_management
WHERE student.id = exam_management.student_id
GROUP BY student.name;

-- 7. T?ng s? h?c b?ng c?a m?i khoa	

SELECT faculty.name, COUNT(student.scholarship) 
FROM faculty, student 
WHERE faculty.id = student.faculty_id 
GROUP BY faculty.name;

-- 8. Cho bi?t h?c b?ng cao nh?t c?a m?i khoa

SELECT faculty.name, MAX(student.scholarship) AS HIGHEST_AMOUNT
FROM faculty, student
WHERE faculty.id = student.faculty_id
GROUP BY faculty.name;

-- 9. Cho bi?t t?ng s? sinh vi�n nam v� t?ng s? sinh vi�n n? c?a m?i khoa

SELECT faculty.name, gender, COUNT(student.id) total 
FROM student, faculty 
WHERE gender = 'Nam' AND faculty.id = student.faculty_id 
GROUP BY faculty.name, gender
UNION
SELECT faculty.name, gender, COUNT(student.id) total 
FROM student, faculty 
WHERE gender = 'N?' AND faculty.id = student.faculty_id 
GROUP BY faculty.name, gender;

-- 10. Cho bi?t s? l�?ng sinh vi�n theo t?ng �? tu?i

SELECT student.birthday, COUNT(student.id) 
FROM student GROUP BY student.birthday;

-- 11. Cho bi?t nh?ng n�i n�o c� h�n 2 sinh vi�n �ang theo h?c t?i tr�?ng

SELECT student.hometown , COUNT(student_id) * 
FROM student
GROUP BY student.hometown
HAVING COUNT(student_id) >2;

-- 12. Cho bi?t nh?ng sinh vi�n thi l?i �t nh?t 2 l?n

SELECT student.name , exam_management.subject_id , COUNT(thilai) 
FROM student
WHERE student.id = exam_management.student_id
GROUP BY student.name , exam_management.subject_id
HAVING COUNT(thilai) >2;

-- 13. Cho bi?t nh?ng sinh vi�n nam c� �i?m trung b?nh l?n 1 tr�n 7.0 

SELECT student.name, AVG(exam_management.mark) 
FROM student, exam_management 
WHERE student.id = exam_management.student_id AND student.gender = 'Nam' AND exam_management.number_of_exam_taking = 1
GROUP BY student.name
HAVING AVG(exam_management.mark) > 7;

-- 14. Cho bi?t danh s�ch c�c sinh vi�n r?t tr�n 2 m�n ? l?n thi 1 (r?t m�n l� �i?m thi c?a m�n kh�ng qu� 4 �i?m)

SELECT student.name 
FROM student , exam_management
WHERE exam_management.number_of_exam_taking = 1 AND exam_management.mark < 4 AND student.id = exam_management.student_id 
GROUP BY student.name;

-- 15. Cho bi?t danh s�ch nh?ng khoa c� nhi?u h�n 2 sinh vi�n nam (ch�a c?n JOIN)

SELECT faculty.name, COUNT(student.gender) 
FROM faculty, student 
WHERE student.faculty_id = faculty.id AND student.gender = 'Nam'
GROUP BY faculty.name
HAVING COUNT(student.gender)>2;

-- 16. Cho bi?t nh?ng khoa c� 2 sinh vi�n �?t h?c b?ng t? 200000 �?n 300000

SELECT  faculty.name ,COUNT(student.id)  
FROM faculty , student
WHERE student.scholarship >= 200000 AND student.scholarship =<300000
GROUP BY faculty.name 
HAVING COUNT(student.id) = 2;

-- 17. Cho bi?t sinh vi�n n�o c� h?c b?ng cao nh?t

SELECT student.name, MAX(student.scholarship) 
FROM student
WHERE student.scholarship = (SELECT MAX(student.scholarship) 
FROM student)
GROUP BY student.name;


-------------------------------------------------------------------

/********* C. DATE/TIME QUERY *********/

-- 1. Sinh vi�n c� n�i sinh ? H� N?i v� sinh v�o th�ng 02

SELECT student.name  
FROM student
WHERE student.hometown = N'H� N?i' AND to_char(birthday,'MM') = 02;

-- 2. Sinh vi�n c� tu?i l?n h�n 20
SELECT student.name, current_year - to_number(to_char(student.birthday, 'YYYY')) age
FROM student, (SELECT to_number(to_char(sysdate, 'YYYY')) current_year FROM dual)
WHERE current_year - to_number(to_char(student.birthday, 'YYYY')) > 20;

-- 3. Sinh vi�n sinh v�o m�a xu�n n�m 1990

SELECT student.name
FROM student
WHERE to_char(student.birthday, 'YYYY') = '1990' AND to_char(student.birthday, 'MM') IN ('01', '02', '03');

-------------------------------------------------------------------


/********* D. JOIN QUERY *********/

-- 1. Danh s�ch c�c sinh vi�n c?a khoa ANH V�N v� khoa V?T L?

SELECT student.name  
FROM student JOIN faculty ON faculty.id = student.faculty_id
WHERE faculty.name ='ANH V�N' and faculty.name ='V?T L?'

-- 2. Nh?ng sinh vi�n nam c?a khoa ANH V�N v� khoa TIN H?C

SELECT student.name, faculty.name 
FROM student,faculty
WHERE student.faculty_id = faculty.id AND (faculty.name = 'Anh V�n' or faculty.name = 'Tin h?c') AND student.gender = 'Nam';

-- 3. Cho bi?t sinh vi�n n�o c� �i?m thi l?n 1 m�n c� s? d? li?u cao nh?t

SELECT student.name, exam_management.mark 
FROM exam_management
JOIN student ON student.id = exam_management.student_id
WHERE number_of_exam_taking = 1 AND subject_id = 1
AND mark= (select max(mark) FROM exam_management
WHERE number_of_exam_taking = 1 AND subject_id = 1);

-- 4. Cho bi?t sinh vi�n khoa anh v�n c� tu?i l?n nh?t.

SELECT * 
FROM  student 
WHERE months_between(sysdate, birthday) / 12 = (SELECT  MAX(months_between(sysdate, birthday) / 12) 
FROM  student WHERE faculty_id = 1 )

-- 5. Cho bi?t khoa n�o c� ��ng sinh vi�n nh?t

-- 6. Cho bi?t khoa n�o c� ��ng n? nh?t

-- 7. Cho bi?t nh?ng sinh vi�n �?t �i?m cao nh?t trong t?ng m�n

SELECT student.name , max(mark) 
FROM exam_management, student
WHERE  exam_management.student_id = student.id
GROUP BY student.name;

-- 8. Cho bi?t nh?ng khoa kh�ng c� sinh vi�n h?c

-- 9. Cho bi?t sinh vi�n ch�a thi m�n c� s? d? li?u
SELECT student.name, COUNT(subject_id) 
FROM exam_management
JOIN student ON exam_management.student_id = student.id
WHERE NOT exam_management.subject_id = 1
GROUP BY student.name;
-- 10. Cho bi?t sinh vi�n n�o kh�ng thi l?n 1 m� c� d? thi l?n 2

select student.name, number_of_exam_taking from exam_management
join student on student.id = exam_management.student_id
where number_of_exam_taking = 2 and not exists (select id , student_id, subject_id, exam_management.number_of_exam_taking , mark
from exam_management where number_of_exam_taking = 1 and student.id = exam_management.student_id);
