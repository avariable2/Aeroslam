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
	private ArrayList<Avion> lesAvions;
	
	
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
		this.lesAvions = Modele.voirAvion();
		this.txt4 = new JLabel("Selectionner Avion :");
		
		this.btn = new JButton("Valider");
		this.btn.addActionListener(this);
		
		this.add(this.txt1);
		this.add(this.rad1);
		this.add(this.rad2);
		this.add(this.txt2);
		this.add(this.txtf2);
		this.add(this.btn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btn){
			if(!this.txtf2.getText().equals(null) && !this.txtf1.getText().equals(null)){
				Modele.ajouteDestination(this.txtf1.getText(),this.txtf2.getText());
				this.txt3 = new JLabel("Votre Destination a bien été ajouter a la base de donnee.");
				this.add(this.txt3);
				revalidate();
			}else{
				this.txt3 = new JLabel("Veuillez saisir tout les champs.");
				this.add(this.txt3);
				revalidate();
			}
		}
	}
	
	
}