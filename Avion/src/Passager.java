import java.util.ArrayList;

public class Passager {
	private int numP;
	private String nomP;
	private String prenomP;
	private String ville;
	private ArrayList<VolCourrier> cesVols;
	
	public Passager(int unNum, String unNom, String unPrenom){
		this.numP =unNum;
		this.nomP=unNom;
		this.prenomP=unPrenom;
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
}
