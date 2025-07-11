DELIMITER //
CREATE FUNCTION sec_format(sec INT)
RETURNS TEXT NO SQL
BEGIN
  DECLARE days INT;
  DECLARE hrs INT;
  DECLARE mins INT;
  
  SET days = sec DIV (60 * 60 * 24);
  SET sec = sec % (60 * 60 * 24);
  SET hrs = sec DIV (60 * 60);
  SET sec = sec % (60 * 60);
  SET mins = sec DIV (60);
  SET sec = sec % (60);
  
	RETURN CONCAT(CONVERT(days, char), ' days ', 
	  CONVERT(hrs, char), ' hours ',
	  CONVERT(mins, char), ' minutes ', 
	  CONVERT(sec, char), ' seconds');
END//
DELIMITER ;
SELECT sec_format(123456);