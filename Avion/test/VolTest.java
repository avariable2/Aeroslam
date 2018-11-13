import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VolTest {
	private VolCourrier unVol;
	@Before
	public void setUp(){
		unVol = Modele.voirVolCourrier().get(0);
		System.out.println(unVol.toXML());
	}
	// Tst qui permet de verifier que le toXML fonctionne et ne retourne pas rien
	@Test
	public void testToXml() {
		assertNotNull("La chaine n'est pas vide",unVol.toXML());
	}

}
