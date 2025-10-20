CREATE TABLE consertos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_entrada VARCHAR(50) NOT NULL,
    data_saida VARCHAR(50),
    mecanico_nome VARCHAR(100) NOT NULL,
    mecanico_anos_experiencia INT,
    veiculo_marca VARCHAR(100) NOT NULL,
    veiculo_modelo VARCHAR(100) NOT NULL,
    veiculo_ano VARCHAR(10)
);