CREATE TABLE IF NOT EXISTS category
(
    id_category SERIAL PRIMARY KEY,
    name VARCHAR(80) NOT NULL
);

CREATE TABLE IF NOT EXISTS task (
    id_task SERIAL PRIMARY KEY,
    name VARCHAR(80) NOT NULL,
    situation VARCHAR(20) NOT NULL,
    id_category INT,
    FOREIGN KEY (id_category) REFERENCES category(id_category),
    CONSTRAINT chk_task_situation CHECK (situation IN ('to do', 'doing', 'done'))
);
