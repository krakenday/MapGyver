package dao.uc6Jouer.facade;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import business.uc6Jouer.Reponse;
import business.uc6Jouer.ReponseElire;
import dao.exception.ConvertionException;
import entity.uc6Jouer.ReponseElireEntity;

@Singleton
@LocalBean
public class DaoFacadeJouer {

	public void createReponse(ReponseElire reponseElire) throws ConvertionException {
		Convertisseur convert = Convertisseur.getInstance();
		Convertisseur.ReponseMetierToEntity<Reponse> conversion = convert.new ReponseMetierToEntity<>();
		ReponseElireEntity reponseEntity = (ReponseElireEntity) conversion.reponseMetierToEntity(reponseElire);
	}
}
