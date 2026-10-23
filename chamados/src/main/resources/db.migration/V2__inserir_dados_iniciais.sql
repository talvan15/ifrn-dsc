INSERT INTO setor (nome, sigla) VALUES
    ('Coordenação de TI', 'COTIC'),
    ('Manutenção e Infraestrutura', 'MANUT');

INSERT INTO categoria (nome, descricao, setor_id) VALUES
    ('Rede e Wi-Fi', 'Problemas de conexão', 1),
    ('Equipamentos de TI', 'Computadores, projetores', 1),
    ('Elétrica', 'Tomadas, lâmpadas, ar-condicionado', 2),
    ('Hidráulica', 'Vazamentos, torneiras', 2);

INSERT INTO usuario (nome, email, matricula, tipo, setor_id) VALUES
    ('Maria Silva',  'maria@ifrn.edu.br', '20261001', 'SOLICITANTE', NULL),
    ('João Souza',   'joao@ifrn.edu.br',  '20261002', 'SOLICITANTE', NULL),
    ('Carlos Lima',  'carlos@ifrn.edu.br','20261003', 'TECNICO', 1),
    ('Ana Pereira',  'ana@ifrn.edu.br',   '20261004', 'TECNICO', 2);