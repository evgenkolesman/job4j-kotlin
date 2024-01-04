CREATE SCHEMA IF NOT EXISTS kotlin;
CREATE TABLE IF NOT EXISTS  kotlin.kotlin(
                                             id integer PRIMARY KEY,
                                             name varchar(100) NOT NULL,
                                             comment text
);
CREATE TABLE IF NOT EXISTS  kotlin.item(
                                             id  SERIAL PRIMARY KEY,
                                             name varchar(100) NOT NULL
);