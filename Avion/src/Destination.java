
public class Destination {
	private String ville;
	private String pays;
	private int nb;
	
	public Destination(int unNb,String uneVille,String unPays){
		this.nb= unNb;
		this.ville = uneVille;
		this.pays = unPays;
	}

	public String getVille() {
		return this.ville;
	}
	public String getPays(){
		return this.pays;
	}
	public int getNb(){
		return this.nb;
	}
	public String toXML(){
		String chaine = "<DESTINATION>\n<NB>"+this.nb+"</NB>\n<VILLE>"+this.ville+"</VILLE>\n";
		chaine = chaine + "<PAYS>"+this.pays+"</PAYS>\n</DESTINATION>";
		return chaine;
	}
	
}
