INSERT INTO setor (nome, sigla) VALUES
    ('Coordenação de TI', 'COTIC'),
    ('Manutenção e Infraestrutura', 'MANUT');

INSERT INTO categoria (nome, descricao, setor_id) VALUES
    ('Rede e Wi-Fi', 'Problemas de conexão',
    (SELECT id FROM setor WHERE sigla = 'COTIC')
     ),
     (
         'Equipamentos de TI',
         'Computadores, projetores',
         (SELECT id FROM setor WHERE sigla = 'COTIC')
     ),
     (
         'Elétrica',
         'Tomadas, lâmpadas, ar-condicionado',
         (SELECT id FROM setor WHERE sigla = 'MANUT')
     ),
     (
         'Hidráulica',
         'Vazamentos, torneiras',
         (SELECT id FROM setor WHERE sigla = 'MANUT')
     );

INSERT INTO usuario (nome, email, matricula, tipo, setor_id) VALUES
     (
         'Maria Silva',
         'maria@ifrn.edu.br',
         '20261001',
         'SOLICITANTE',
         NULL
     ),
     (
         'João Souza',
         'joao@ifrn.edu.br',
         '20261002',
         'SOLICITANTE',
         NULL
     ),
     (
         'Carlos Lima',
         'carlos@ifrn.edu.br',
         '20261003',
         'TECNICO',
         (SELECT id FROM setor WHERE sigla = 'COTIC')
     ),
     (
         'Ana Pereira',
         'ana@ifrn.edu.br',
         '20261004',
         'TECNICO',
         (SELECT id FROM setor WHERE sigla = 'MANUT')
     );
