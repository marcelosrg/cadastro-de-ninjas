ALTER TABLE ninjas
    ADD COLUMN missoes_id UUID,
    ADD CONSTRAINT fk_ninjas_missoes
        FOREIGN KEY (missoes_id) REFERENCES missoes(id);