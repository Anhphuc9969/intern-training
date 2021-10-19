/* I. CREATE TABLES */

-- faculty (Khoa trong trý?ng)
create table faculty (
	id number primary key,
	name nvarchar2(30) not null
);

-- subject (Môn h?c)
create table subject(
	id number primary key,
	name nvarchar2(100) not null,
	lesson_quantity number(2,0) not null -- t?ng s? ti?t h?c
);

-- student (Sinh viên)
create table student (
	id number primary key,
	name nvarchar2(30) not null,
	gender nvarchar2(10) not null, -- gi?i tính
	birthday date not null,
	hometown nvarchar2(100) not null, -- quê quán
	scholarship number, -- h?c b?ng
	faculty_id number not null constraint faculty_id references faculty(id) -- m? khoa
);

-- exam management (B?ng ði?m)
create table exam_management(
	id number primary key,
	student_id number not null constraint student_id references student(id),
	subject_id number not null constraint subject_id references subject(id),
	number_of_exam_taking number not null, -- s? l?n thi (thi trên 1 l?n ðý?c g?i là thi l?i) 
	mark number(4,2) not null -- ði?m
);



/*================================================*/

/* II. INSERT SAMPLE DATA */

-- subject
insert into subject (id, name, lesson_quantity) values (1, 'Cõ s? d? li?u', 45);
insert into subject values (2, 'Trí tu? nhân t?o', 45);
insert into subject values (3, 'Truy?n tin', 45);
insert into subject values (4, 'Ð? h?a', 60);
insert into subject values (5, 'Vãn ph?m', 45);


-- faculty
insert into faculty values (1, 'Anh - Vãn');
insert into faculty values (2, 'Tin h?c');
insert into faculty values (3, 'Tri?t h?c');
insert into faculty values (4, 'V?t l?');


-- student
insert into student values (1, 'Nguy?n Th? H?i', 'N?', to_date('19900223', 'YYYYMMDD'), 'Hà N?i', 130000, 2);
insert into student values (2, 'Tr?n Vãn Chính', 'Nam', to_date('19921224', 'YYYYMMDD'), 'B?nh Ð?nh', 150000, 4);
insert into student values (3, 'Lê Thu Y?n', 'N?', to_date('19900221', 'YYYYMMDD'), 'TP HCM', 150000, 2);
insert into student values (4, 'Lê Thu Y?n', 'N?', to_date('19900221', 'YYYYMMDD'), 'TP HCM', 170000, 2);
insert into student values (5, 'Tr?n Anh Tu?n', 'Nam', to_date('19901220', 'YYYYMMDD'), 'Hà N?i', 180000, 1);
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

-- 1. Li?t kê danh sách sinh viên s?p x?p theo th? t?:
--      a. id tãng d?n

SELECT id 
FROM student 
ORDER BY id ASC

--      b. gi?i tính

SELECT student.gender 
FROM student 
ORDER BY gender DESC

--      c. ngày sinh TÃNG D?N và h?c b?ng GI?M D?N

SELECT student.birthday , student.scholarship
FROM student
ORDER BY birthday ASC , scholarship DESC


-- 2. Môn h?c có tên b?t ð?u b?ng ch? 'T'

SELECT *
FROM subject 
WHERE name LIKE 'T%'

-- 3. Sinh viên có ch? cái cu?i cùng trong tên là 'i'

SELECT *
FROM student 
WHERE name LIKE '%i'

-- 4. Nh?ng khoa có k? t? th? hai c?a tên khoa có ch?a ch? 'n'

SELECT *
FROM faculty
WHERE name LIKE '_n'

-- 5. Sinh viên trong tên có t? 'Th?'

SELECT *
FROM student 
WHERE name LIKE '%Th?%'

-- 6. Sinh viên có k? t? ð?u tiên c?a tên n?m trong kho?ng t? 'a' ð?n 'm', s?p x?p theo h? tên sinh viên

SELECT student.name 
FROM student 
WHERE student.name BETWEEN 'A' AND 'M' 
GROUP BY student.name; 

-- 7. Sinh viên có h?c b?ng l?n hõn 100000, s?p x?p theo m? khoa gi?m d?n

SELECT student.scholarship 
FROM student 
WHERE student.scholarship > 100000 
ORDER BY faculty_id DESC;

-- 8. Sinh viên có h?c b?ng t? 150000 tr? lên và sinh ? Hà N?i

SELECT student.scholarship,student.hometown 
FROM student 
Where student.scholarship > 150000 AND hometown = 'Hà N?i';

