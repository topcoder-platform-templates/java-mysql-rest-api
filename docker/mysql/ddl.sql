-- Create the users table
CREATE TABLE IF NOT EXISTS users (
    id binary(16) not null primary key,
    handle varchar(255) not null unique
);