

INSERT INTO MPG_VOYAGE (ID_VOY, NOM_VOY)
 VALUES ('747', 'Cancun');
 
 COMMIT;
 
 DROP TABLE mpg_photo;
 
  ----------------------------------
 ----------------------------------
 -------Trigger d'insertion de l'URL Photo-----
set serveroutput on size 1000000;

CREATE OR REPLACE TRIGGER trURL
BEFORE INSERT
ON MPG_PHOTO 
FOR EACH ROW
DECLARE 
url_base VARCHAR2(20);
nomtrim VARCHAR2(20);

BEGIN
  nomtrim := REPLACE(:new.NOM ,' ','');
  DBMS_OUTPUT.PUT_LINE(nomtrim);
  :new.URL := CONCAT('https://s3.eu-west-3.amazonaws.com/fr.mapgyver/',nomtrim);

END;

--------------------------------------
--------------------------------------
INSERT INTO MPG_PHOTO (IDD, ID_VOYAGE,NOM)
 VALUES (993,747, '   Bora   Bo  ra  ');
 COMMIT;
 
 