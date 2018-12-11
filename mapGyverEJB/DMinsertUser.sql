delete from utilisateur;
INSERT INTO "UTILISATEUR" (ID, ADRESSE, DATEINSCRIP, DATENAISS, EMAIL, PASSWORD, NOM, PRENOM, TELEPHONE) 
VALUES ('1', '24 rue machin', 
TO_DATE('2017-12-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
TO_DATE('2000-05-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
'email1@toto.fr', 'passw1', 'Muller', 'Domi', '04 45 85 89 96');
INSERT INTO "UTILISATEUR" (ID, ADRESSE, DATEINSCRIP, DATENAISS, EMAIL, PASSWORD, NOM, PRENOM, TELEPHONE) 
VALUES ('2', '24 rue machin', 
TO_DATE('2017-12-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
TO_DATE('2000-05-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
'email2@toto.fr', 'passw2', 'Muller', 'Estelle', '04 45 85 89 96');
INSERT INTO "UTILISATEUR" (ID, ADRESSE, DATEINSCRIP, DATENAISS, EMAIL, PASSWORD, NOM, PRENOM, TELEPHONE) 
VALUES ('3', '24 rue machin', 
TO_DATE('2017-12-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
TO_DATE('2000-05-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
'email3@toto.fr', 'passw3', 'Dupond', 'Jacques', '04 45 85 89 96');

delete from photo;
INSERT INTO "PHOTO" (ID, DDATE_ENRE, NOM, URL) VALUES ('1', TO_DATE('2018-12-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'smiley1', 'https://www.manutan.fr/img/S/GRP/ST/AIG2330852.jpg');
INSERT INTO "PHOTO" (ID, DDATE_ENRE, NOM, URL) VALUES ('2', TO_DATE('2018-12-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'smiley2', 'https://previews.123rf.com/images/tigatelu/tigatelu1509/tigatelu150900326/45091936-happy-face-smiley-%C3%A9motic%C3%B4nes.jpg');
INSERT INTO "PHOTO" (ID, DDATE_ENRE, NOM, URL) VALUES ('3', TO_DATE('2018-12-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'smiley3', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpoFzdpIAPkN0H8ppm8IAoMkBODiebVcJQCoMlY2rrVdxkwrJprA');
INSERT INTO "PHOTO" (ID, DDATE_ENRE, NOM, URL) VALUES ('4', TO_DATE('2018-12-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpoFzdpIAPkN0H8ppm8IAoMkBODiebVcJQCoMlY2rrVdxkwrJprA');
INSERT INTO "PHOTO" (ID, DDATE_ENRE, NOM, URL) VALUES ('5', TO_DATE('2018-12-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'smiley3', null);

commit;