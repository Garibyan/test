INSERT INTO `SUBJECT` (`id`, `name`) VALUES
    (1, 'Math'),
    (2, 'Biology'),
    (3, 'Chemistry'),
    (4, 'History'),
    (5, 'Physics'),
    (6, 'English');

INSERT INTO `STUDENT` (`id`,`first_name` ,`last_name`) VALUES
 (1, 'Armen', 'Garibyan'),
 (2, 'Nika', 'Beqauri'),
 (3, 'Luka', 'Todya'),
 (4, 'Dato', 'Robaqidze'),
 (5, 'Dato', 'Robaqidze'),
 (6, 'Dato', 'Robaqidze'),
 (7, 'Dato', 'Robaqidze'),
 (8, 'Vako', 'Gvalia');

INSERT INTO STUDENT_SUBJECT (`student_id`, `subject_id`) VALUES
(1, 1),
(1, 6),
(2, 3),
(2, 4),
(3, 4),
(3, 2),
(4, 1),
(4, 5),
(5, 5),
(5, 4),
(6, 1),
(6, 3),
(7, 6),
(7, 2),
(8, 3),
(8, 1);





