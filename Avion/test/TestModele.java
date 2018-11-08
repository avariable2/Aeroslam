import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestModele {
	private boolean rep;
	@Before
	public void setUp() {
		int unId = 1; // exemple de numAvion
		int uneD = 1; // exemple de numDestination
		String date = "2016-08-16";
		LocalDate localDate = LocalDate.parse(date);
		Date uneDate = new Date(localDate);
		rep = Modele.ajouteVolCourrier(uneDate, unId, uneD);
	}
	// Test qui permet d'ajouter un vol courrier dans la base de données
	@Test
	public void testAjouterUnVolCourrier() {
		
		assertEquals("Le vol courrier n'a pas put etre ajoute",true,rep);
	}

}
