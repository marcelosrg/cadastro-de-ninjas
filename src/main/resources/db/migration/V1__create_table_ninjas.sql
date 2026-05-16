CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE ninjas (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    idade INTEGER NOT NULL
);

CREATE INDEX idx_ninjas_email ON ninjas(email);