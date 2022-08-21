CREATE TABLE IF NOT EXISTS `client` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(80) NOT NULL,
  `last_name` varchar(80) NOT NULL,
  `email` varchar(120) NOT NULL,
  PRIMARY KEY (`id`)
);