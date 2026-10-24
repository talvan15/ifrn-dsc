CREATE TABLE setor (
    id    BIGSERIAL PRIMARY KEY,
    nome  VARCHAR(255) NOT NULL,
    sigla VARCHAR(10)  NOT NULL UNIQUE
);

CREATE TABLE categoria (
    id        BIGSERIAL PRIMARY KEY,
    nome      VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    setor_id  BIGINT NOT NULL REFERENCES setor(id)
);

CREATE TABLE usuario (
    id        BIGSERIAL PRIMARY KEY,
    nome      VARCHAR(150) NOT NULL,
    email     VARCHAR(255) NOT NULL UNIQUE,
    matricula VARCHAR(20)  NOT NULL UNIQUE,
    tipo      VARCHAR(20)  NOT NULL,
    setor_id  BIGINT REFERENCES setor(id)
);

-- chamado e interacao: mantenha como estão

CREATE TABLE chamado (
    id               BIGSERIAL PRIMARY KEY,
    titulo           VARCHAR(150) NOT NULL,
    descricao        TEXT NOT NULL,
    local            VARCHAR(150) NOT NULL,
    prioridade       VARCHAR(20)  NOT NULL,
    status           VARCHAR(20)  NOT NULL,
    data_abertura    TIMESTAMP    NOT NULL,
    data_fechamento  TIMESTAMP,
    solucao          TEXT,
    solicitante_id   BIGINT NOT NULL REFERENCES usuario(id),
    categoria_id     BIGINT NOT NULL REFERENCES categoria(id),
    tecnico_id       BIGINT REFERENCES usuario(id)
);

CREATE TABLE interacao (
    id BIGSERIAL PRIMARY KEY,
    texto TEXT NOT NULL,
    data_hora TIMESTAMP NOT NULL,
    chamado_id BIGINT NOT NULL REFERENCES chamado(id),
    autor_id BIGINT NOT NULL REFERENCES usuario(id)
);

CREATE INDEX idx_chamado_status ON chamado(status);
CREATE INDEX idx_chamado_categoria ON chamado(categoria_id);