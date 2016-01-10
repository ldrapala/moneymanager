CREATE OR REPLACE FUNCTION insert_current_date()
  RETURNS trigger AS $$DECLARE
BEGIN
	IF NEW.createdate IS NULL THEN
	NEW.createdate = current_date;
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER uzupelnij_trig
BEFORE INSERT OR UPDATE ON expense
FOR EACH ROW EXECUTE PROCEDURE
 insert_current_date();

CREATE TRIGGER uzupelnij_trig
BEFORE INSERT OR UPDATE ON inflow
FOR EACH ROW EXECUTE PROCEDURE
 insert_current_date();

CREATE TRIGGER uzupelnij_trig
BEFORE INSERT OR UPDATE ON deposit
FOR EACH ROW EXECUTE PROCEDURE
 insert_current_date();

CREATE TRIGGER uzupelnij_trig
BEFORE INSERT OR UPDATE ON shopping
FOR EACH ROW EXECUTE PROCEDURE
 insert_current_date();