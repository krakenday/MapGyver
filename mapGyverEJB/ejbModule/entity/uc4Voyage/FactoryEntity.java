package entity.uc4Voyage;

import java.util.ArrayList;
import java.util.List;

import business.uc4Voyage.Coordonnee;
import business.uc4Voyage.Lieu;
import business.uc4Voyage.Pays;
import business.uc4Voyage.PointInteret;
import business.uc4Voyage.RoadBook;
import business.uc4Voyage.Ville;
import business.uc4Voyage.Voyage;
import business.uc8Utilisateur.Utilisateur;
import entity.uc8Utilisateur.EntityUtilisateur;

public class FactoryEntity {

	public FactoryEntity() {
		super();
	}

	public EntityVoyage createEntityFrom(Voyage voyage) {
		EntityVoyage entityVoyage = null;
		if (voyage!=null) {
			entityVoyage = new EntityVoyage(voyage.getNom());
			entityVoyage.setDateDebut(voyage.getDateDebut());
			entityVoyage.setNbParticipant(voyage.getNbParticipant());
			entityVoyage.setEntityPointInterets(createEntityFromPOI(voyage.getPointInteret()));
		}
		return entityVoyage;
	}

	public EntityVoyage createEntityWithIdFrom(Voyage voyage) {
		EntityVoyage entityVoyage = null;
		if (voyage!=null) {
			entityVoyage = createEntityFrom(voyage);
			entityVoyage.setId(voyage.getId());
		}
		return entityVoyage;
	}

	public Voyage createFromEntity(EntityVoyage entityVoyage) {
		Voyage voyage = null;
		if (entityVoyage!=null) {
			voyage = new Voyage(entityVoyage.getNom());
			voyage.setId(entityVoyage.getId());
			voyage.setDateDebut(entityVoyage.getDateDebut());
			voyage.setNbParticipant(entityVoyage.getNbParticipant());
			voyage.setPointInteret(createFromEntityPOI(entityVoyage.getEntityPointInterets()));
		}
		return voyage;
	}

	private List<EntityVoyage> createEntityFrom(List<Voyage> voyages) {
		List<EntityVoyage>  entityVoyages = null;
		if (voyages!=null) {
			entityVoyages = new ArrayList<>();
			for (Voyage voyage : voyages) {
				EntityVoyage entityVoyage = createEntityFrom(voyage);
				entityVoyages.add(entityVoyage);
			}
		}
		return entityVoyages;
	}

	private List<EntityVoyage> createEntityWithIdFrom(List<Voyage> voyages) {
		List<EntityVoyage>  entityVoyages = null;
		if (voyages!=null) {
			entityVoyages = new ArrayList<>();
			for (Voyage voyage : voyages) {
				EntityVoyage entityVoyage = createEntityWithIdFrom(voyage);
				entityVoyages.add(entityVoyage);
			}
		}
		return entityVoyages;
	}

	private List<Voyage> createFromEntity(List<EntityVoyage> entityVoyages) {
		List<Voyage> voyages = null;
		if (entityVoyages!=null) {
			voyages = new ArrayList<>();
			for (EntityVoyage entityVoyage : entityVoyages) {
				Voyage voyage = createFromEntity(entityVoyage);
				voyages.add(voyage);
			}
		}
		return voyages;
	}

	public EntityRoadBook createEntityFrom(RoadBook roadBook) {
		EntityRoadBook entityRoadBook = null;
		if (roadBook!=null) {
			entityRoadBook = new EntityRoadBook();
			entityRoadBook.setEntityVoyages(createEntityFrom(roadBook.getVoyages()));;
			Utilisateur utilisateur = roadBook.getUtilisateur();
			EntityUtilisateur entityUtilisateur = new EntityUtilisateur();
			entityUtilisateur.setId(utilisateur.getId());
			entityRoadBook.setEntityUtilisateur(entityUtilisateur);
		}
		return entityRoadBook;
	}

	public EntityRoadBook createEntityWithIdFrom(RoadBook roadBook) {
		EntityRoadBook entityRoadBook = null;
		if (roadBook!=null) {
			entityRoadBook = new EntityRoadBook();
			entityRoadBook.setEntityVoyages(createEntityWithIdFrom(roadBook.getVoyages()));;
			Utilisateur utilisateur = roadBook.getUtilisateur();
			EntityUtilisateur entityUtilisateur = new EntityUtilisateur();
			entityUtilisateur.setId(utilisateur.getId());
			entityRoadBook.setEntityUtilisateur(entityUtilisateur);
			entityRoadBook.setId(roadBook.getId());
		}
		return entityRoadBook;
	}


	public RoadBook createFromEntity(EntityRoadBook entityRoadBook) {
		RoadBook roadBook = null;
		if (entityRoadBook!=null) {
			EntityUtilisateur entityUtilisateur = entityRoadBook.getEntityUtilisateur();
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setId(entityUtilisateur.getId());
			roadBook = new RoadBook(utilisateur);
			roadBook.setId(entityRoadBook.getId());
			roadBook.setVoyages(createFromEntity(entityRoadBook.getEntityVoyages()));
		}
		return roadBook;
	}

	public List<PointInteret> createFromEntityPOI(List<EntityPointInteret> listEntityPOI) {
		List<PointInteret> listPOI = null;
		if(listEntityPOI!=null){

			listPOI = new ArrayList<>();
			for (EntityPointInteret entityPOI : listEntityPOI) {
				PointInteret pointInteret = createFromEntity(entityPOI);
				listPOI.add(pointInteret);
			}
		}
		return listPOI;
	}

