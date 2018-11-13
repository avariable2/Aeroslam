import java.util.ArrayList;

public class Passager {
	private int numP;
	private String nomP;
	private String prenomP;
	private String ville;
	private ArrayList<VolCourrier> cesVols;
	
	public Passager(int unNum, String unNom, String unPrenom,String uneVille){
		this.numP =unNum;
		this.nomP=unNom;
		this.prenomP=unPrenom;
		this.ville = uneVille;
		this.cesVols = new ArrayList<VolCourrier>();
	}
	
	public void ajouterVol(VolCourrier unVol){
		this.cesVols.add(unVol);
	}
	public int getNumP() {
		return numP;
	}
	public String getPrenomP() {
		return prenomP;
	}
	public String getVille() {
		return ville;
	}
	public String getNomP() {
		return nomP;
	}
	public String toXML(){
		String chaine = "<PASSAGER>\n \t <ID>"+this.numP+"</ID>\n";
		chaine = chaine + "\t <NOM>"+this.nomP+"</NOM>\n";
		chaine = chaine + "\t <PRENOM>"+this.prenomP+"</PRENOM>\n";
		chaine = chaine + "\t <VILLE>"+this.ville+"</VILLE>\n";
		for(int i=0;i<this.cesVols.size();i++){
			chaine = chaine + this.cesVols.get(i).toXML();
		}
		return chaine;
	}
}
