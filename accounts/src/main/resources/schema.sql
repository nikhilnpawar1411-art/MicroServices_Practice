
CREATE TABLE IF NOT EXISTS customer (
    customer_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    mobile_number VARCHAR(20) NOT NULL,
    created_at DATE NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    updated_at DATE,
    updated_by VARCHAR(20)
);

-- Optional, recommended:
--ALTER TABLE customer ADD CONSTRAINT uq_customer_email UNIQUE (email);

CREATE TABLE IF NOT EXISTS accounts (
    customer_id INT NOT NULL,
    account_number BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    account_type VARCHAR(100) NOT NULL,
    branch_address VARCHAR(200) NOT NULL,
    created_at DATE NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    updated_at DATE,
    updated_by VARCHAR(20),
    CONSTRAINT fk_accounts_customer
        FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- Optional indexes to speed up lookups
CREATE INDEX IF NOT EXISTS idx_accounts_customer_id ON accounts (customer_id);
CREATE INDEX IF NOT EXISTS idx_accounts_account_type ON accounts (account_type);
