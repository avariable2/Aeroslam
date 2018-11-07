public class IndexLibelle {

    private String nomA ;
    private int numA;

	// Constructeur de la classe IndexLibelle

	public IndexLibelle (int num, String nom) {
  	    this.numA = num;
	    this.nomA = nom;
	}

	//Cette méthode permet de retourner l'attribut index

    public String getNomAvion( ) { 
    	return this.nomA; 
    }

	//Cette méthode permet de retourner l'attribut libelle

   	 public int getNumAvion( ) {                    
   		 return this.numA; 
     }

    /* L'annotation @Override doit être utilisée lorsqu'une méthode redéfinit la méthode de la superclasse */
   	@Override 
	//c'est cette méthode qui est appelée par la liste déroulante lors de sa création
   	public String toString() { 
   		return this.nomA;
   	}
}
