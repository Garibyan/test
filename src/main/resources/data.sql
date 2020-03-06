INSERT INTO `SUBJECT` (`sb_id`, `name`) VALUES
(1, 'Math'),
(2, 'Biology'),
(3, 'Chemistry'),
(4, 'History'),
(5, 'Physics'),
(6, 'English');

INSERT INTO `STUDENT` (`st_id`,`first_name` ,`last_name`) VALUES
(1, 'Armen', 'Garibyan'),
(2, 'Nika', 'Beqauri'),
(3, 'Luka', 'Todya'),
(4, 'Dato', 'Robaqidze'),
(5, 'Dato', 'Robaqidze'),
(6, 'Dato', 'Robaqidze'),
(7, 'Dato', 'Robaqidze'),
(8, 'Vako', 'Gvalia');

INSERT INTO STUDENT_SUBJECT (`ss_id`, `student_id`, `subject_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4);