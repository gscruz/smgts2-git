# --- Default Records

# --- !Ups

INSERT INTO `user_groups` (`group_id`, `name`, `description`) VALUES
(1, 'Administrator', 'Full system access'),
(2, 'Registrar', 'Official keeper of records'),
(3, 'Accounting', 'Financial transactions'),
(4, 'Teacher', 'Manage class and student performance'),
(5, 'Guardian', 'View student details, school records and performance');

INSERT INTO `user_account` (`acc_id`, `user_name`, `user_pass`, `group_id`) VALUES
(1, 'admin', 'admin', 1);

# --- !Downs

delete from `user_account`;

delete from `user_groups`;
