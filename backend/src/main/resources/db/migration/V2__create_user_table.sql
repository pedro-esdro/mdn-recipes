-- Migration V2: create user table
-- Executada apenas uma vez em ambiente limpo. Ajuste manual via nova migration se precisar mudar estrutura depois.
CREATE TABLE IF NOT EXISTS "user" (
    id UUID PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);