	@SuppressWarnings("unchecked")
	public <T extends PointInteret> T createFromEntity(EntityPointInteret entityPOI) {
		if (entityPOI instanceof EntityLieu) return (T) createFromEntity((EntityLieu)entityPOI);
		else if (entityPOI instanceof EntityVille) return (T) createFromEntity((EntityVille)entityPOI);
		else if (entityPOI instanceof EntityPays) return (T) createFromEntity((EntityPays)entityPOI);
		else return null;
	}

	public Coordonnee createFromEntity(EntityCoordonnee entityCoordonnee) {
		Coordonnee coordonnee = null;
		if (entityCoordonnee !=null) {
			coordonnee = new Coordonnee(entityCoordonnee.getLatitude(), entityCoordonnee.getLongitude());
			coordonnee.setId(entityCoordonnee.getId());
		}
		return coordonnee;
	}

//	public Coordonnee createFromEntityWithId(EntityCoordonnee entityCoordonnee) {
//		Coordonnee coordonnee = null;
//		if (entityCoordonnee !=null) {
//			coordonnee = createFromEntity(entityCoordonnee);
//			coordonnee.setId(entityCoordonnee.getId());
//		}
//		return coordonnee;
//	}

	public EntityCoordonnee createEntityFrom(Coordonnee coordonnee) {
		EntityCoordonnee entityCoord = null;
		if (coordonnee !=null) {
			entityCoord = new EntityCoordonnee(coordonnee.getLatitude(), coordonnee.getLongitude());
		}
		return entityCoord ;
	}


	public Lieu createFromEntity(EntityLieu entityLieu) {
		Lieu lieu = null;
		if (entityLieu!=null) {
			lieu = new Lieu(entityLieu.getNom());
			lieu.setId(entityLieu.getId());
			lieu.setCoordonnee(createFromEntity(entityLieu.getEntityCoordonnee()));
			lieu.setVille(createFromEntity(entityLieu.getEntityVille()));
			lieu.getVille().setId(entityLieu.getEntityVille().getId());
		}
		return lieu;
	}

	public Ville createFromEntity(EntityVille entityVille) {
		Ville ville = null;
		if (entityVille!=null) {
			ville = new Ville(entityVille.getNom());
			ville.setId(entityVille.getId());
			ville.setCoordonnee(createFromEntity(entityVille.getEntityCoordonnee()));
			ville.setPays(createFromEntity(entityVille.getEntityPays()));
			ville.getPays().setId(entityVille.getEntityPays().getId());
		}
		System.out.println(ville);
		return ville;
	}

	public Pays createFromEntity(EntityPays entityPays) {
		Pays pays = null;
		if (entityPays!=null) {
			pays = new Pays(entityPays.getNom());
			pays.setId(entityPays.getId());
			pays.setCoordonnee(createFromEntity(entityPays.getEntityCoordonnee()));
			pays.getCoordonnee().setId(entityPays.getEntityCoordonnee().getId());
		}
		System.out.println(pays);
		return pays;
	}
	
	public List<EntityPointInteret> createEntityFromPOI(List<PointInteret> listPOI) {
		List<EntityPointInteret> entityListPOI = null;
		if (listPOI!=null) {
			entityListPOI = new ArrayList<>();
			for (PointInteret pointInteret : listPOI) {
				EntityPointInteret entityPointInteret = createEntityFrom(pointInteret);
				entityListPOI.add(entityPointInteret);
			}
		}
		
		return entityListPOI;
	}

	@SuppressWarnings("unchecked")
	public <T extends EntityPointInteret> T createEntityFrom(PointInteret pointInteret) {
		System.out.println(pointInteret.getNom());
		if (pointInteret instanceof Lieu) return (T) createEntityFrom((Lieu)pointInteret);
		else if (pointInteret instanceof Ville) return (T) createEntityFrom((Ville)pointInteret);
		else if (pointInteret instanceof Pays) return (T) createEntityFrom((Pays)pointInteret);
		else return null;
	}

	public EntityLieu createEntityFrom(Lieu lieu) {
		EntityLieu entityLieu = null;
		if (lieu!=null) {
			entityLieu = new EntityLieu(lieu.getNom());
			entityLieu.setEntityCoordonnee(createEntityFrom(lieu.getCoordonnee()));
			entityLieu.setEntityVille(createEntityFrom(lieu.getVille()));
			entityLieu.getEntityVille().setId(lieu.getVille().getId());
		}
		return entityLieu;
	}

	public EntityVille createEntityFrom(Ville ville) {
		EntityVille entityVille = null;
		if (ville!=null) {
			entityVille = new EntityVille(ville.getNom());
			entityVille.setEntityCoordonnee(createEntityFrom(ville.getCoordonnee()));
			entityVille.setEntityPays(createEntityFrom(ville.getPays()));
			entityVille.getEntityPays().setId(ville.getPays().getId());
		}
		return entityVille;
	}

	public EntityPays createEntityFrom(Pays pays) {
		EntityPays entityPays = null;
		if (pays!=null) {
			entityPays = new EntityPays(pays.getNom());
			entityPays.setEntityCoordonnee(createEntityFrom(pays.getCoordonnee()));
			entityPays.getEntityCoordonnee().setId(pays.getCoordonnee().getId());
		}
		System.out.println(entityPays);
		return entityPays;
	}
}
