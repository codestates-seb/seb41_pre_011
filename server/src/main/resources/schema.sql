CREATE TABLE IF NOT EXISTS MEMBER (
    MEMBER_ID bigint NOT NULL AUTO_INCREMENT,
    EMAIL varchar(100) NOT NULL UNIQUE,
    NAME varchar(100) NOT NULL,
    PASSWORD varchar(100) NOT NULL,
    PRIMARY KEY (MEMBER_ID)
);

CREATE TABLE IF NOT EXISTS QUESTION (
    QUESTION_ID bigint NOT NULL AUTO_INCREMENT,
    TITLE varchar(100) NOT NULL,
    QUESTIONCONTENT varchar(100) NOT NULL,
    ATTEMPCONTENT varchar(100) NOT NULL,
    CREATEDDATE DATE NOT NULL,
    MODIFIEDDATE DATE NOT NULL,
    MEMBERNAME varchar(100) NOT NULL,
    TAG varchar(100) NOT NULL,
    PRIMARY KEY (QUESTION_ID)
    FOREIGN KEY (MEMBER_ID)
);

CREATE TABLE IF NOT NULL EXISTS ANSWER (
    ANSWER_ID bigint NOT NULL AUTO_INCREMENT,
    CONTENT varchar(100) NOT NULL,
    CREATEDDATE DATE NOT NULL,
    MODIFIEDDATE DATE NOT NULL,
    PRIMARY KEY (ANSWER_ID),
    FOREIGN KEY (MEMBER_ID),
    FOREIGN KEY (QUESTION_ID)
);

CREATE TABLE IF NOT NULL EXISTS TAG (
    TAG_ID bigint NOT NULL AUTO_INCREMENT,
    NAME varchar(100) NOT NULL,
    DESCRIBE varchar(100) NOT NULL,
    COUNT  bigint NOT NULL
)
