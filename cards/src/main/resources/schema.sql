
CREATE TABLE IF NOT EXISTS cards (
  card_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  mobile_number VARCHAR(15) NOT NULL,
  card_number VARCHAR(100) NOT NULL,
  card_type VARCHAR(100) NOT NULL,
  total_limit INT NOT NULL,
  amount_used INT NOT NULL,
  available_amount INT NOT NULL,
  created_at DATE NOT NULL,
  created_by VARCHAR(20) NOT NULL,
  updated_at DATE,
  updated_by VARCHAR(20),

  -- Constraints
  CONSTRAINT uq_cards_card_number UNIQUE (card_number),
  CONSTRAINT ck_cards_non_negative CHECK (
    total_limit >= 0 AND amount_used >= 0 AND available_amount >= 0
  ),
  CONSTRAINT ck_cards_consistency CHECK (
    available_amount = total_limit - amount_used
  )
);

-- Helpful indexes
CREATE INDEX IF NOT EXISTS idx_cards_mobile_number ON cards (mobile_number);
CREATE INDEX IF NOT EXISTS idx_cards_card_type ON cards (card_type);
