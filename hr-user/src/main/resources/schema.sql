-- Criação da tabela tb_user
CREATE TABLE tb_user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Criação da tabela tb_role
CREATE TABLE tb_role (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(255) NOT NULL UNIQUE
);

-- Criação da tabela intermediária tb_user_role
CREATE TABLE tb_user_role (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES tb_role(id) ON DELETE CASCADE
);
