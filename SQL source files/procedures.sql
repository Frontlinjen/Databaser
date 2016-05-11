DROP PROCEDURE IF EXISTS addUser; 

CREATE PROCEDURE addUser (in newcpr varchar(10), in newnavn text, in newini text, in newpwd text, in newrank int)
BEGIN
		INSERT INTO ansat (`cpr`, `opr_navn`, `ini`, `password`, `titel`) values (newcpr, newnavn, newini, newpwd, newrank);
END
