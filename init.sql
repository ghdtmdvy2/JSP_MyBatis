CREATE TABLE article (
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(id),
    `subject` CHAR(100) NOT NULL,
    content LONGTEXT NOT NULL
);
insert into article(subject, content) values("제목", "내용");