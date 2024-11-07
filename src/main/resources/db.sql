-- V1__Create_exchange_rate_table.sql

create db forexdb;

CREATE TABLE exchange_rate (
    id SERIAL PRIMARY KEY,
    source_currency VARCHAR(3),
    target_currency VARCHAR(3),
    rate DECIMAL,
    date DATE
);
