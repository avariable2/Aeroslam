public class IndexLibelle {

    private String nomA ;
    private int numA;

	// Constructeur de la classe IndexLibelle

	public IndexLibelle (int num, String nom) {
  	    this.numA = num;
	    this.nomA = nom;
	}

	//Cette m�thode permet de retourner l'attribut index

    public String getNomAvion( ) { 
    	return this.nomA; 
    }

	//Cette m�thode permet de retourner l'attribut libelle

   	 public int getNumAvion( ) {                    
   		 return this.numA; 
     }

    /* L'annotation @Override doit �tre utilis�e lorsqu'une m�thode red�finit la m�thode de la superclasse */
   	@Override 
	//c'est cette m�thode qui est appel�e par la liste d�roulante lors de sa cr�ation
   	public String toString() { 
   		return this.nomA;
   	}
}