-- 9. Nh?ng sinh viên có ngày sinh t? ngày 01/01/1991 ð?n ngày 05/06/1992

SELECT * 
FROM student 
WHERE student.birthday BETWEEN TO_DATE('01/01/1991','DD/MM/YYYY') AND TO_DATE('05/06/1992','DD/MM/YYYY');

-- 10. Nh?ng sinh viên có h?c b?ng t? 80000 ð?n 150000

SELECT * 
FROM student 
WHERE student.scholarship BETWEEN 80000 AND 150000;

-- 11. Nh?ng môn h?c có s? ti?t l?n hõn 30 và nh? hõn 45


SELECT * 
FROM subject 
WHERE lesson_quantity > 30 AND lesson_quantity < 45;

-------------------------------------------------------------------

/********* B. CALCULATION QUERY *********/

-- 1. Cho bi?t thông tin v? m?c h?c b?ng c?a các sinh viên, g?m: M? sinh viên, Gi?i tính, M? 
		-- khoa, M?c h?c b?ng. Trong ðó, m?c h?c b?ng s? hi?n th? là “H?c b?ng cao” n?u giá tr? 
		-- c?a h?c b?ng l?n hõn 500,000 và ngý?c l?i hi?n th? là “M?c trung b?nh”.
        
SELECT id, gender, faculty_id,CASE WHEN scholarship > 500000 THEN 'H?c b?ng cao' ELSE 'M?c trung b?nh' END scholarship
FROM student
WHERE scholarship > 0;
		
-- 2. Tính t?ng s? sinh viên c?a toàn trý?ng

SELECT COUNT(id) AS student_total 
FROM student; 

-- 3. Tính t?ng s? sinh viên nam và t?ng s? sinh viên n?.

SELECT gender, COUNT(id) 
FROM student 
GROUP BY student.gender;

-- 4. Tính t?ng s? sinh viên t?ng khoa (chýa c?n JOIN)

SELECT faculty_id , COUNT(faculty_id) AS Total_Student FROM student
GROUP BY faculty_id
ORDER BY faculty_id

-- 5. Tính t?ng s? sinh viên c?a t?ng môn h?c

SELECT subject.id, subject.name, COUNT(exam_management.student_id) AS total 
FROM subject 
LEFT JOIN exam_management ON subject.id = exam_management.subject_id
GROUP BY subject.id,  subject.name
ORDER BY subject.id ASC

-- 6. Tính s? lý?ng môn h?c mà sinh viên ð? h?c

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

-- 9. Cho bi?t t?ng s? sinh viên nam và t?ng s? sinh viên n? c?a m?i khoa

SELECT faculty.name, gender, COUNT(student.id) total 
FROM student, faculty 
WHERE gender = 'Nam' AND faculty.id = student.faculty_id 
GROUP BY faculty.name, gender
UNION
SELECT faculty.name, gender, COUNT(student.id) total 
FROM student, faculty 
WHERE gender = 'N?' AND faculty.id = student.faculty_id 
GROUP BY faculty.name, gender;

-- 10. Cho bi?t s? lý?ng sinh viên theo t?ng ð? tu?i

SELECT student.birthday, COUNT(student.id) 
FROM student GROUP BY student.birthday;

-- 11. Cho bi?t nh?ng nõi nào có hõn 2 sinh viên ðang theo h?c t?i trý?ng

SELECT student.hometown , COUNT(student_id) * 
FROM student
GROUP BY student.hometown
HAVING COUNT(student_id) >2;

-- 12. Cho bi?t nh?ng sinh viên thi l?i ít nh?t 2 l?n

SELECT student.name , exam_management.subject_id , COUNT(thilai) 
FROM student
WHERE student.id = exam_management.student_id
GROUP BY student.name , exam_management.subject_id
HAVING COUNT(thilai) >2;

-- 13. Cho bi?t nh?ng sinh viên nam có ði?m trung b?nh l?n 1 trên 7.0 

SELECT student.name, AVG(exam_management.mark) 
FROM student, exam_management 
WHERE student.id = exam_management.student_id AND student.gender = 'Nam' AND exam_management.number_of_exam_taking = 1
GROUP BY student.name
HAVING AVG(exam_management.mark) > 7;

-- 14. Cho bi?t danh sách các sinh viên r?t trên 2 môn ? l?n thi 1 (r?t môn là ði?m thi c?a môn không quá 4 ði?m)

SELECT student.name 
FROM student , exam_management
WHERE exam_management.number_of_exam_taking = 1 AND exam_management.mark < 4 AND student.id = exam_management.student_id 
GROUP BY student.name;

