-- V1__create_drug_table.sql

CREATE TABLE IF NOT EXISTS drugs (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    quantity BIGINT NOT NULL,
    available BOOLEAN NOT NULL,
    drugType VARCHAR(50) NOT NULL,
    packSize VARCHAR(50) NOT NULL,

    PRIMARY KEY(id)
);