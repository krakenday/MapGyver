/*==============================================================
  Nom de SGBD :  ORACLE Version 11g                                   
  Date de creation : 03/12/2018                               
  Projet : mapGyverWeb                                               
  Auteur : Idriss MOHAMADY                                            
==============================================================*/

/*==============================================================
  SUPPRESION DONNEES DANS TABLE                               
  TABLES : UTILISATEUR, MPG_ROADBOOK, MPG_ROADBOOK_MPG_VOYAGE  
  RESTRICTIONS : ID entre 400 et 499                            
==============================================================*/
delete from MPG_ROADBOOK_MPG_VOYAGE 	  where ENTITYROADBOOK_ID_RBK >=0     and ENTITYROADBOOK_ID_RBK <=499;
delete from MPG_VOYAGE 	                where ID_VOY >=0     and ID_VOY <=499;
delete from MPG_ROADBOOK                where Id_RBK >=0     and Id_RBK <=499;
delete from UTILISATEUR                 where ID     >=0     and ID     <=499;

/*==============================================================
  AJOUT DONNEES DANS TABLE                                     
  TABLE : UTILISATEUR                                          
  RESTRICTIONS : ID entre 400 et 499                           
==============================================================*/

Insert into UTILISATEUR (ID,ADRESSE,DATEINSCRIP,DATENAISS,EMAIL,PASSWORD,NOM,PRENOM,TELEPHONE) values ('401','401adresse',to_date('03/12/18','DD/MM/RR'),to_date('22/02/22','DD/MM/RR'),'i.mohamady@gmail.com','doudou','mohamady','idriss','0607080910');
Insert into UTILISATEUR (ID,ADRESSE,DATEINSCRIP,DATENAISS,EMAIL,PASSWORD,NOM,PRENOM,TELEPHONE) values ('402','402adresse',to_date('03/12/18','DD/MM/RR'),to_date('22/02/22','DD/MM/RR'),'toto@gmail.com','222222','toto','toto','0607080910');
Insert into UTILISATEUR (ID,ADRESSE,DATEINSCRIP,DATENAISS,EMAIL,PASSWORD,NOM,PRENOM,TELEPHONE) values ('403','403adresse',to_date('03/12/18','DD/MM/RR'),to_date('22/02/22','DD/MM/RR'),'bibi@gmail.com','222222','bibi','bibi','0708091011');

/*==============================================================
  AJOUT DONNEES DANS TABLE                                     
  TABLE : MPG_ROADBOOK                                          
  RESTRICTIONS : ID entre 400 et 499                            
==============================================================*/

Insert into MPG_ROADBOOK (ID_RBK,ID) values ('401','401');
Insert into MPG_ROADBOOK (ID_RBK,ID) values ('402','403');

/*==============================================================
  AJOUT DONNEES DANS TABLE                                     
  TABLE : MPG_VOYAGE                                          
  RESTRICTIONS : ID entre 400 et 499                            
==============================================================*/

Insert into MPG_VOYAGE (ID_VOY,DEB_VOY,PART_VOY,NOM_VOY) values ('401',to_date('01/12/18','DD/MM/RR'),'1','Voyage au centre de la terre');
Insert into MPG_VOYAGE (ID_VOY,DEB_VOY,PART_VOY,NOM_VOY) values ('402',null,null,'Afpa 2018');
Insert into MPG_VOYAGE (ID_VOY,DEB_VOY,PART_VOY,NOM_VOY) values ('403',to_date('07/12/18','DD/MM/RR'),null,'Voyage 403');

/*==============================================================
  AJOUT DONNEES DANS TABLE                                     
  TABLE : MPG_ROADBOOK_MPG_VOYAGE                                          
  RESTRICTIONS :                           
==============================================================*/

Insert into IDRISS_ADMIN.MPG_ROADBOOK_MPG_VOYAGE (ENTITYROADBOOK_ID_RBK,VOYAGES_ID_VOY) values ('401','401');
Insert into IDRISS_ADMIN.MPG_ROADBOOK_MPG_VOYAGE (ENTITYROADBOOK_ID_RBK,VOYAGES_ID_VOY) values ('401','403');


/*==============================================================*/
commit;
/*==============================================================
                              FIN                                   
==============================================================*/