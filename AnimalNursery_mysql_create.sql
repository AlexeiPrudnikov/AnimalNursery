use `AnimalNursery`; 
CREATE TABLE `AnimalTypes` (
	`atID` INT NOT NULL AUTO_INCREMENT,
	`atName` varchar(30) NOT NULL UNIQUE,
	PRIMARY KEY (`atID`)
);

CREATE TABLE `AnimalSubTypes` (
	`astID` INT NOT NULL AUTO_INCREMENT,
	`atID` INT NOT NULL,
	`astName` varchar(40) NOT NULL UNIQUE,
	PRIMARY KEY (`astID`)
);

CREATE TABLE `Animals` (
	`aID` INT NOT NULL AUTO_INCREMENT,
	`astID` INT NOT NULL,
	`aName` varchar(50) NOT NULL,
	`aBirthDate` DATE NOT NULL,
	`aInNursery` BOOLEAN NOT NULL,
	PRIMARY KEY (`aID`)
);

ALTER TABLE `AnimalSubTypes` ADD CONSTRAINT `AnimalSubTypes_AniiimalTypes` FOREIGN KEY (`atID`) REFERENCES `AnimalTypes`(`atID`);

ALTER TABLE `Animals` ADD CONSTRAINT `Animals_AnimalSubTypes` FOREIGN KEY (`astID`) REFERENCES `AnimalSubTypes`(`astID`);

insert into AnimalTypes(atName) values ('Домашние');
insert into AnimalTypes(atName) values ('Вьючные');

INSERT into AnimalSubTypes (atID, astName) values (1, 'Собака');
INSERT into AnimalSubTypes (atID, astName) values (1, 'Кошка');
INSERT into AnimalSubTypes (atID, astName) values (1, 'Хомяк');
INSERT into AnimalSubTypes (atID, astName) values (2, 'Лошадь');
INSERT into AnimalSubTypes (atID, astName) values (2, 'Верблюд');
INSERT into AnimalSubTypes (atID, astName) values (2, 'Осел');


INSERT into Animals (astID, aName, aBirthDate, aInNursery) values (1, 'Шарик', '2021-01-01', true);
INSERT into Animals (astID, aName, aBirthDate, aInNursery) values (1, 'Тузик', '2020-02-01', false);
INSERT into Animals (astID, aName, aBirthDate, aInNursery) values (1, 'Трезор', '2019-03-01', true);
INSERT into Animals (astID, aName, aBirthDate, aInNursery) values (1, 'Алый', '2015-04-01', true);
INSERT into Animals (astID, aName, aBirthDate, aInNursery) values (1, 'Бобик', '2022-05-01', false);

INSERT into Animals (astID, aName, aBirthDate, aInNursery) values (2, 'Мурка', '2021-01-18', true);
INSERT into Animals (astID, aName, aBirthDate, aInNursery) values (2, 'Баксик', '2020-02-23', true);
INSERT into Animals (astID, aName, aBirthDate, aInNursery) values (2, 'Кнопа', '2017-03-13', false);
INSERT into Animals (astID, aName, aBirthDate, aInNursery) values (2, 'Мис', '2014-04-11', true);

INSERT into Animals (astID, aName, aBirthDate, aInNursery) values (4, 'Быстрый', '2015-01-18', true);
INSERT into Animals (astID, aName, aBirthDate, aInNursery) values (4, 'Резвый', '2020-02-23', true);
INSERT into Animals (astID, aName, aBirthDate, aInNursery) values (4, 'Гнедой', '2017-03-13', false);