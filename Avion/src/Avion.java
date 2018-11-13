
public class Avion {
	private int numAvion;
	private int nbPlaces;
	private String nomAvion;
	
	public Avion(int unNum,String unNom, int unNb){
		this.numAvion = unNum;
		this.nbPlaces = unNb;
		this.nomAvion = unNom;
	}

	public int getNumAvion() {
		return numAvion;
	}

	public void setNumAvion(int numAvion) {
		this.numAvion = numAvion;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public String getNomAvion() {
		return nomAvion;
	}

	public void setNomAvion(String nomAvion) {
		this.nomAvion = nomAvion;
	}
	public String toXML(){
		String chaine = "<AVION>\n \t <NUMAVION>"+this.numAvion+"</NUMAVION>\n";
		chaine = chaine + "\t <NOMAVION>"+this.nomAvion+"</NOMAVION>\n";
		chaine = chaine + "\t <NOMBREPLACE>"+this.nbPlaces+"</NOMBREPLACE>\n</AVION>";
		return chaine;
	}
	
}
