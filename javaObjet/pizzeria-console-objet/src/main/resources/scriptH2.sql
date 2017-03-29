CREATE TABLE `pizza` (
  `id` int(11) auto_increment NOT NULL,
  `categorie` varchar(255) CHECK `categorie` IN ('VIANDE','VEGETARIEN','POISSON') ,
  `code` varchar(5) NOT NULL,
  `description` varchar(25) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `url_image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `pizza` (`categorie`, `code`, `description`, `prix`) VALUES
('VIANDE', 'TOT', 'toto', 45);