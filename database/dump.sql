-- SQL Dump CTP POO Florian Maxence

-- Table `type_repas`
CREATE TABLE `type_repas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lib` VARCHAR(255),
  PRIMARY KEY (`id`)
);

-- Table `plat`
CREATE TABLE `plat` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lib` VARCHAR(255),
  PRIMARY KEY (`id`)
);

-- Table `boisson`
CREATE TABLE `boisson` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lib` VARCHAR(255),
  PRIMARY KEY (`id`)
);

-- Table `repas`
CREATE TABLE `repas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE,
  `id_type` INT,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_type`) REFERENCES `type_repas`(`id`)
);

-- Table `affectation_repas_plat`
CREATE TABLE `affectation_repas_plat` (
  `id_repas` INT,
  `id_plat` INT,
  FOREIGN KEY (`id_repas`) REFERENCES `repas`(`id`),
  FOREIGN KEY (`id_plat`) REFERENCES `plat`(`id`)
);

-- Table `affectation_repas_boisson`
CREATE TABLE `affectation_repas_boisson` (
  `id_repas` INT,
  `id_boisson` INT,
  FOREIGN KEY (`id_repas`) REFERENCES `repas`(`id`),
  FOREIGN KEY (`id_boisson`) REFERENCES `boisson`(`id`)
);

-- Table `symptome`
CREATE TABLE `symptome` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE,
  `description` TEXT,
  `duree` INT,
  PRIMARY KEY (`id`)
);