-- 15. Cho bi?t danh sách nh?ng khoa có nhi?u hõn 2 sinh viên nam (chýa c?n JOIN)

SELECT faculty.name, COUNT(student.gender) 
FROM faculty, student 
WHERE student.faculty_id = faculty.id AND student.gender = 'Nam'
GROUP BY faculty.name
HAVING COUNT(student.gender)>2;

-- 16. Cho bi?t nh?ng khoa có 2 sinh viên ð?t h?c b?ng t? 200000 ð?n 300000

SELECT  faculty.name ,COUNT(student.id)  
FROM faculty , student
WHERE student.scholarship >= 200000 AND student.scholarship =<300000
GROUP BY faculty.name 
HAVING COUNT(student.id) = 2;

-- 17. Cho bi?t sinh viên nào có h?c b?ng cao nh?t

SELECT student.name, MAX(student.scholarship) 
FROM student
WHERE student.scholarship = (SELECT MAX(student.scholarship) 
FROM student)
GROUP BY student.name;


-------------------------------------------------------------------

/********* C. DATE/TIME QUERY *********/

-- 1. Sinh viên có nõi sinh ? Hà N?i và sinh vào tháng 02

SELECT student.name  
FROM student
WHERE student.hometown = N'Hà N?i' AND to_char(birthday,'MM') = 02;

-- 2. Sinh viên có tu?i l?n hõn 20
SELECT student.name, current_year - to_number(to_char(student.birthday, 'YYYY')) age
FROM student, (SELECT to_number(to_char(sysdate, 'YYYY')) current_year FROM dual)
WHERE current_year - to_number(to_char(student.birthday, 'YYYY')) > 20;

-- 3. Sinh viên sinh vào mùa xuân nãm 1990

SELECT student.name
FROM student
WHERE to_char(student.birthday, 'YYYY') = '1990' AND to_char(student.birthday, 'MM') IN ('01', '02', '03');

-------------------------------------------------------------------


/********* D. JOIN QUERY *********/

-- 1. Danh sách các sinh viên c?a khoa ANH VÃN và khoa V?T L?

SELECT student.name  
FROM student JOIN faculty ON faculty.id = student.faculty_id
WHERE faculty.name ='ANH VÃN' and faculty.name ='V?T L?'

-- 2. Nh?ng sinh viên nam c?a khoa ANH VÃN và khoa TIN H?C

SELECT student.name, faculty.name 
FROM student,faculty
WHERE student.faculty_id = faculty.id AND (faculty.name = 'Anh Vãn' or faculty.name = 'Tin h?c') AND student.gender = 'Nam';

-- 3. Cho bi?t sinh viên nào có ði?m thi l?n 1 môn cõ s? d? li?u cao nh?t

SELECT student.name, exam_management.mark 
FROM exam_management
JOIN student ON student.id = exam_management.student_id
WHERE number_of_exam_taking = 1 AND subject_id = 1
AND mark= (select max(mark) FROM exam_management
WHERE number_of_exam_taking = 1 AND subject_id = 1);

-- 4. Cho bi?t sinh viên khoa anh vãn có tu?i l?n nh?t.

SELECT * 
FROM  student 
WHERE months_between(sysdate, birthday) / 12 = (SELECT  MAX(months_between(sysdate, birthday) / 12) 
FROM  student WHERE faculty_id = 1 )

-- 5. Cho bi?t khoa nào có ðông sinh viên nh?t

-- 6. Cho bi?t khoa nào có ðông n? nh?t

-- 7. Cho bi?t nh?ng sinh viên ð?t ði?m cao nh?t trong t?ng môn

SELECT student.name , max(mark) 
FROM exam_management, student
WHERE  exam_management.student_id = student.id
GROUP BY student.name;

-- 8. Cho bi?t nh?ng khoa không có sinh viên h?c

-- 9. Cho bi?t sinh viên chýa thi môn cõ s? d? li?u
SELECT student.name, COUNT(subject_id) 
FROM exam_management
JOIN student ON exam_management.student_id = student.id
WHERE NOT exam_management.subject_id = 1
GROUP BY student.name;
-- 10. Cho bi?t sinh viên nào không thi l?n 1 mà có d? thi l?n 2

select student.name, number_of_exam_taking from exam_management
join student on student.id = exam_management.student_id
where number_of_exam_taking = 2 and not exists (select id , student_id, subject_id, exam_management.number_of_exam_taking , mark
from exam_management where number_of_exam_taking = 1 and student.id = exam_management.student_id);
