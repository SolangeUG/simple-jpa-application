-- roles : store roles values
CREATE TABLE IF NOT EXISTS roles (
    roleId      INT             NOT NULL,
    roleName    VARCHAR(255)    NOT NULL,
    PRIMARY KEY(roleId)
);

-- users : store users values
CREATE TABLE IF NOT EXISTS users (
    userId      INT             NOT NULL,
    userName    VARCHAR(255)    NOT NULL,
    firstName   VARCHAR(255)    NOT NULL,
    lastName    VARCHAR(255)    NOT NULL,
    PRIMARY KEY(userId)
);