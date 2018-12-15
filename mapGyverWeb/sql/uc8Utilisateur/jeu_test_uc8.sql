/*==============================================================
                          JEU DE TEST SQL                                    
==============================================================*/

/*============================
INSERER UN NOUVEAU UTILISATEUR 
=============================*/

INSERT INTO UTILISATEUR (ID,ADRESSE,DATEINSCRIP,DATENAISS,EMAIL,PW,PRENOM ,NOM,TELEPHONE) 
  values ('1', '12 rue de la paix',to_date('13/12/18','DD/MM/RR'),to_date('03/06/84','DD/MM/RR'),'toto@sfr.fr','000000','Zola','Emile','0651703333');
INSERT INTO UTILISATEUR (ID,ADRESSE,DATEINSCRIP,DATENAISS,EMAIL,PW,PRENOM, NOM,TELEPHONE) 
  values ('2', '20 rue de la fête',to_date('12/12/18','DD/MM/RR'),to_date('12/02/60','DD/MM/RR'),'tata@sfr.fr','000000','Albert','Camus','0652415123');
INSERT INTO UTILISATEUR (ID,ADRESSE,DATEINSCRIP,DATENAISS,EMAIL,PW,PRENOM, NOM,TELEPHONE) 
  values ('3', '52 rue de la joie',to_date('10/12/18','DD/MM/RR'),to_date('01/12/56','DD/MM/RR'),'lolo@sfr.fr','000000','Martin','King','0635369810');
INSERT INTO UTILISATEUR (ID,ADRESSE,DATEINSCRIP,DATENAISS,EMAIL,PW,PRENOM, NOM,TELEPHONE) 
  values ('4', '88 rue du bonheur',to_date('12/12/18','DD/MM/RR'),to_date('17/08/86','DD/MM/RR'),'fifi@sfr.fr','000000','Marie','Curie','0614253680');
INSERT INTO UTILISATEUR (ID,ADRESSE,DATEINSCRIP,DATENAISS,EMAIL,PW,PRENOM, NOM,TELEPHONE) 
  values ('5', '77 rue de la reussite',to_date('10/12/18','DD/MM/RR'),to_date('25/08/87','DD/MM/RR'),'dodo@sfr.fr','000000','Simon','Veil','0780709030');

/*============================
INSERER UN NOUVEAU GROUPE 
=============================*/
Insert into GROUPE (ID,NOM,ID_UTILISATEUR) values ('1','AMIS','2');
Insert into GROUPE (ID,NOM,ID_UTILISATEUR) values ('2','FAMILLE','2');
Insert into GROUPE (ID,NOM,ID_UTILISATEUR) values ('3','AMIS','3');
Insert into GROUPE (ID,NOM,ID_UTILISATEUR) values ('4','FAMILLE','3');
Insert into GROUPE (ID,NOM,ID_UTILISATEUR) values ('5','COLLEGUE','3');
Insert into GROUPE (ID,NOM,ID_UTILISATEUR) values ('6','AMIS','1');
Insert into GROUPE (ID,NOM,ID_UTILISATEUR) values ('7','FAMILLE','1');
Insert into GROUPE (ID,NOM,ID_UTILISATEUR) values ('8','AMIS','4');
Insert into GROUPE (ID,NOM,ID_UTILISATEUR) values ('9','FAMILLE','4');
Insert into GROUPE (ID,NOM,ID_UTILISATEUR) values ('10','COLLEGUE','5');
/*======================*/

/*============================
INSERER UN NOUVELLE LISTE 
=============================*/
Insert into LISTEDIFF (ID,NOM,ID_UTILISATEUR) values ('1','EMAIL','1');
Insert into LISTEDIFF (ID,NOM,ID_UTILISATEUR) values ('2','EMAIL2','1');
Insert into LISTEDIFF (ID,NOM,ID_UTILISATEUR) values ('3','EMAIL','2');
Insert into LISTEDIFF (ID,NOM,ID_UTILISATEUR) values ('4','EMAIL2','2');
Insert into LISTEDIFF (ID,NOM,ID_UTILISATEUR) values ('5','EMAIL','3');
Insert into LISTEDIFF (ID,NOM,ID_UTILISATEUR) values ('6','EMAIL2','3');
Insert into LISTEDIFF (ID,NOM,ID_UTILISATEUR) values ('7','EMAIL','4');
Insert into LISTEDIFF (ID,NOM,ID_UTILISATEUR) values ('8','EMAIL2','4');
Insert into LISTEDIFF (ID,NOM,ID_UTILISATEUR) values ('9','EMAIL','5');
Insert into LISTEDIFF (ID,NOM,ID_UTILISATEUR) values ('10','EMAIL2','5');
/*======================*/


/*================================================
INSERER DES UTILISATEURS DANS UN GROUPE OU LISTES
==================================================
Insert into UTILISATEUR_CERCLE (ID_UTILISATEUR,ID_CERCLE) values ('1','1');
Insert into UTILISATEUR_CERCLE (ID_UTILISATEUR,ID_CERCLE) values ('2','1');
Insert into UTILISATEUR_CERCLE (ID_UTILISATEUR,ID_CERCLE) values ('3','1');
Insert into UTILISATEUR_CERCLE (ID_UTILISATEUR,ID_CERCLE) values ('4','1');
/*======================*/

commit;

