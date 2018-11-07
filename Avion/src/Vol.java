
public class Vol {
	private int numVol;
	private int type;
	private Date date;
	private int numAvion;
	private String destination;
	private int id_personne;
	
	public Vol(int unNumVol, int untype, Date uneDate,int unNumA,String uneDest){
		this.numVol = unNumVol;
		this.type = untype;
		this.date = uneDate;
		this.numAvion = unNumA;
		this.destination = uneDest;
	}
	public int getType(){
		return type;
	}

	public int getNumVol() {
		return numVol;
	}

	public void setNumVol(int numVol) {
		this.numVol = numVol;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNumAvion() {
		return numAvion;
	}

	public void setNumAvion(int numAvion) {
		this.numAvion = numAvion;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getId_personne() {
		return id_personne;
	}

	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	
}
