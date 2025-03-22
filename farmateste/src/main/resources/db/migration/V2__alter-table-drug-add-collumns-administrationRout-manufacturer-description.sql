-- V2__alter-table-drug-add-collumns-administrationRout-manufacturer-description.sql

ALTER TABLE drugs ADD description  VARCHAR(1000) NOT NULL;
ALTER TABLE drugs ADD manufacturer VARCHAR(100) NOT NULL;
ALTER TABLE drugs ADD administrationRoute VARCHAR(50) NOT NULL;