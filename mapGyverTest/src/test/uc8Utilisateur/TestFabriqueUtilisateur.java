package test.uc8Utilisateur;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;


import org.junit.Before;
import org.junit.Test;

import business.uc8Utilisateur.Password;
import business.uc8Utilisateur.Utilisateur;
import dao.uc8Utilisateur.fabrique.FabriqueEntity;
import entity.uc8Utilisateur.EntityPassword;
import entity.uc8Utilisateur.EntityUtilisateur;

public class TestFabriqueUtilisateur {

	private FabriqueEntity fabrique= new FabriqueEntity();
	private Utilisateur user;
	private EntityUtilisateur eUser;
	private Password pw;
	private EntityPassword ePw;
	
	@Before
	public void preparation() {
		pw= new Password("000");
		ePw= new EntityPassword("azerty");
		user= new Utilisateur("djallel", "bensehil","12 rue du sucre", "mon@cdi.fr", "0651703754", LocalDate.now(), LocalDate.now(), pw);
		eUser= new EntityUtilisateur("micheal", "corleon", "place de venise", "olive@sicile.fr", "049181301", LocalDate.now(), LocalDate.now(), ePw);
	}
	
	@Test
	public void fabriqueUserEntity() {
		EntityPassword	lePw= fabrique.createEntityPassword(pw);
		EntityUtilisateur leUser= fabrique.createEntityUser(user);
		leUser.setMotDePasse(lePw);
		assertEquals(user.getNom(), leUser.getNom());
		assertEquals(leUser.getMotDePasse().getPassword(), user.getMotDePasse().getPassword());
	}
	
	@Test
	public void fabriqueUser() {
		Password passoword= fabrique.createPassword(ePw);
		Utilisateur utilisateur= fabrique.createUser(eUser);
		utilisateur.setMotDePasse(passoword);
		assertNotNull(utilisateur);
		assertEquals(utilisateur.getEmail(), eUser.getEmail());
		assertEquals(utilisateur.getMotDePasse().getPassword(), eUser.getMotDePasse().getPassword());
	}
}
