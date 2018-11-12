public class Main {
	
	public static void main(String[] args){
		if(Modele.connexion()){
			new VueIndex();
			Modele.deconnexion();
		}else{
			System.out.println("non");
		}
	}
	
}
