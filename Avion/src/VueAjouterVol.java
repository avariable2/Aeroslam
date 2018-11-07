import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;



public class VueAjouterVol extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel txt1,txt2,txt3,txt4;
	private JTextField txtf1,txtf2;
	private JRadioButton rad1,rad2;
	private ButtonGroup groupeBouton;
	private JButton btn;
	private JComboBox<IndexLibelle> listeAvion;
	private JComboBox<IndexLibelle> listeDestination;
	
	
	public VueAjouterVol(){
		this.setLayout(new GridLayout(6,1));
		
		this.txt1 = new JLabel("Saisir votre vol : ");
		this.rad1 = new JRadioButton("Courrier");
		this.rad1 = new JRadioButton("Commerciaux");
		this.groupeBouton= new ButtonGroup();
		this.groupeBouton.add(this.rad1);
		this.groupeBouton.add(this.rad2);
		this.txt2 = new JLabel("Saisir la date de depart : ");
		this.txtf2 = new JTextField();
		this.txtf2.setPreferredSize(new Dimension(100,30));
		this.txt4 = new JLabel("Selectionner Avion :");
	    //On crée l'objet JComboBox
	    this.listeAvion = new JComboBox<IndexLibelle>();
		
	    /*On ajoute des éléments à la liste déroulante. Ces éléments sont de type IndexLibelle et comprennent deux champs correspondant respectivement à l'attribut index et à l'attribut libelle.*/
	    ArrayList<Avion> liste = Modele.voirAvion();
	    for(int i=0;i<Modele.getNbAvion();i++){
	    	this.listeAvion.addItem(new IndexLibelle(liste.get(i).getNumAvion(),liste.get(i).getNomAvion()));
	    }
	    this.txt3 = new JLabel("Saisir la destination : ");
	    this.listeDestination = new JComboBox<IndexLibelle>();
	    ArrayList<Destination> liste2 = Modele.voirDestination();
	    for(int i=0;i<Modele.getNbDestination();i++){
	    	this.listeDestination.addItem(new IndexLibelle(liste2.get(i).getNb(),liste2.get(i).getVille()));
	    }
		this.btn = new JButton("Valider");
		this.btn.addActionListener(this);
		
		this.add(this.txt1);
		this.add(this.rad1);
		this.add(this.rad2);
		this.add(this.txt2);
		this.add(this.txtf2);
		this.add(this.listeAvion);
		this.add(this.txt3);
		this.add(this.listeDestination);
		this.add(this.btn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btn){
			int id = ((IndexLibelle) listeAvion.getSelectedItem()).getNumAvion();
			int id2 = ((IndexLibelle) listeDestination.getSelectedItem()).getNumAvion();
			if(!this.txtf2.getText().equals(null) && !this.txtf1.getText().equals(null)){
				if(this.rad1.isSelected()){
					Date laDate = new Date(null);
					Modele.ajouteVolCourrier(laDate,id,id2);
				}
			}else{
				this.txt3 = new JLabel("Veuillez saisir tout les champs.");
				this.add(this.txt3);
				revalidate();
			}
		}
	}
	
	
}