CREATE TABLE `pizza` (
  `id` int(11) auto_increment NOT NULL,
  `code` varchar(3) NULL,
  `description` varchar(25) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `categorie` varchar(255) CHECK `categorie` IN ('VIANDE','VEGETARIEN','POISSON') ,
  `url_image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
