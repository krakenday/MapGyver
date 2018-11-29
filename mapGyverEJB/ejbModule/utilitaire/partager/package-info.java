@AnyMetaDefs(
		@AnyMetaDef( name= "ProprietePartageable", metaType = "string", idType = "integer",
			metaValues = {
					@MetaValue(value = "Voyage", targetEntity = Voyage.class)
//					,      @MetaValue(value = "Photo", targetEntity = Photo.class)
//					@MetaValue(value = "PointInteret", targetEntity = PointInteret.class),
//					@MetaValue(value = "Contact", targetEntity = Contact.class)
					})
)
package utilitaire.partager;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.AnyMetaDefs;
import org.hibernate.annotations.MetaValue;

import business.uc4Voyage.Voyage;

/*
	name= "PropertyJeu" 	libre mais il faut mettre le meme name dans Personne
	metaType = "string" 	type de donnee pour stocker le type de la classe
	idType   = "integer"	type de donnee de la colonne qui contient l'id du jeu
	
	puis les metaValues
	** Si c'est une instance de JeuJava.class 
		alors le type ecrit dans la table représentant Personne sera "J"
	** Si c'est une instance de JeuMerise.class 
		alors le type ecrit dans la table représentant Personne sera "M"
*/