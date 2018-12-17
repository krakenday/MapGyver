/*==============================================================
  SUPPRESION DONNEES DANS TABLE                                
  RESTRICTIONS : ID entre 600 et 699                            
==============================================================*/
DELETE from REP_ELIR ;
delete from PHO_JEU_ELIR;
delete from PHOTO         where ID     >=600     and ID     <=699;
delete from ELIR_PHO        where ID     >=600     and ID     <=699;
delete from UTILISATEUR   where ID     >=600     and ID     <=699;
/*==============================================================
  AJOUT DONNEES DANS TABLE                                     
  TABLE : PHOTO                                          
  RESTRICTIONS : ID entre 600 et 699                           
==============================================================*/

Insert into AFPA.PHOTO (ID,DDATE_ENRE,NOM,URL) values ('610',to_date('18/11/18','DD/MM/RR'),'photo1','http://localhost:8080/mapGyverWeb/assets/img/jouer1.jpg');
Insert into AFPA.PHOTO (ID,DDATE_ENRE,NOM,URL) values ('611',to_date('18/11/18','DD/MM/RR'),'photo2','http://localhost:8080/mapGyverWeb/assets/img/jouer2.jpg');
Insert into AFPA.PHOTO (ID,DDATE_ENRE,NOM,URL) values ('612',to_date('18/11/18','DD/MM/RR'),'photo3','http://localhost:8080/mapGyverWeb/assets/img/jouer3.jpg');
Insert into AFPA.PHOTO (ID,DDATE_ENRE,NOM,URL) values ('613',to_date('18/11/18','DD/MM/RR'),'photo4','http://localhost:8080/mapGyverWeb/assets/img/jouer4.jpg');
Insert into AFPA.PHOTO (ID,DDATE_ENRE,NOM,URL) values ('614',to_date('18/11/18','DD/MM/RR'),'photo5','http://localhost:8080/mapGyverWeb/assets/img/jouer5.jpg');
Insert into AFPA.PHOTO (ID,DDATE_ENRE,NOM,URL) values ('615',to_date('18/11/18','DD/MM/RR'),'photo6','http://localhost:8080/mapGyverWeb/assets/img/jouer6.jpg');

/*==============================================================
  AJOUT DONNEES DANS TABLE                                     
  TABLE : UTILISATEUR                                          
  RESTRICTIONS : ID entre 600 et 699                           
==============================================================*/

Insert into UTILISATEUR (ID,ADRESSE,DATEINSCRIP,DATENAISS,EMAIL,PASSWORD,NOM,PRENOM,TELEPHONE) values ('601','401adresse',to_date('03/12/18','DD/MM/RR'),to_date('22/02/22','DD/MM/RR'),'i.mohamady@gmail.com','222222','mohamady','idriss','0607080910');
Insert into UTILISATEUR (ID,ADRESSE,DATEINSCRIP,DATENAISS,EMAIL,PASSWORD,NOM,PRENOM,TELEPHONE) values ('602','402adresse',to_date('03/12/18','DD/MM/RR'),to_date('22/02/22','DD/MM/RR'),'toto@gmail.com','222222','toto','toto','0607080910');
Insert into UTILISATEUR (ID,ADRESSE,DATEINSCRIP,DATENAISS,EMAIL,PASSWORD,NOM,PRENOM,TELEPHONE) values ('603','403adresse',to_date('03/12/18','DD/MM/RR'),to_date('22/02/22','DD/MM/RR'),'bibi@gmail.com','222222','bibi','bibi','0708091011');

Insert into ELIR_PHO (ID,D_CREA,NOM,id_user,D_DEB,D_FIN,D_F_INSC) values ('610',to_date('18/11/18','DD/MM/RR'),'Jeu1',601,to_date('18/11/18'),to_date('18/11/18'),to_date('18/11/18'));
Insert into ELIR_PHO (ID,D_CREA,NOM,id_user,D_DEB,D_FIN,D_F_INSC) values ('611',to_date('18/11/18','DD/MM/RR'),'Jeu2',602,to_date('18/11/18'),to_date('18/11/18'),to_date('18/11/18'));
Insert into ELIR_PHO (ID,D_CREA,NOM,id_user,D_DEB,D_FIN,D_F_INSC) values ('612',to_date('18/11/18','DD/MM/RR'),'Jeu3',603,to_date('18/11/18'),to_date('18/11/18'),to_date('18/11/18'));
Insert into ELIR_PHO (ID,D_CREA,NOM,id_user,D_DEB,D_FIN,D_F_INSC) values ('613',to_date('18/11/18','DD/MM/RR'),'Jeu4',601,to_date('18/11/18'),to_date('18/11/18'),to_date('18/11/18'));

insert into PHO_JEU_ELIR (ID_JEU,ID_PHO) values (610,612);
insert into PHO_JEU_ELIR (ID_JEU,ID_PHO) values (610,613);
insert into PHO_JEU_ELIR (ID_JEU,ID_PHO) values (610,610);
commit;