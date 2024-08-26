CREATE TABLE task (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(255),
    descricao VARCHAR(255),
    data_alvo DATE,
    feito BOOLEAN
);
