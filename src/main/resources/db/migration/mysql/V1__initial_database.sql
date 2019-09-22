CREATE TABLE `empresa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) NOT NULL,
  `data_atualizacao` datetime NOT NULL,
  `data_criacao` datetime NOT NULL,
  `razao_social` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4  COLLATE utf8mb4_unicode_ci;

CREATE TABLE `funcionario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `data_atualizacao` datetime NOT NULL,
  `data_criacao` datetime NOT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `perfil` varchar(255) NOT NULL,
  `qtd_horas_almoco` float DEFAULT NULL,
  `qtd_horas_trabalho_dia` float DEFAULT NULL,
  `senha` varchar(255) NOT NULL,
  `valor_hora` decimal(19,2) DEFAULT NULL,
  `empresa_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT fk_empresa FOREIGN KEY (empresa_id) REFERENCES empresa(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4  COLLATE utf8mb4_unicode_ci;

CREATE TABLE `lancamento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `data_atualizacao` datetime NOT NULL,
  `data_criacao` datetime NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `localizacao` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) NOT NULL,
  `funcionario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT fk_funcionario FOREIGN KEY (funcionario_id) REFERENCES funcionario(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4  COLLATE utf8mb4_unicode_ci;


