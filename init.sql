CREATE TABLE article (
                         id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                         PRIMARY KEY(id),
                         `subject` CHAR(100) NOT NULL,
                         content LONGTEXT NOT NULL,
                         users_id BIGINT UNSIGNED,
                         FOREIGN KEY (users_id) REFERENCES users(id)
);
CREATE TABLE users (
                       id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                       PRIMARY KEY(id),
                       `password` varchar(50) NOT NULL,
                       `username` varchar(50) NOT NULL
);
insert into users(password, username) values("password", "username");
insert into article(subject, content, users_id) values("제목", "내용", 1);