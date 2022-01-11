DELIMITER //
CREATE FUNCTION getFirstNameById(int_id INT)
    RETURNS VARCHAR(60)
    BEGIN
        RETURN (SELECT first_name FROM singer WHERE id = int_id);
    END //
DELIMITER ;