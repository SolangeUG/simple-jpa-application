-- roles : store roles values
CREATE TABLE IF NOT EXISTS roles (
    roleId          INT         PRIMARY KEY,
    roleName        VARCHAR     NOT NULL,
);