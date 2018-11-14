import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Test;

import org.junit.Before;

public class TestModele {
	private boolean rep;
	VolCourrier rep2;
	private int nb;
	@Before
	public void setUp() {
		int unId = 0; // exemple de numAvion
		int uneD = 0; // exemple de numDestination
		String date = "2016-08-16";
		String anne = "201";
		
		LocalDate localDate = LocalDate.parse(date);
		Date uneDate = new Date(localDate);
		//rep = Modele.ajouteVolCourrier(uneDate, unId, uneD);
		//1er test
		nb = Modele.getNbAvion();
		rep2 = Modele.rechVolCourrier(1);
	}
	
	//teste la requête SQL permettant d'obtenir le nombre d'avions
	@Test
	public void testNbAvion(){
		assertEquals("Le nombre est incorrect",1,nb);
	}
	
	// Test qui permet d'ajouter un vol courrier dans la base de données
	// Ce test fonctionne si un avion et une destination sont bien instancier dans la table Avion et Destination
	@Test
	public void testAjouterUnVolCourrier() {
		assertEquals("Le vol courrier n'a pas put etre ajoute",true,rep);
	}
	//Test qui verifie que la chaine est bien composé exclusivement de chiffre et inferieur a 4 lettre
	@Test
	public void testEstBienUnNb(){
		assertEquals("Il ya une lettre ou un carcatere special",true,rep2);
	}
	//Test qui permet de verifier que l'on recupere bien tout les avions
	@Test
	public void testGetLesAvions(){
		assertEquals("Il n'y a pas la totalite des avions",1,Modele.voirAvion().size());
	}
	//Verifie le nombre de vol
	@Test
	public void testNbVol(){
		assertEquals("Erreur : la fonction ne renvoie pas tout les Vol",1,Modele.getNbVolDate("2018-03-03"));
	}
	//test pour voir si l'on recupere bien le passager quand on cherhce son id
	@Test
	public void testLeBonPassager(){
		assertEquals("Erreur : la fonction ne renvoie pas de vol",1,rep2.getNumVol());
	}
}
