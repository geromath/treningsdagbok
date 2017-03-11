CREATE TABLE `project`.`okt` (
  `oktID` INT NOT NULL AUTO_INCREMENT,
  `tidspunktstart` TIME NULL,
  `dato` DATE NOT NULL,
  `varighet` TIME NOT NULL,
  `kaloriforbruk` INT NULL,
  `notat` VARCHAR(200) NULL,
  `prestasjon` INT NULL,
  `form` INT NULL,
  PRIMARY KEY (`oktID`));

CREATE TABLE `project`.`mal` (
  `oktID` INT NOT NULL,
  `ovelseID` INT NOT NULL,
  `varighet` TIME NULL, 
  CONSTRAINT `fk_mal_okt_oktID`
	FOREIGN KEY (`oktID`)
    REFERENCES `project`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION, 
  CONSTRAINT `fk_mal_ovelse_ovelseID`
	FOREIGN KEY (`ovelseID`)
    REFERENCES `project`.`ovelse` (`ovelseID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `project`.`malsetning` (
  `ovelseID` INT NOT NULL,
  `intensitet` DOUBLE NOT NULL,
  `varighet` DOUBLE NOT NULL,
  CONSTRAINT `fk_ovelseID`
	FOREIGN KEY (`ovelseID`)
    REFERENCES `project`.`ovelse` (`ovelseID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

CREATE TABLE `project`.`maling` (
  `oktID` INT NOT NULL,
  `tidspunkt`TIME NOT NULL,
  PRIMARY KEY (`tidspunkt`), 
  CONSTRAINT `fk_maling_okt_oktID`
	FOREIGN KEY (`oktID`)
    REFERENCES `project`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `project`.`styrke` (
  `tidspunkt` TIME NOT NULL,
  `oktID` INT NOT NULL,
  `vekt` INT NULL,
  `repitisjon` INT NULL,
  `sett` INT NULL, 
  CONSTRAINT `fk_styrkemaling_maling_tidspunkt`
  FOREIGN KEY (`tidspunkt`)
    REFERENCES `project`.`maling` (`tidspunkt`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_styrkemaling_maling_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `project`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `project`.`styrke` (
  `tidspunkt` TIME NOT NULL,
  `oktID` INT NOT NULL,
  `vekt` INT NULL,
  `repitisjon` INT NULL,
  `sett` INT NULL, 
  CONSTRAINT `fk_svom_maling_tidspunkt`
  FOREIGN KEY (`tidspunkt`)
    REFERENCES `project`.`maling` (`tidspunkt`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_svom_maling_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `project`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `project`.`lop` (
  `tidspunkt` TIME NOT NULL,
  `oktID` INT NOT NULL,
  `gps` INT NULL,
  `antSkritt` INT NULL,
  `hastighet` DOUBLE NULL,
  `lengde` INT NULL,
  `puls` INT NULL,
  CONSTRAINT `fk_lop_maling_tidspunkt`
  FOREIGN KEY (`tidspunkt`)
    REFERENCES `project`.`maling` (`tidspunkt`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lop_maling_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `project`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `project`.`sykkel` (
  `tidspunkt` TIME NOT NULL,
  `oktID` INT NOT NULL,
  `watt` INT NULL,
  `cadence` INT NULL,
  `gps` INT NULL,
  `lengde` DOUBLE NULL,
  `hastighet` DOUBLE NULL,
  `puls` INT NULL,
  CONSTRAINT `fk_sykkel_maling_tidspunkt`
  FOREIGN KEY (`tidspunkt`)
    REFERENCES `project`.`maling` (`tidspunkt`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sykkel_maling_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `project`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `project`.`innemaling` (
  `tidspunkt` TIME NOT NULL,
  `oktID` INT NOT NULL,
  `ventilasjon` DOUBLE NULL,
  `antalltilskuere` INT NULL, 
  CONSTRAINT `fk_innemaling_maling_tidspunkt`
  FOREIGN KEY (`tidspunkt`)
    REFERENCES `project`.`maling` (`tidspunkt`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_innemaling_maling_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `project`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `project`.`utemaling` (
  `tidspunkt` TIME NOT NULL,
  `oktID` INT NOT NULL,
  `vaertype` VARCHAR(45) NULL,
  `forhold` VARCHAR(45)  NULL,
  `temp` DOUBLE NULL, 
  CONSTRAINT `fk_utemaling_maling_tidspunkt`
  FOREIGN KEY (`tidspunkt`)
    REFERENCES `project`.`maling` (`tidspunkt`)
    ON DELETE CASCADE
	ON UPDATE NO ACTION,
  CONSTRAINT `fk_utemaling_maling_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `project`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `project`.`resultat` (
  `oktID` INT NOT NULL,
  `ovelseID` INT NOT NULL,
  `prestasjon` INT NOT NULL, 
  CONSTRAINT `fk_resultat_okt_ovelseID`
  FOREIGN KEY (`ovelseID`)
    REFERENCES `project`.`ovelse` (`ovelseID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resultat_okt_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `project`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `project`.`ovelse` (
  `ovelseID` INT NOT NULL AUTO_INCREMENT,
  `navn` VARCHAR(45) NULL,
  `beskrivelse` VARCHAR(450) NULL,
  PRIMARY KEY (`ovelseID`));


CREATE TABLE `project`.`styrkeovelse` (
  `ovelseID` INT NOT NULL,
  `belastning` INT NULL,
  `repetisjon` INT NULL,
  `sett` INT NULL,
  INDEX `ovelse_idx` (`ovelseID` ASC),
  CONSTRAINT `fk_styrkeovelse_ovelse_ovelseID`
    FOREIGN KEY (`ovelseID`)
    REFERENCES `project`.`ovelse` (`ovelseID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `project`.`utholdenhetsovelse` (
  `ovelseID` INT NOT NULL,
  `hastighet` INT NULL,
  `pulssone` INT NULL,
  `varighet` TIME,
  INDEX `ovelse_idx` (`ovelseID` ASC),
  CONSTRAINT `fk_utholdenhetsovelse_ovelse_ovelseID`
    FOREIGN KEY (`ovelseID`)
    REFERENCES `project`.`ovelse` (`ovelseID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);