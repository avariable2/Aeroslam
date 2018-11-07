import java.sql.*;
import java.util.ArrayList;

public class Modele {
	private static Connection connexion;
	private static PreparedStatement st;
	private static ResultSet rs;
	
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
	public static int getNbAvion(){
		ArrayList<Avion> lesAvion = Modele.voirAvion();
		int nb = lesAvion.size();
		return nb;
	}
	
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
	public static int getNbDestination(){
		ArrayList<Destination> lesDestination = Modele.voirDestination();
		int nb = lesDestination.size();
		return nb;
	}
	public static boolean ajouteVolCourrier( Date uneDate, int id, int unD){
		boolean rep = false;
		Modele.connexion();
		try {
			st = connexion.prepareStatement("INSERT INTO volcourrier VALUES(null,?,?,?,null)");
			String conversion = uneDate.getDateFrancais();
			st.setString(1,conversion );
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
}
