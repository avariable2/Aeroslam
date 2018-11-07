
public class Destination {
	private String ville;
	private String pays;
	
	public Destination(String uneVille,String unPays){
		this.ville = uneVille;
		this.pays = unPays;
	}

	public String getVille() {
		return this.ville;
	}
	public String getPays(){
		return this.pays;
	}
	public String toXML(){
		String chaine = "<DESTINATION>\n<VILLE>"+this.ville+"</VILLE>\n";
		chaine = chaine + "<PAYS>"+this.pays+"</PAYS>\n</DESTINATION>";
		return chaine;
	}
	
}
