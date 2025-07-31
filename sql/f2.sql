DELIMITER //
CREATE FUNCTION even_str(lim INT)
RETURNS TEXT NO SQL
BEGIN
    DECLARE j INT default 0;
    DECLARE str TEXT default "";

    WHILE j < lim do
        SET str = CONCAT(str, ' ', CONVERT(j, char));
        SET j = j + 2;
    END WHILE;

    RETURN str;
END//
DELIMITER ;
SELECT even_str(10)