
CREATE TABLE IF NOT EXISTS loans (
  loan_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  mobile_number VARCHAR(15) NOT NULL,
  loan_number VARCHAR(100) NOT NULL,
  loan_type VARCHAR(100) NOT NULL,
  total_loan INT NOT NULL,
  amount_paid INT NOT NULL,
  outstanding_amount INT NOT NULL,
  created_at DATE NOT NULL,
  created_by VARCHAR(20) NOT NULL,
  updated_at DATE,
  updated_by VARCHAR(20),
  CONSTRAINT uq_loans_loan_number UNIQUE (loan_number),
  CONSTRAINT ck_loans_amounts_non_negative CHECK (
    total_loan >= 0 AND amount_paid >= 0 AND outstanding_amount >= 0
  ),
  CONSTRAINT ck_loans_consistency CHECK (
    outstanding_amount = total_loan - amount_paid
  )
);

-- Helpful indexes
CREATE INDEX IF NOT EXISTS idx_loans_mobile_number ON loans (mobile_number);
CREATE INDEX IF NOT EXISTS idx_loans_loan_type ON loans (loan_type);
