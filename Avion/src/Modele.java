import java.sql.*;
import java.util.ArrayList;
import java.awt.*;

public class Modele {
	private static Connection connexion;
	private static PreparedStatement st;
	private static ResultSet rs;
	
	/***
	 * Function qui permet d'etablir une connexion a la base de donne jusqu'a sa fermeture. Elle renvoie true si la connexion est reussi
	 * et false si elle n'a pas aboutie.
	 * @author Adrien
	 * @return true/false
	 */
	public static boolean connexion(){
		boolean rep = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/aeroport","root","");
			rep = true;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep;
	}
	/***
	 * Function qui permet de se deconnecter de la base de donn�e. Elle renvoie true si le lien entre la base a �t� romput 
	 * et false si c'est l'inverse qui se produit.
	 * @author Adrien
	 * @return true/false
	 */
	public static boolean deconnexion(){
		boolean rep = false;
		try {
			connexion.close();
			rep = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep;
	}
	/***
	 * Function qui permet de verifier que le nom d'utilisateur et le mot de passe mit en paramtere est bien dans la base de donn�e
	 * et que c'est bien un comptable.Si oui, la fonction renvoie 1, sinon elle renvoie 0.
	 * @author Adrien
	 * @param unLog
	 * @param unMdp
	 * @return 0/1
	 */
	public static int coBdd(String unLog, String unMdp){
		int rep=0;
		Modele.connexion();
		try {
			st = connexion.prepareStatement("SELECT COUNT(login) FROM Utilisateur WHERE mdp=? AND login=?");
			st.setString(1,unMdp);
			st.setString(2,unLog);
			rs = st.executeQuery();
			rs.next();
			rep = rs.getInt(1);
			rs.close();
			st.close();
			Modele.deconnexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep;
	}
	/***
	 * Function qui permet de saisir dans la table Avion un avion. 
	 * @author Adrien
	 * @param unNb
	 * @param unNom
	 * @return true/false
	 */
	// Avion
	public static boolean ajouteAvion(int unNb, String unNom){
		boolean rep = false;
		Modele.connexion();
		try {
			st = connexion.prepareStatement("INSERT INTO Avion VALUES(null,?,?)");
			st.setString(1, unNom);
			st.setInt(2, unNb);
			st.executeUpdate();
			rep = true;
			st.close();
			Modele.deconnexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep;
	}
	/***
	 * Function qui permet de renvoyer dans une ArrayList la liste des Avions stock�s dans la base de donn�e.
	 * @author Adrien
	 * @return ArrayList<Avion>unTableau d'Avion
	 */
	public static ArrayList<Avion> voirAvion(){
		ArrayList<Avion> lesAvion = new ArrayList<Avion>();
		Modele.connexion();
		try {
			st = connexion.prepareStatement("SELECT * FROM Avion ");
			rs = st.executeQuery();
			while(rs.next()){
				Avion unAvion = new Avion(rs.getInt(1),rs.getString(2),rs.getInt(3));
				lesAvion.add(unAvion);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Modele.deconnexion();
		return lesAvion;
	}
	/***
	 * Function qui retourne le nombre d'avion cr�er dans la table Avion.
	 * @author Adrien
	 * @return nb qui correspond au nombre d'avion dans la bdd
	 */
	public static int getNbAvion(){
		int nb = 0;
		Modele.connexion();
		try {
			st= connexion.prepareStatement("SELECT COUNT(numAv) AS nb FROM Avion");
			rs = st.executeQuery();
			rs.next();
			nb = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}
	
	/***
	 * Function qui permet d'ajouter une destination garce au parametre dans la table Destination.
	 * @param uneVille
	 * @param unPays
	 * @return true/false
	 */
	//Destination 
	public static boolean ajouteDestination(String uneVille, String unPays){
		boolean rep = false;
		Modele.connexion();
		try {
			st = connexion.prepareStatement("INSERT INTO Destination VALUES(null,?,?)");
			st.setString(1, uneVille);
			st.setString(2, unPays);
			st.executeUpdate();
			rep = true;
			st.close();
			Modele.deconnexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep;
	}
	/***
	 * Function qui permet de renvoyer les destinations retrer dans la table destination de la bdd.
	 * @author Adrien
	 * @return ArrayList<Destination> lesDestinations
	 */
	public static ArrayList<Destination> voirDestination(){
		ArrayList<Destination> lesDestiantion = new ArrayList<Destination>();
		Modele.connexion();
		try {
			st = connexion.prepareStatement("SELECT * FROM Destination ");
			rs = st.executeQuery();
			while(rs.next()){
				Destination uneDest = new Destination(rs.getInt(1),rs.getString(2),rs.getString(3));
				lesDestiantion.add(uneDest);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Modele.deconnexion();
		return lesDestiantion;
	}
	/***
	 * Function qui retourne le nombre de destination creer dans la table destination.
	 * @author Adrien
	 * @return nb de Destination dans la bdd
	 */
	public static int getNbDestination(){
		int nb = 0;
		Modele.connexion();
		try {
			st= connexion.prepareStatement("SELECT COUNT(id_dest) AS nb FROM Destination");
			rs = st.executeQuery();
			rs.next();
			nb = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}
	/***
	 * Function qui ajoute un Vol dans la table VolCourrier gr�ce aux parametres.
	 * @author Adrien
	 * @param uneDate
	 * @param id
	 * @param unD
	 * @return true/false
	 */
	public static boolean ajouteVolCourrier(Date uneDate, int id, int unD){
		boolean rep = false;
		if((Modele.getNbAvion()>0) && (Modele.getNbDestination()>0)){ // On ne peut pas ajouter un vol si il n'y a aucun avion creer et aucune destination
			Modele.connexion();
			try {
				st = connexion.prepareStatement("INSERT INTO volcourrier VALUES(null,?,?,?)");
				java.sql.Date laDate = java.sql.Date.valueOf(uneDate.getDate());
				st.setDate(1,laDate);
				st.setInt(2, id);
				st.setInt(3,unD);
				st.executeUpdate();
				rep = true;
				st.close();
				Modele.deconnexion();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rep;
	}
	/***
	 * Function qui ajoute un Vol dans la table VolCourrier gr�ce aux parametres.
	 * @return ArrayList<VolCourrier>
	 */
	public static ArrayList<VolCourrier> voirVolCourrier(){
		ArrayList<VolCourrier> lesVol = new ArrayList<VolCourrier>();
		Modele.connexion();
		try {
			st = connexion.prepareStatement("SELECT * FROM VolCourrier ");
			rs = st.executeQuery();
			while(rs.next()){
				VolCourrier unVol = new VolCourrier(rs.getInt(1),new Date(rs.getDate(2).toLocalDate()),rs.getInt(3),rs.getInt(4));
				lesVol.add(unVol);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Modele.deconnexion();
		return lesVol;		
	}
	
	/***
	 * Function qui ajoute un Vol dans la table VolCommerciaux gr�ce aux parametres.
	 * @param uneDate
	 * @param id
	 * @param unD
	 * @return true/false
	 */
	public static boolean ajouteVolCommercial(Date uneDate, int id, int unD){
		boolean rep = false;
		Modele.connexion();
		try {
			st = connexion.prepareStatement("INSERT INTO volcommercial VALUES(null,?,?,?)");
			java.sql.Date laDate = java.sql.Date.valueOf(uneDate.getDate());
			st.setDate(1,laDate);
			st.setInt(2, id);
			st.setInt(3,unD);
			st.executeUpdate();
			rep = true;
			st.close();
			Modele.deconnexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rep;
	}
	/***
	 * Function qui retourne la liste des vols commercial dans une ArrayList.
	 * @author Adrien
	 * @return ArrayList<VolCommercial>
	 */
	public static ArrayList<VolCommercial> voirVolCommercial(){
		ArrayList<VolCommercial> lesVol = new ArrayList<VolCommercial>();
		Modele.connexion();
		try {
			st = connexion.prepareStatement("SELECT * FROM VolCommercial ");
			rs = st.executeQuery();
			while(rs.next()){
				VolCommercial unVol = new VolCommercial(rs.getInt(1),new Date(rs.getDate(2).toLocalDate()),rs.getInt(3),rs.getInt(4));
				lesVol.add(unVol);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Modele.deconnexion();
		return lesVol;		
	}
	/***
	 * Function qui permet de recuperer la liste des Vols toute categorie.
	 * @author Adrien
	 * @return ArrayList<Vol>
	 */
	public static ArrayList<Vol> voirVol(){
		ArrayList<Vol> lesVols = new ArrayList<Vol>();
		ArrayList<VolCommercial> lesVolCommerciaux = Modele.voirVolCommercial();
		ArrayList<VolCourrier> lesVolCourrier = Modele.voirVolCourrier();
		for(int i=0;i<lesVolCommerciaux.size();i++){
			int num = lesVolCommerciaux.get(i).getNumVol();
			Date date = lesVolCommerciaux.get(i).getDate();
			int numAvion = lesVolCommerciaux.get(i).getNumAvion();
			int numDest = lesVolCommerciaux.get(i).getDestination();
			Vol unVol = new Vol(num,date,numAvion,numDest);
			unVol.setType(0);// 0 correspond au vol commerciaux et 1 au vol courrier
			lesVols.add(unVol);
		}
		for(int i=0;i<lesVolCourrier.size();i++){
			int num = lesVolCourrier.get(i).getNumVol();
			Date date = lesVolCourrier.get(i).getDate();
			int numAvion = lesVolCourrier.get(i).getNumAvion();
			int numDest = lesVolCourrier.get(i).getDestination();
			Vol unVol = new Vol(num,date,numAvion,numDest);
			unVol.setType(1);// 0 correspond au vol commerciaux et 1 au vol courrier
			lesVols.add(unVol);
		}
		return lesVols;
	}
	/***
	 * Function qui retourne le nombre de vol toute categories.
	 * @return nb (int)
	 */
	public static int getNbVol(){
		int nb = Modele.voirVol().size();
		return nb;
	}
	/***
	 * Function qui verifie que la chaine rentrer en parametre ne contient que des nombres.
	 * @param uneA
	 * @return true/false
	 */
	public static boolean verifSaisie(String uneA){
		boolean rep = true;
		int i =0;
		while(i<uneA.length() && (uneA.charAt(0)=='1' || uneA.charAt(0)=='2') 
				&& (47< (int)uneA.charAt(i) && (int)uneA.charAt(i) < 58)){ // on recupere le code ascii des caractere et on verifie qu'il sont
			// compris entre le coide ascii de 0 et de 9.
			i=i+1;
		}
		if(i<uneA.length()){
			rep = false;
		}
		return rep;
		
	}
}
