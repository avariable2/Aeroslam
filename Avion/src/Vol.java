
public class Vol {
	private int numVol;
	private Date date;
	private int numAvion;
	private int numDestination;
	private int type;
	
	public Vol(int unNumVol, Date uneDate,int unNumA,int uneDest){
		this.numVol = unNumVol;
		this.date = uneDate;
		this.numAvion = unNumA;
		this.numDestination = uneDest;
	}
	public void setType(int unType){
		this.type = unType;
	}
	public int getType(){
		return this.type;
	}
	public int getNumVol() {
		return numVol;
	}
	public Date getDate() {
		return date;
	}
	public int getNumAvion() {
		return numAvion;
	}
	public int getDestination() {
		return numDestination;
	}
	
}
