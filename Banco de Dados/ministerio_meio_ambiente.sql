-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 30-Nov-2020 às 02:50
-- Versão do servidor: 10.4.14-MariaDB
-- versão do PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `ministerio_meio_ambiente`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agrotoxicos`
--

CREATE TABLE `agrotoxicos` (
  `id_agrotoxico` int(11) NOT NULL,
  `id_proprietario` varchar(14) NOT NULL,
  `faz_uso` varchar(4) NOT NULL,
  `tam_propriedade` varchar(6) NOT NULL,
  `herbicida` varchar(4) NOT NULL,
  `inseticida` varchar(4) NOT NULL,
  `fungicida` varchar(4) NOT NULL,
  `bactericida` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cadastro_proprietario_rural`
--

CREATE TABLE `cadastro_proprietario_rural` (
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `data_nasc` varchar(10) NOT NULL,
  `sexo` varchar(9) NOT NULL,
  `data_cadastro` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `contato`
--

CREATE TABLE `contato` (
  `id_contato` int(11) NOT NULL,
  `id_proprietario` varchar(14) NOT NULL,
  `ddd_telefone_residencial` char(4) NOT NULL,
  `telefone_residencial` varchar(9) NOT NULL,
  `ddd_telefone_celular` char(4) NOT NULL,
  `telefone_celular` varchar(10) NOT NULL,
  `ddd_telefone_comercial` char(4) NOT NULL,
  `telefone_comercial` varchar(9) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `id_endereco` int(11) NOT NULL,
  `id_proprietario` varchar(14) NOT NULL,
  `logradouro` varchar(50) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `numero` varchar(7) NOT NULL,
  `municipio` varchar(20) NOT NULL,
  `uf` char(2) NOT NULL,
  `complemento` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `qtd_agrotoxicos`
--

CREATE TABLE `qtd_agrotoxicos` (
  `id_qtd_agrotoxicos` int(11) NOT NULL,
  `id_proprietario` varchar(14) NOT NULL,
  `qtd_herbicida` varchar(6) NOT NULL,
  `qtd_inseticida` varchar(6) NOT NULL,
  `qtd_fungicida` varchar(6) NOT NULL,
  `qtd_bactericida` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `termos`
--

CREATE TABLE `termos` (
  `id_termos` int(11) NOT NULL,
  `id_proprietario` varchar(14) NOT NULL,
  `receber_email` varchar(4) NOT NULL,
  `aceita_termos` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `agrotoxicos`
--
ALTER TABLE `agrotoxicos`
  ADD PRIMARY KEY (`id_agrotoxico`);

--
-- Índices para tabela `cadastro_proprietario_rural`
--
ALTER TABLE `cadastro_proprietario_rural`
  ADD PRIMARY KEY (`cpf`);

--
-- Índices para tabela `contato`
--
ALTER TABLE `contato`
  ADD PRIMARY KEY (`id_contato`);

--
-- Índices para tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id_endereco`);

--
-- Índices para tabela `qtd_agrotoxicos`
--
ALTER TABLE `qtd_agrotoxicos`
  ADD PRIMARY KEY (`id_qtd_agrotoxicos`);

--
-- Índices para tabela `termos`
--
ALTER TABLE `termos`
  ADD PRIMARY KEY (`id_termos`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `agrotoxicos`
--
ALTER TABLE `agrotoxicos`
  MODIFY `id_agrotoxico` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `contato`
--
ALTER TABLE `contato`
  MODIFY `id_contato` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id_endereco` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `qtd_agrotoxicos`
--
ALTER TABLE `qtd_agrotoxicos`
  MODIFY `id_qtd_agrotoxicos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `termos`
--
ALTER TABLE `termos`
  MODIFY `id_termos` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
