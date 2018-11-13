import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AvionTest {
	private Avion unAvion;
	private String res;
	@Before
	public void setUp(){
		unAvion = new Avion(0, "A380",500);
		res = unAvion.toXML();
		System.out.println(res);
	}
	//Test qui permet de verifier que le toXml() ne retourne pas null
	@Test
	public void testToXml() {
		assertNotNull("La chaine n'est pas vide",res);
	}

}
