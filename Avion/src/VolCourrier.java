import java.util.ArrayList;

public class VolCourrier extends Vol{
	private ArrayList<Passager> lesPassagers; //contient la liste des passagers de ce vol

	/***
	 * Constructeur de la classe VolCourrier.
	 * @param unNumVol
	 * @param uneDate
	 * @param unNumA
	 * @param uneDest
	 */
	public VolCourrier(int unNumVol, Date uneDate, int unNumA, int uneDest) {
		super(unNumVol, uneDate, unNumA, uneDest);
		this.lesPassagers = new ArrayList<Passager>();
	}
	/***
	 * Procedure qui ajoute un passager dans le vol courant.
	 * @author Adrien
	 * @param unPass
	 */
	public void ajouterPassager(Passager unPass){
		this.lesPassagers.add(unPass);
	}
	
	public String toXML(){
		String chaine = "<VOLCOURRIER>"+super.toXML()+"\t <LESPASSAGERS>\n";
		for(int i=0;i<this.lesPassagers.size();i++){
			chaine = chaine + "\t"+this.lesPassagers.get(i).toXML();
		}
		chaine = chaine + "\t </LESPASSAGERS>"+ "\n</VOLCOURRIER>";
		return chaine;
	}
	
}
