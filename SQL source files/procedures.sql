DROP PROCEDURE IF EXISTS addUser; 

DELIMITER \\
CREATE PROCEDURE addUser (in newcpr varchar(10), in newnavn text, in newini text, in newpwd text, in newrank int)
BEGIN
		INSERT INTO ansat (`cpr`, `opr_navn`, `ini`, `password`, `titel`) values (newcpr, newnavn, newini, newpwd, newrank);
END \\
DELIMITER ;

DROP PROCEDURE IF EXISTS getLeverandoer; 

DELIMITER \\
CREATE PROCEDURE getLeverandoer(IN `inID` TEXT)
BEGIN
			select leverandoer.leverandoer_navn from leverandoer, raavare where (leverandoer.raavare_id=raavare.raavare_id AND raavare.raavare_navn=inID);
END\\
DELIMITER ;
