CREATE TABLE `treningsdagbok`.`okt` (
  `oktID` INT NOT NULL AUTO_INCREMENT,
  `tidspunktstart` TIME NULL,
  `dato` DATE NOT NULL,
  `varighet` TIME NOT NULL,
  `kaloriforbruk` INT NULL,
  `notat` VARCHAR(200) NULL,
  `prestasjon` INT NULL,
  `form` INT NULL,
  PRIMARY KEY (`oktID`));

CREATE TABLE `treningsdagbok`.`mal` (
  `oktID` INT NOT NULL,
  `ovelseID` INT NOT NULL,
  `varighet` TIME NULL, 
  CONSTRAINT `fk_mal_okt_oktID`
	FOREIGN KEY (`oktID`)
    REFERENCES `treningsdagbok`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION, 
  CONSTRAINT `fk_mal_ovelse_ovelseID`
	FOREIGN KEY (`ovelseID`)
    REFERENCES `treningsdagbok`.`ovelse` (`ovelseID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `treningsdagbok`.`malsetning` (
  `ovelseID` INT NOT NULL,
  `intensitet` INT NOT NULL,
  `varighet` TIME NOT NULL,
  CONSTRAINT `fk_ovelseID`
	FOREIGN KEY (`ovelseID`)
    REFERENCES `treningsdagbok`.`ovelse` (`ovelseID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

CREATE TABLE `treningsdagbok`.`maling` (
  `oktID` INT NOT NULL,
  `tidspunkt`TIME NOT NULL,
  PRIMARY KEY (`tidspunkt`), 
  CONSTRAINT `fk_maling_okt_oktID`
	FOREIGN KEY (`oktID`)
    REFERENCES `treningsdagbok`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `treningsdagbok`.`styrke` (
  `tidspunkt` TIME NOT NULL,
  `oktID` INT NOT NULL,
  `vekt` INT NULL,
  `repetisjon` INT NULL,
  `sett` INT NULL, 
  CONSTRAINT `fk_styrkemaling_maling_tidspunkt`
  FOREIGN KEY (`tidspunkt`)
    REFERENCES `treningsdagbok`.`maling` (`tidspunkt`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_styrkemaling_maling_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `treningsdagbok`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `treningsdagbok`.`svom` (
  `tidspunkt` TIME NOT NULL,
  `oktID` INT NOT NULL,
  `lengde` INT NULL,
  `takPerLengde` INT NULL,
  `hastighet` DOUBLE NULL, 
  CONSTRAINT `fk_svom_maling_tidspunkt`
  FOREIGN KEY (`tidspunkt`)
    REFERENCES `treningsdagbok`.`maling` (`tidspunkt`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_svom_maling_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `treningsdagbok`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `treningsdagbok`.`lop` (
  `tidspunkt` TIME NOT NULL,
  `oktID` INT NOT NULL,
  `gps1` DOUBLE NULL,
  `gps2` DOUBLE NULL,
  `antSkritt` INT NULL,
  `hastighet` DOUBLE NULL,
  `lengde` DOUBLE NULL,
  `puls` INT NULL,
  CONSTRAINT `fk_lop_maling_tidspunkt`
  FOREIGN KEY (`tidspunkt`)
    REFERENCES `treningsdagbok`.`maling` (`tidspunkt`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lop_maling_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `treningsdagbok`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `treningsdagbok`.`sykkel` (
  `tidspunkt` TIME NOT NULL,
  `oktID` INT NOT NULL,
  `watt` INT NULL,
  `cadence` INT NULL,
  `gps1` DOUBLE NULL,
  `gps2` DOUBLE NULL,
  `lengde` DOUBLE NULL,
  `hastighet` DOUBLE NULL,
  `puls` INT NULL,
  CONSTRAINT `fk_sykkel_maling_tidspunkt`
  FOREIGN KEY (`tidspunkt`)
    REFERENCES `treningsdagbok`.`maling` (`tidspunkt`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sykkel_maling_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `treningsdagbok`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `treningsdagbok`.`innemaling` (
  `tidspunkt` TIME NOT NULL,
  `oktID` INT NOT NULL,
  `ventilasjon` DOUBLE NULL,
  `antalltilskuere` INT NULL, 
  CONSTRAINT `fk_innemaling_maling_tidspunkt`
  FOREIGN KEY (`tidspunkt`)
    REFERENCES `treningsdagbok`.`maling` (`tidspunkt`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_innemaling_maling_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `treningsdagbok`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `treningsdagbok`.`utemaling` (
  `oktID` INT NOT NULL,
  `tidspunkt` TIME NOT NULL,
  `vaertype` VARCHAR(45) NULL,
  `forhold` VARCHAR(45)  NULL,
  `temp` DOUBLE NULL, 
  CONSTRAINT `fk_utemaling_maling_tidspunkt`
  FOREIGN KEY (`tidspunkt`)
    REFERENCES `treningsdagbok`.`maling` (`tidspunkt`)
    ON DELETE CASCADE
	ON UPDATE NO ACTION,
  CONSTRAINT `fk_utemaling_maling_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `treningsdagbok`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `treningsdagbok`.`resultat` (
  `oktID` INT NOT NULL,
  `ovelseID` INT NOT NULL,
  `prestasjon` INT NOT NULL, 
  CONSTRAINT `fk_resultat_okt_ovelseID`
  FOREIGN KEY (`ovelseID`)
    REFERENCES `treningsdagbok`.`ovelse` (`ovelseID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resultat_okt_oktID`
  FOREIGN KEY (`oktID`)
    REFERENCES `treningsdagbok`.`okt` (`oktID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `treningsdagbok`.`ovelse` (
  `ovelseID` INT NOT NULL AUTO_INCREMENT,
  `navn` VARCHAR(45) NULL,
  `beskrivelse` VARCHAR(450) NULL,
  PRIMARY KEY (`ovelseID`));


CREATE TABLE `treningsdagbok`.`styrkeovelse` (
  `ovelseID` INT NOT NULL,
  `belastning` INT NULL,
  `repetisjon` INT NULL,
  `sett` INT NULL,
  INDEX `ovelse_idx` (`ovelseID` ASC),
  CONSTRAINT `fk_styrkeovelse_ovelse_ovelseID`
    FOREIGN KEY (`ovelseID`)
    REFERENCES `treningsdagbok`.`ovelse` (`ovelseID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


CREATE TABLE `treningsdagbok`.`utholdenhetsovelse` (
  `ovelseID` INT NOT NULL,
  `hastighet` INT NULL,
  `pulssone` INT NULL,
  `varighet` TIME NULL,
  INDEX `ovelse_idx` (`ovelseID` ASC),
  CONSTRAINT `fk_utholdenhetsovelse_ovelse_ovelseID`
    FOREIGN KEY (`ovelseID`)
    REFERENCES `treningsdagbok`.`ovelse` (`ovelseID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);