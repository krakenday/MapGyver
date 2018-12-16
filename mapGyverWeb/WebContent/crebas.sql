

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
url_base VARCHAR2(50);
nomtrim VARCHAR2(50);

BEGIN
  nomtrim := REPLACE(:new.NOM ,' ','');
  DBMS_OUTPUT.PUT_LINE(nomtrim);
  :new.URL := CONCAT('https://s3.eu-west-3.amazonaws.com/fr.mapgyver/',nomtrim);

END;

--------------------------------------
--------------------------------------
INSERT INTO MPG_PHOTO (IDD, ID_VOYAGE,NOM)
 VALUES (222,747, '   Bora   Bo  ra  ');
 COMMIT;
 
 
------------------------------------
--------Test de requette----------
------------------------------------
SELECT * 
  FROM MPG_COMENTAIRE, MPG_PHOTO
    where id_voyage = 747;
    
    SELECT *
      FROM MPG_COMENTAIRE
        INNER JOIN MPG_PHOTO on MPG_COMENTAIRE.IDD.idd = MPG_PHOTO.ID_COM
          WHERE MPG_PHOTO.ID_VOYAGE = 747;
    
      and not in (SELECT * 
                    FROM MPG_COMENTAIRE, MPG_PHOTO
                      WHERE MPG_COMENTAIRE.IDD = MPG_PHOTO.ID_COM;)




 
 