import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class TestModele {
	private boolean rep,rep2;
	private int nb;
	
	@Before
	public void setUp() {
		int unId = 1; // exemple de numAvion
		int uneD = 1; // exemple de numDestination
		String date = "2016-08-16";
		String anne = "201";
		
		LocalDate localDate = LocalDate.parse(date);
		Date uneDate = new Date(localDate);
		rep = Modele.ajouteVolCourrier(uneDate, unId, uneD);
		//1er test
		nb = Modele.getNbAvion();
		rep2 = Modele.verifSaisie(anne);
	}
	
	//teste la requête SQL permettant d'obtenir le nombre d'avions
	@Test
	public void testNbAvion(){
		assertEquals("Le nombre est incorrect",0,nb);
	}
	
	// Test qui permet d'ajouter un vol courrier dans la base de données
	@Test
	public void testAjouterUnVolCourrier() {
		assertEquals("Le vol courrier n'a pas put etre ajoute",true,rep);
	}
	//Test qui verifie que la chaine est bien composé exclusivement de chiffre et inferieur a 4 lettre
	@Test
	public void testEstBienUnNb(){
		assertEquals("Il ya une lettre ou un carcatere special",true,rep2);
	}
}
