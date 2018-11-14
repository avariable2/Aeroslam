import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;



public class VueAjouterVol extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel txt1,txt2,txt3,txtJour,txtMois,txtAnnee;
	private JTextField txtf2;
	private JRadioButton rad1,rad2;
	private ButtonGroup groupeBouton;
	private JButton btn;
	private JComboBox<IndexLibelle> listeAvion;
	private JComboBox<IndexLibelle> listeDestination;
	private JLabel txt4;
	private JComboBox<?> listeJ, listeM;
	private JPanel panelVol,panelDate,panelAD;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VueAjouterVol(){
		this.setLayout(new GridLayout(3,1));
		
		//On saisi le vol
		this.panelVol = new JPanel();
		this.txt1 = new JLabel("Saisir votre vol : ");
		this.rad1 = new JRadioButton("Courrier");
		this.rad2 = new JRadioButton("Commerciaux");
		this.groupeBouton= new ButtonGroup();
		this.groupeBouton.add(this.rad1);
		this.groupeBouton.add(this.rad2);
		this.panelVol.add(this.txt1);
		this.panelVol.add(this.rad1);
		this.panelVol.add(this.rad2);
		
		// on saisie la date
		this.panelDate = new JPanel();
		this.txt2 = new JLabel("Saisir la date de depart : ");
		String[] tabJour = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22",
				"23","24","25","26","27","28","29","30","31"};
		String[] tabMois = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		this.txtJour = new JLabel("Jour: ");
		this.listeJ = new JComboBox(tabJour); // liste deroulante de tout les jours que l'on peut selectionner
		this.listeJ.setPreferredSize(new Dimension(100,20));
		this.txtMois = new JLabel("Mois: ");
		this.listeM = new JComboBox(tabMois);// litse deroulante de tout les mois que l'on peut selectionner
		this.listeM.setPreferredSize(new Dimension(100,20));
		this.txtAnnee = new JLabel("Annee: ");
		this.txtf2 = new JTextField();
		this.txtf2.setPreferredSize(new Dimension(100,20));
		this.panelDate.add(this.txt2);
		this.panelDate.add(this.txtJour);
		this.panelDate.add(this.listeJ);
		this.panelDate.add(this.txtMois);
		this.panelDate.add(this.listeM);
		this.panelDate.add(this.txtAnnee);
		this.panelDate.add(this.txtf2);
		
	    //On crée l'objet JComboBox
		/*On ajoute des éléments à la liste déroulante. Ces éléments sont de type IndexLibelle et comprennent deux champs correspondant respectivement à l'attribut index et à l'attribut libelle.*/
		this.panelAD = new JPanel();
		this.txt4 = new JLabel("Selectionner Avion :");
		this.listeAvion = new JComboBox<IndexLibelle>();
	    ArrayList<Avion> liste = Modele.voirAvion();
	    for(int i=0;i<Modele.getNbAvion();i++){
	    	this.listeAvion.addItem(new IndexLibelle(liste.get(i).getNumAvion(),liste.get(i).getNomAvion()));
	    }
	    this.panelAD.add(this.txt4);
	    this.panelAD.add(this.listeAvion);
	    // On saisie la destination
	    this.txt3 = new JLabel("Saisir la destination : ");
	    this.listeDestination = new JComboBox<IndexLibelle>();
	    ArrayList<Destination> liste2 = Modele.voirDestination();
	    for(int i=0;i<Modele.getNbDestination();i++){
	    	this.listeDestination.addItem(new IndexLibelle(liste2.get(i).getNb(),liste2.get(i).getVille()));
	    }
		this.btn = new JButton("Valider");
		this.btn.addActionListener(this);
		this.panelAD.add(this.txt3);
		this.panelAD.add(this.listeDestination);
		this.panelAD.add(this.btn);
		
		this.add(this.panelVol);
		this.add(this.panelDate);
		this.add(this.panelAD);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btn){
			int taille = this.txtf2.getText().length(); // on recupere la taille de la chaine
			String mois = (String) this.listeM.getSelectedItem();//on recupere le mois selectionner
			String jour = (String) this.listeJ.getSelectedItem(); // on recupere le jour selectionner
			int idA = ((IndexLibelle) listeAvion.getSelectedItem()).getNumAvion();//id de l'avion selectionner
			int idD = ((IndexLibelle) listeDestination.getSelectedItem()).getNumAvion();//id de la destination
			LocalDate date;
			try{
				date =  LocalDate.parse(this.txtf2.getText()+"-"+mois+"-"+jour);//LocalDate localDate = LocalDate.parse(date);
			}catch(java.time.format.DateTimeParseException ec){
				date = null;
			}
			Date laDate = new Date(date); // on creer une nouvelle date
			if(taille==4  && !this.txtf2.getText().equals(null) && Modele.verifSaisie(this.txtf2.getText()) && 
					(Modele.getNbAvion()>0) && (Modele.getNbDestination()>0)){
				
				
				if(this.rad1.isSelected()){
					Modele.ajouteVolCourrier(laDate,idA,idD);
				}else{
					if(this.rad2.isSelected()){
						Modele.ajouteVolCourrier(laDate,idA,idD);
					}
				}
				JOptionPane.showMessageDialog(null, "Votre Vol a bien été ajouté ! ", "Information", JOptionPane.INFORMATION_MESSAGE);
				revalidate();
			}else{
				if((Modele.getNbAvion()==0)){
					JOptionPane.showMessageDialog(null, "Vous ne pouvez creer un vol aucun avion n'a été créer.",
							"Erreur", JOptionPane.ERROR_MESSAGE);
					revalidate();
				}else{
					if((Modele.getNbDestination()==0)){
						JOptionPane.showMessageDialog(null, "Vous ne pouvez creer un vol aucune destination n'a été créer.",
								"Erreur", JOptionPane.ERROR_MESSAGE);
						revalidate();
					}else{
						if(taille>=5){
							JOptionPane.showMessageDialog(null, "La date saisie est trop longue", "Erreur", JOptionPane.ERROR_MESSAGE);
							revalidate();
						}else{
							if(Modele.verifSaisie(this.txtf2.getText())){
								JOptionPane.showMessageDialog(null, "Ne pas saisir une lettre et/ou rentrez une date censé.",
										"Erreur", JOptionPane.ERROR_MESSAGE);
								revalidate();
							}else{
								JOptionPane.showMessageDialog(null, "Veuillez saisir tout les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
								revalidate();
							}
						}
					}
				}
			}
		}
	}
	
	
}